import java.util.*;
import java.lang.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        char[] a=s.toCharArray();
        String result="";
        for (int i = 0; i < a.length; i++) {
            char ch = a[i];
           
            if(i%2==0){
                result+=Character.toLowerCase(ch);
                   
                }
            
            else{
                result+=Character.toUpperCase(ch);
            }
            
        }
        System.out.print(result);
    }
}
