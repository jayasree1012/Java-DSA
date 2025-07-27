import java.util.Scanner;
class BalancedNumber{
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter Number: ");
        int num = sc.nextInt();
        int temp = num,count = 0;
        int rev_num= 0;
        int left_sum = 0,right_sum = 0;
        while (temp>0){
            int digit = temp % 10;
            rev_num = rev_num * 10 + digit;
            temp = temp / 10;
            count ++;
        } 
        int mid = count / 2;
        int left_count =0,right_count = 0; 
        while(left_count < mid){
            int digit1 = rev_num % 10;
            left_sum = left_sum + digit1;
            rev_num = rev_num / 10;
            int digit2 = num % 10;
            right_sum = right_sum + digit2;
            num = num / 10;
            left_count ++;
        }
        if(right_sum == left_sum){
            System.out.println("Balanced");
        }
        else{
            System.out.println("Not Balanced");
        }
    }
}