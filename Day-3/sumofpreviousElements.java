import java.util.*;
public class sumofpreviousElements
{
	public static void sumofpreviousElements(int n,int[] a) {


		for(int i=0; i<n; i++) {
			int sum=0;
			if(i==0) {
				System.out.print(a[i]+" ");
			}
			else {
				for(int j=0; j<i; j++) {
					sum+=a[j];

				}
				System.out.print(sum+" ");
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i=0; i<n; i++) {
			a[i]=sc.nextInt();
		}
		sumofpreviousElements(n,a);
	}
}