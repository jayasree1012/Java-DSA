import java.util.*;
import java.lang.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		char[] reverse=str.toCharArray();
		int left=0;
		int right=str.length()-1;
		while(left<right) {
			char temp=reverse[left];
			reverse[left]=reverse[right];
			reverse[right]=temp;
			left++;
			right--;
		}
		if(reverse[left]==reverse[right]){
		    	System.out.println("palindrome");
		    
		}
		else{
		    	System.out.println("not palindrome");
		}
		String result=new String(reverse);
		System.out.print(result);


	}
}
