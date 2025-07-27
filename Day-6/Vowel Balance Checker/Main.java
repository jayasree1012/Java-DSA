import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        // Handle case-insensitivity
        str = str.toLowerCase();

        // Calculate midpoint (include middle char in 1st half if odd-length)
        int mid = (str.length() + 1) / 2;

        String s1 = str.substring(0, mid);
        String s2 = str.substring(mid);

        int v1 = countVowels(s1);
        int v2 = countVowels(s2);

        System.out.println("Vowels in first half: " + v1);
        System.out.println("Vowels in second half: " + v2);
        System.out.println("Absolute difference: " + Math.abs(v1 - v2));

        if (v1 > v2)
            System.out.println("First half has more vowels.");
        else if (v2 > v1)
            System.out.println("Second half has more vowels.");
        else
            System.out.println("Both halves have equal vowels.");
    }

    // Helper method to count vowels in a string
    public static int countVowels(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if ("aeiou".indexOf(ch) != -1) count++;
        }
        return count;
    }
}
