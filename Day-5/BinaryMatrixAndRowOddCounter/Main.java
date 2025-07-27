import java.util.Scanner;
import java.util.Arrays;
public class Main
{
	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    int n = 4, m = 4;
	    int[][] mat = new int[n][m];
	    for(int i = 0; i < n; i++){
	        for(int j = 0; j < m; j++)
	            mat[i][j] = s.nextInt();
	    }
	    for(int i = 0; i < n; i++){
	        for(int j = 0; j < m; j++){
	            mat[i][j] = mat[i][j] % 2;
	            System.out.print(mat[i][j] + " ");
	        }
	        System.out.println();
	    }
	    for(int i = 0; i < n; i++){
	        int cnt = 0;
	        for(int j = 0; j < m; j++){
	            if(mat[i][j] == 1)
	                cnt++;
	        }
	        System.out.print(cnt + " ");
	    }
	}
}
