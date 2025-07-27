import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    String str = s.next();
	    char[] chars = str.toCharArray();
	    int cnt = 0;
	    String v = "";
	    String c = "";
	    for(char ch : chars){
	        if(!(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')){
	            System.out.print(ch);
	            c += ch;
	            cnt++;
	        }
	        else
	            v += ch;
	    }
	    System.out.println();
	    System.out.println(v + c);
	    System.out.println(cnt);
	}
}
