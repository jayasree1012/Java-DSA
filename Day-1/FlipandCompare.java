import java.util.Scanner;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter Number: ");
        int n1 = sc.nextInt();
        System.out.print("Enter Number: ");
        int n2 = sc.nextInt();
        int num1 = 0,num2 = 0 ;
        while(n1>0){
            int digit = n1 % 10;
            num1 = num1 * 10 + digit;
            n1 = n1 / 10;
        }
        while(n2>0){
            int digit = n2 % 10;
            num2 = num2 * 10 + digit;
            n2 = n2 / 10;
        }
        if (num1 > num2){
            System.out.println(num1);
        }
        else{
            System.out.println(num2);
        }
    }
}