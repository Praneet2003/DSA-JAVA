import java.util.*;
class Reverse_method2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = reverse(n);
        System.out.println("The reverse of number "+n+" is: "+ans);
    }
    static int reverse(int n){
        int digits = (int)(Math.log10(n))+1;
        return helper(n,digits);
    }
    static int helper(int n, int digits){
        if(n%10==n){
            return n;
        }
        int rem = n%10;
        return rem*(int)(Math.pow(10,digits-1))+helper(n/10, digits-1);
    }
}