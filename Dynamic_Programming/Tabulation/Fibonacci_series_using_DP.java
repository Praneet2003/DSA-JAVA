import java.util.*;
public class Fibonacci_series_using_DP {
    static int dp[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.print(n+" th fibonacci number is: "+fibo(n));
    }
    public static int fibo(int n){
        if(n<=1){
            return n;
        }
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }    

}
