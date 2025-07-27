import java.util.*;
import java.lang.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        char[] a=s.toCharArray();
        String result="";
        for (int i = 0; i < a.length; i++) {
            char ch = a[i];
           
            if(i==0) {
                result+=Character.toUpperCase(a[i]);
                   
                }
            else if(a[i-1]==' '&& a[i]!=' '){
              result+=Character.toUpperCase(a[i]);  
            }    
            else{
                result+=a[i];
            }
            
            
            
        }
        System.out.print(result);
    }
}
