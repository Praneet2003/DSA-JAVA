import java.util.*;
class Reverse_method1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Reverse_a_number(n);
        System.out.println("The reversed number is: "+rev);
    }
    static int rev=0;
    static void Reverse_a_number(int n){
        if(n==0){
            return;
        }
        int digit = n%10; 
        rev=rev*10+digit;
        Reverse_a_number(n/10);
    }
}