import java.util.Scanner;
import java.util.Arrays;

public class Main
{
	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    int n = 3, m = 3;
	    int[][] mat = new int[n][m];
	    for(int i = 0; i < n; i++){
	        for(int j = 0; j < m; j++)
	            mat[i][j] = s.nextInt();
	    }
	    for(int i = 0; i < n; i++){
	        Arrays.sort(mat[i]);
	    }
	    System.out.println(Arrays.deepToString(mat));

	}
}
