public class Loops
{
	public static void main(String[] args) {
	    Integer num = 5678;
	    int temp = num;
	   // String numStr = num.toString();
	   //int count = numStr.length();
	   int count = 0;
	   while(num > 0){
	       num = num / 10;
	       count++;
	   }
	   num = temp;
	   //System.out.println("Count: "+ count);
	   //int power = 1;
	   int total = 0;
	   while(num > 0){
	       int a = num%10;
	       total += Math.pow(a, count--);
	       //System.out.println(total);
	       num = num / 10;
	   }
	   System.out.print(total);
	}
}