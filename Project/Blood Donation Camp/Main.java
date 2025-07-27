import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;


interface Notification {
    void send(String message, String to);
}

class SMSNotification implements Notification {
    public void send(String message, String to) {
        System.out.println("[SMS] to " + to + ": " + message);
    }
}

class EmailNotification implements Notification {
    public void send(String message, String to) {
        System.out.println("[Email] to " + to + ": " + message);
    }
}

class EligibilityChecker {
    static boolean isEligible(int age, double weight, boolean ill) {
        return age >= 18 && weight >= 50 && !ill;
    }
}

class Donor {
    private int id;
    private String name;
    private int age;
    private double weight;
    private String bloodGroup;
    private String contact;
    private int donationCount = 0;
    private int totalUnits = 0;
    private LocalDate lastDonationDate = LocalDate.MIN;

    public Donor(int id, String name, int age, double weight, String bloodGroup, String contact) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.bloodGroup = bloodGroup;
        this.contact = contact;
    }
    public void display() {
        System.out.println(id + ". " + name + " | Age: " + age + ", BG: " + bloodGroup +
                ", Total Donations: " + donationCount + ", Last: " + lastDonationDate);
    }
    public boolean canDonateToday() {
        return ChronoUnit.DAYS.between(lastDonationDate, LocalDate.now()) >= 56;
    }
    public void updateDonation(int units) {
        donationCount++;
        totalUnits += units;
        lastDonationDate = LocalDate.now();
    }
    public int getId() { return id; }
    public String getName() { return name; }
    public String getBloodGroup() { return bloodGroup; }
    public String getContact() { return contact; }
    public int getDonationCount() { return donationCount; }
    public int getTotalUnitsDonated() { return totalUnits; }
    public LocalDate getLastDonationDate() { return lastDonationDate; }
}

abstract class Donation {
    protected String bloodGroup;
    protected int units;
    protected LocalDate expiryDate;
    public Donation(String bg, int u) {
        bloodGroup = bg;
        units = u;
    }
    abstract void donate(BloodBank b, String donorId, String type);
}

class WholeBloodDonation extends Donation {
    public WholeBloodDonation(String bg, int u) { super(bg, u); }
    void donate(BloodBank b, String donorId, String type) {
        expiryDate = LocalDate.now().plusDays(35); // Whole blood expires in 35 days
        b.addStock(bloodGroup, units, expiryDate);
        System.out.println("Donated " + units + " units of Whole Blood.");
    }
}

class PlateletDonation extends Donation {
    public PlateletDonation(String bg, int u) { super(bg, u); }
    void donate(BloodBank b, String donorId, String type) {
        expiryDate = LocalDate.now().plusDays(5); // Platelets expire in 5 days
        b.addStock(bloodGroup, units, expiryDate);
        System.out.println("Donated " + units + " units of Platelets.");
    }
}

class BloodBank {
    private String name;
    private Map<String, List<StockEntry>> stock = new HashMap<>();
    public BloodBank(String name) {
        this.name = name;
    }
    public String getName() { return name; }

    public void addStock(String bg, int units, LocalDate expiry) {
        stock.putIfAbsent(bg, new ArrayList<>());
        stock.get(bg).add(new StockEntry(units, expiry));
    }

    public void showStock() {
        System.out.println("--- Stock in " + name + " ---");
        for (Map.Entry<String, List<StockEntry>> entry : stock.entrySet()) {
            int total = 0;
            for (StockEntry se : entry.getValue()) {
                if (!se.expiry.isBefore(LocalDate.now())) total += se.units;
            }
            System.out.println(entry.getKey() + ": " + total + " units");
        }
    }

    public boolean requestBlood(String bg, int units) {
        if (!stock.containsKey(bg)) return false;
        List<StockEntry> entries = stock.get(bg);
        entries.sort(Comparator.comparing(se -> se.expiry));
        int available = 0;
        for (StockEntry se : entries) if (!se.expiry.isBefore(LocalDate.now())) available += se.units;
        if (available < units) return false;

        int remaining = units;
        for (StockEntry se : entries) {
            if (se.expiry.isBefore(LocalDate.now())) continue;
            if (se.units <= remaining) {
                remaining -= se.units;
                se.units = 0;
            } else {
                se.units -= remaining;
                break;
            }
        }
        return true;
    }

    public int availableUnits(String bg) {
        if (!stock.containsKey(bg)) return 0;
        return stock.get(bg).stream()
            .filter(se -> !se.expiry.isBefore(LocalDate.now()))
            .mapToInt(se -> se.units).sum();
    }
}

class StockEntry {
    int units;
    LocalDate expiry;
    public StockEntry(int units, LocalDate expiry) {
        this.units = units;
        this.expiry = expiry;
    }
}

