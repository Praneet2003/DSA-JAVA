import java.util.*;
class Fibonacci_series_using_DP{
    static int DP[];
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DP= new int[n+1];
        Arrays.fill(DP,-1);
        System.out.println(n+" th Fibonacci number is: "+fibo(n));
    }
    public static int fibo(int n){
        if(n<=1){
            return n;
        }
        if(DP[n]!=-1){
            return DP[n];//already calucted answer from previous subproblem
        }
        DP[n] = fibo(n-1)+fibo(n-2);
        return DP[n];//returning the nth fibonacci number
    }
}