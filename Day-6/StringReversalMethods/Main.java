import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    String str = s.next();
	    for(int i = str.length()-1; i >= 0; i--)
	        System.out.print(str.charAt(i));
	    System.out.println();
	    StringBuilder sb = new StringBuilder(str);
	    sb.reverse();
	    System.out.println(sb);
	    StringBuffer sb1 = new StringBuffer(str);
	    sb1.reverse();
	    System.out.println(sb1);
	}
}
