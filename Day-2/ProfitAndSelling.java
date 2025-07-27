import java.util.*;

public class ProfitAndSelling {
    public static void findMinMax(int n, int arr[]) {
        int min = arr[0];
        int minindex = 0;

        // Find min and minindex only
        for (int i = 1; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minindex = i;
            }
        }

        // Now find max to the right of minindex
        int max = arr[minindex + 1];
        for (int i = minindex + 2; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println(min);
        System.out.println( max);
        System.out.println(max-min);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        findMinMax(n, arr);
    }
}