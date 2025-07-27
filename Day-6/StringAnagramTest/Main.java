import java.util.Arrays;
public class Main
{
	public static void main(String[] args) {
	    String str1 = "listen";
	    String str2 = "silent";
	    if(str1.length() == str2.length()){
    	    char[] ch1 = str1.toCharArray();
    	    char[] ch2 = str2.toCharArray();
    	    Arrays.sort(ch1);
    	    Arrays.sort(ch2);
    	    str1 = new String(ch1);
    	    str2 = new String(ch2);
    	    System.out.println(str1.equals(str2) ? "Anagram" : "Not an Anagram");
	    }
	    else
	        System.out.println("Not an Anagram");
	}
}
