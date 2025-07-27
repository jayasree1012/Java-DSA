import java.util.*;

public class MergeTwoArrays {
    public static void main(String[] args) {
        int[] n = {5,7,9};
        int[] copy = Arrays.copyOf(n, 6); // Extend and fill with 0
        System.out.println(Arrays.toString(copy));

        int[] rangeCopy = Arrays.copyOfRange(n, 1, 3); // index 1 to 2
        System.out.println(Arrays.toString(rangeCopy));

        int[] filled = new int[4];
        Arrays.fill(filled, 10);
        System.out.println(Arrays.toString(filled));

        int searchIndex = Arrays.binarySearch(n, 5); // returns index of 5
        System.out.println(searchIndex);

        int[][] n1 = {{11, 22}, {33, 44}};
        int[][] n2 = {{11, 22}, {33, 44}};
        System.out.println(Arrays.deepEquals(n1, n2));

        
        int[] a = {10, 20, 30};//merge two arrays a and b
        int[] b = {40, 50, 60};
        int[] result = Arrays.copyOf(a, a.length + b.length); // create larger array

        for (int j = 0; j < b.length; j++) {
            result[a.length + j] = b[j]; // copy elements from b
        }

        System.out.println(Arrays.toString(result));
    }
}
