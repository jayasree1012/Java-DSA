import java.util.*;
public class EqualArraysOrNot 
{
	
public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int c=sc.nextInt();
    int[] a=new int[n];
    int[] b=new int[n];
    for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
        
    }
    for(int i=0;i<n;i++){
        b[i]=sc.nextInt();
        
    }
   Arrays.equals(a,b);
   System.out.println(Arrays.equals(a,b));
   
}
}