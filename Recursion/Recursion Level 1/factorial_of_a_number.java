import java.util.*;
class factorial_of_a_number{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = factorial(n);
        System.out.println("The Factorial of "+n+" is: "+ans);
    }
    public static int factorial(int n){
        if(n<=1){
            return 1;
        }
        return n*factorial(n-1);
    }
}