public class Main {
    private static Donor[] donors = new Donor[100];
    private static int donorCount = 0;
    private static BloodBank[] banks = {
        new BloodBank("Red Cross"), new BloodBank("City Hospital")
    };
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== Blood Donation Management =====");
            System.out.println("1.Register Donor  2.Donate Blood  3.View Donors");
            System.out.println("4.View Stock  5.Hospital Request  6.Top 5 Donors");
            System.out.println("7.Search by BG  8.Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt(); sc.nextLine();
            switch (choice) {
                case 1 -> registerDonor();
                case 2 -> donateBlood();
                case 3 -> viewDonors();
                case 4 -> viewStock();
                case 5 -> requestBlood();
                case 6 -> showTopDonors();
                case 7 -> searchByBloodGroup();
            }
        } while (choice != 8);
        System.out.println("Exiting...");
    }

    static void registerDonor() {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Age: ");
        int age = sc.nextInt(); sc.nextLine();
        System.out.print("Weight: ");
        double w = sc.nextDouble(); sc.nextLine();
        System.out.print("Blood Group: ");
        String bg = sc.nextLine().toUpperCase();
        System.out.print("Contact: ");
        String contact = sc.nextLine();
        System.out.print("Any recent illness? (true/false): ");
        boolean ill = Boolean.parseBoolean(sc.nextLine());

        for (int i = 0; i < donorCount; i++) {
            if (donors[i].getName().equalsIgnoreCase(name) &&
                donors[i].getContact().equals(contact)) {
                System.out.println("Donor already registered.");
                return;
            }
        }
        if (EligibilityChecker.isEligible(age, w, ill)) {
            donors[donorCount++] = new Donor(donorCount+1, name, age, w, bg, contact);
            System.out.println("Donor Registered Successfully.");
        } else {
            System.out.println("Donor Not Eligible.");
        }
    }

    static void donateBlood() {
        System.out.print("Donor ID: ");
        int id = sc.nextInt(); sc.nextLine();
        if (id < 1 || id > donorCount) {
            System.out.println("Invalid ID."); return;
        }
        Donor d = donors[id-1];
        d.display();
        System.out.print("Proceed? (Y/N): ");
        if (!sc.nextLine().equalsIgnoreCase("Y")) {
            System.out.println("Cancelled."); return;
        }
        if (!d.canDonateToday()) {
            System.out.println("Wait until: " + d.getLastDonationDate().plusDays(56));
            return;
        }

        System.out.println("Select Bank:");
        for (int i = 0; i < banks.length; i++) System.out.printf("%d. %s\n", i+1, banks[i].getName());
        int bc = sc.nextInt(); sc.nextLine();
        BloodBank b = banks[bc-1];

        System.out.print("1.Whole Blood 2.Platelets: ");
        int t = sc.nextInt(); sc.nextLine();
        String type = t==1 ? "Whole" : "Platelet";

        System.out.print("Units: ");
        int units = sc.nextInt(); sc.nextLine();

        Donation don = t==1 ?
            new WholeBloodDonation(d.getBloodGroup(), units) :
            new PlateletDonation(d.getBloodGroup(), units);

        don.donate(b, String.valueOf(d.getId()), type);
        d.updateDonation(units);

        System.out.print("Notify via 1.SMS 2.Email: ");
        Notification n = sc.nextInt()==2 ? new EmailNotification() : new SMSNotification();
        sc.nextLine();
        n.send("Thanks for donating " + units + " units!", d.getContact());

        generateCertificate(d, b, type, units);
        b.showStock();
    }

    static void generateCertificate(Donor d, BloodBank b, String type, int units) {
        System.out.println("\n===== DONATION CERTIFICATE =====");
        System.out.println("Donor Name     : " + d.getName());
        System.out.println("Donor ID       : " + d.getId());
        System.out.println("Blood Group    : " + d.getBloodGroup());
        System.out.println("Donation Type  : " + type);
        System.out.println("Units Donated  : " + units);
        System.out.println("Bank Name      : " + b.getName());
        System.out.println("Date           : " + LocalDate.now());
        System.out.println("Thank you for your life-saving contribution!");
        System.out.println("================================\n");
    }

    static void viewDonors() {
        Donor[] arr = Arrays.copyOf(donors, donorCount);
        Arrays.sort(arr, Comparator.comparing(Donor::getName));
        for (Donor x : arr) x.display();
    }

    static void viewStock() {
        for (BloodBank b : banks) b.showStock();
    }

    static void requestBlood() {
        System.out.println("Select Bank:");
        for (int i = 0; i < banks.length; i++) System.out.printf("%d.%s\n", i+1, banks[i].getName());
        int bc = sc.nextInt(); sc.nextLine();
        BloodBank b = banks[bc-1];

        System.out.print("Blood Group: ");
        String bg = sc.nextLine().toUpperCase();
        System.out.print("Units needed: ");
        int u = sc.nextInt(); sc.nextLine();

        int avail = b.availableUnits(bg);
        if (b.requestBlood(bg, u)) {
            System.out.println("Request fulfilled.");
        } else {
            System.out.println("Insufficient stock. Available: " + avail);
        }
    }

    static void showTopDonors() {
        Donor[] arr = Arrays.copyOf(donors, donorCount);
        Arrays.sort(arr, (a,b) -> b.getDonationCount() - a.getDonationCount());
        System.out.println("\n--- Top 5 Donors ---");
        for (int i = 0; i < Math.min(5, arr.length); i++) {
            Donor d = arr[i];
            System.out.println("#" + (i+1) +": " + d.getName() +
              " | Donations: " + d.getDonationCount() +
              " | Units: " + d.getTotalUnitsDonated());
        }
    }

    static void searchByBloodGroup() {
        System.out.print("Enter part/full BG: ");
        String bg = sc.nextLine().toUpperCase();
        boolean found = false;
        for (int i = 0; i < donorCount; i++) {
            if (donors[i].getBloodGroup().contains(bg)) {
                donors[i].display();
                found = true;
            }
        }
        if (!found) System.out.println("No donors matching " + bg);
    }
}

