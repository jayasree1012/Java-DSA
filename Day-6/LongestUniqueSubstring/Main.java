import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    String str = sc.next();
	    String crntStr = "";
	    String maxStr = "";
	    for(char ch : str.toCharArray()){
	        int ind = crntStr.indexOf(ch);
	        if(ind != -1)
	            crntStr = crntStr.substring(ind + 1);
	       crntStr += ch;
	       if(crntStr.length() > maxStr.length())
	            maxStr = crntStr;
	    }
	    System.out.println(maxStr);
	}
}
