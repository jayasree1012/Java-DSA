import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int row=sc.nextInt();
		int col=sc.nextInt();
		
		int[][] a=new int[row][col];
		for(int i=0;i<row;i++){
		    for(int j=0;j<col;j++){
		        a[i][j]=sc.nextInt();
		       
		    }
		}
		int max=a[0][0],min=a[0][0];
		for(int i=0;i<row;i++){
		    for(int j=0;j<col;j++){
		       
		        if (a[i][j]>max){
		          
		            max=a[i][j];
		        }   
		        if(a[i][j]<min){
		            min=a[i][j];
		            
		        }
		       
		        
		    }
		}
		System.out.println(max+min);
	}
}
