import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    String str = sc.next();
	    int[] cnt = new int[256];
	    for(char ch : str.toCharArray()){
	        cnt[ch]++;
	    }
	    boolean[] printed = new boolean[256];
	    for(char ch : str.toCharArray()){
	        if(!printed[ch]){
	            System.out.println(ch + ": " + cnt[ch]);
	            printed[ch] = true;
	        }
	    }
	}
}
