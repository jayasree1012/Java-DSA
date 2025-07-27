import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    Scanner Sc = new Scanner(System.in);
	    String str = "hello";
	    for(int i = 0; i < str.length(); i++){
	        if(i % 2 == 1)
	            System.out.print(Character.toUpperCase(str.charAt(i)));
	        else
	            System.out.print(Character.toLowerCase(str.charAt(i)));
	    }
	}
}
