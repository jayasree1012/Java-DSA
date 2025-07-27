import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Convert to lowercase for case-insensitive comparison
        input = input.toLowerCase();

        // Optional: Remove non-letter characters
        input = input.replaceAll("[^a-z]", ""); // keep only a-z

        Map<Character, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;

        // Count frequencies
        for (char ch : input.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(ch));
        }

        // Find characters with max frequency
        List<Character> maxChars = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == maxFreq) {
                maxChars.add(entry.getKey());
            }
        }

        // Output result
        System.out.println("Most frequent character(s):");
        for (char ch : maxChars) {
            System.out.println("'" + ch + "' appears " + maxFreq + " times");
        }
    }
}
