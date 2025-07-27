import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int rows=sc.nextInt();
		int cols=sc.nextInt();
		int[][] matrix=new int[rows][cols];
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				matrix[i][j]=sc.nextInt();
			}
		}
		int sum=0,revsum=0;
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(i==j) {
					sum+=matrix[i][j];
				}
				if(i+j==rows-1) {
					revsum+=matrix[i][j];
				}
			}
		}
		System.out.println(revsum-sum);

	}
}
