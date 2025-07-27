public class Main
{
	public static void main(String[] args) {
	    String str = "Education is at the height of understanding";
	    for(int i = 0; i < str.length(); i++){
	        if("aeiouAEIOU".indexOf(str.charAt(i)) != -1)
	            str = str.replace(str.charAt(i), '@');
	    }
	    System.out.println(str);
	}
