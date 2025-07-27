import java.util.Scanner;
import java.util.Arrays;

public class Main
{
    public static boolean toeplitMat(int n, int m, int[][] mat){
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < m-1; j++){
                if(mat[i][j] != mat[i+1][j+1]){
                    
                    return false;
                }
            }
        }
        return true;
    }
	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    int n = 3, m = 4;
	    int[][] mat = new int[n][m];
	    for(int i = 0; i < n; i++){
	        for(int j = 0; j < m; j++)
	            mat[i][j] = s.nextInt();
	    }
	    System.out.println(toeplitMat(n, m, mat));
	}
}
