class FoodItem {
    protected String itemId;
    protected String itemName;
    protected double unitPrice;
    protected int quantity;
    protected double subtotal;
    protected double gst;
    protected double discount;
    protected double total;

    public FoodItem(String itemId, String itemName, double unitPrice, int quantity) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public void calculateBill() {}

    public void displayDetails() {
        System.out.println("Food Item Record");
        System.out.println("ID " + itemId);
        System.out.println("Name " + itemName);
        System.out.println("Unit Price " + unitPrice);
        System.out.println("Quantity " + quantity);
    }
}

class DineIn extends FoodItem {
    private double serviceCharge;

    public DineIn(String itemId, String itemName, double unitPrice, int quantity, double serviceCharge) {
        super(itemId, itemName, unitPrice, quantity);
        this.serviceCharge = serviceCharge;
    }

    @Override
    public void calculateBill() {
        subtotal = unitPrice * quantity + serviceCharge;
        gst = subtotal * 0.05;
        total = subtotal + gst;
        if (total > 1000) discount = total * 0.10;
        else discount = 0;
        total -= discount;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Service Charge " + serviceCharge);
        System.out.println("Subtotal " + String.format("%.2f", subtotal));
        System.out.println("GST " + String.format("%.2f", gst));
        System.out.println("Discount " + String.format("%.2f", discount));
        System.out.println("Total Bill " + String.format("%.2f", total));
        System.out.println();
    }
}

class Takeaway extends FoodItem {
    private double packingCharge;

    public Takeaway(String itemId, String itemName, double unitPrice, int quantity, double packingCharge) {
        super(itemId, itemName, unitPrice, quantity);
        this.packingCharge = packingCharge;
    }

    @Override
    public void calculateBill() {
        subtotal = unitPrice * quantity + packingCharge;
        gst = subtotal * 0.05;
        total = subtotal + gst;
        if (total > 1000) discount = total * 0.10;
        else discount = 0;
        total -= discount;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Packing Charge " + packingCharge);
        System.out.println("Subtotal " + String.format("%.2f", subtotal));
        System.out.println("GST " + String.format("%.2f", gst));
        System.out.println("Discount " + String.format("%.2f", discount));
        System.out.println("Total Bill " + String.format("%.2f", total));
        System.out.println();
    }
}

class Delivery extends FoodItem {
    private double deliveryFee;

    public Delivery(String itemId, String itemName, double unitPrice, int quantity, double deliveryFee) {
        super(itemId, itemName, unitPrice, quantity);
        this.deliveryFee = deliveryFee;
    }

    @Override
    public void calculateBill() {
        subtotal = unitPrice * quantity + deliveryFee;
        gst = subtotal * 0.05;
        total = subtotal + gst;
        if (total > 1000) discount = total * 0.10;
        else discount = 0;
        total -= discount;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Delivery Fee " + deliveryFee);
        System.out.println("Subtotal " + String.format("%.2f", subtotal));
        System.out.println("GST " + String.format("%.2f", gst));
        System.out.println("Discount " + String.format("%.2f", discount));
        System.out.println("Total Bill " + String.format("%.2f", total));
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        FoodItem[] orders = new FoodItem[3];
        orders[0] = new DineIn("F101", "Paneer Butter Masala", 250.0, 4, 50.0);
        orders[1] = new Takeaway("F102", "Veg Biryani", 180.0, 2, 20.0);
        orders[2] = new Delivery("F103", "Chicken Pizza", 300.0, 4, 40.0);

        for (FoodItem order : orders) {
            order.calculateBill();
            order.displayDetails();
        }
    }
}
