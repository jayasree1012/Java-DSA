import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int r=sc.nextInt();
		int c=sc.nextInt();
		int[][] a=new int[r][c];
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				a[i][j]=sc.nextInt();
			}
		}
		for(int i=0; i<r ; i++) {
			int f=0,l=c-1;
			while(f<l) {
				int temp=a[i][f];
				a[i][f]=a[i][l];
				a[i][l]=temp;
				f++;
				l--;
			}

		}
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(a[i][j]==0) {
					a[i][j]=1;
				}
				else {
					a[i][j]=0;
				}
			}
		}
		System.out.println();
		System.out.println("final ");
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
			    
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}

	}
}

