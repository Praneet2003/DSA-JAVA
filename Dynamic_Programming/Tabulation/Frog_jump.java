import java.util.*;
public class Frog_jump {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int height[] = new int[n];
        for(int i =0;i<n;i++){
            height[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        obj.dp = new int[n];
        System.out.println(obj.Frog_jump(n-1,height));
    }
}
class Solution{
    int dp[];
    public int Frog_jump(int n,int []height){
        if(n==0){
            return 0;
        }
        dp[0] = 0;
        for(int i =1;i<=n;i++){
            int step1 = dp[i-1]+Math.abs(height[i]-height[i-1]);
            int step2 = Integer.MAX_VALUE;
            if(i>1){
                step2 = dp[i-2]+Math.abs(height[i]-height[i-2]);
            }
            dp[i] = Math.min(step1,step2);
        }
        return dp[n];
    }
}
