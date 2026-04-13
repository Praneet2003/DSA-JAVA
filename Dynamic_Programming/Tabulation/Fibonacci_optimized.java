import java.util.*;
public class Fibonacci_optimized {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n+" th fibonacci number is: "+fibo(n));
    }
    public static int fibo(int n){
        if(n<=1){
            return n;
        }
        int prev2 = 0;//storing prev-> prev
        int prev1 = 1;//storing prev
        int curr = -1;
        for(int i=2;i<=n;i++){
            curr = prev1+prev2;
            prev2 = prev1;
            prev1=curr;
        }
        return curr;
    }
}
