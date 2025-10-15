import java.util.*;
class Check_Palindrome_number{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int reversed_no = reverse(n);
        if(reversed_no==n){
            System.out.println("The number "+n+" is a Palindrome.");
        }else{
            System.out.println("The number "+n+" is not a Palindrome.");
        }
    }
    public static int reverse(int n){
        int digits = (int)(Math.log10(n))+1;
        return helper(n,digits);
    }
    public static int helper(int n,int digits){
        if(n%10==n){
            return n;
        }
        int rem = n%10;
        return rem*(int)(Math.pow(10,digits-1))+helper(n/10, digits-1);
    }
}