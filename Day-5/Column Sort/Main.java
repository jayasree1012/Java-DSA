import java.util.Scanner;
import java.util.Arrays;

public class Main
{
	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    int n = 4, m = 3;
	    int[][] mat = new int[n][m];
	    for(int i = 0; i < n; i++){
	        for(int j = 0; j < m; j++)
	            mat[i][j] = s.nextInt();
	    }
	    for(int i = 0; i < m; i++){
	        int[] a = new int[n];
	        for(int j = 0; j < n; j++){
	            a[j] = mat[j][i];
	        }
	        Arrays.sort(a);
	        for(int j = 0; j < n; j++){
	            mat[j][i] = a[j];
	        }
	    }
	    System.out.println(Arrays.deepToString(mat));
	}
}
