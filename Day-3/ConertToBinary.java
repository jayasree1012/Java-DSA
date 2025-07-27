import java.util.*;
public class ConertToBinary
{
	public static void sortNum(int n,int arr[]) {
		for(int i=0; i<n; i++) {
			int remainder = arr[i] % 2;
			arr[i] = remainder;
		}
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sortNum(n,arr);
	}
}
