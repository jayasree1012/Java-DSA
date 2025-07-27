/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
public class SortingUsingSortMethod
{


public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] a=new int[n];
    for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
        
    }
   
  Arrays.sort(a);
  for(int i=0;i<n;i++){
        System.out.println(a[i]+" ");
      
  }

}
}