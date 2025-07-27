import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();

		int[][] a = new int[r][c];


		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				a[i][j] = sc.nextInt();
			}
		}


		for (int col = 0; col < c; col++) {
			for (int k = 0; k < r - 1; k++) {
				for (int row = 0; row < r - 1 - k; row++) {
					if (a[row][col] > a[row + 1][col]) {

						int temp = a[row][col];
						a[row][col] = a[row + 1][col];
						a[row + 1][col] = temp;
					}
				}
			}
		}


		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}

