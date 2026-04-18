import java.util.*;
public class Frog_jump_with_k_distance_jumps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int height[] = new int[n];
        for(int i = 0;i<n;i++){
            height[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        Solution obj = new Solution();
        obj.dp = new int[n];
        Arrays.fill(obj.dp,-1);
        System.out.println("The minimum enenrgy need by from to reach at top where k jumps where allowed: "+obj.frog_jump(n-1,k,height));
    }
}
class Solution{
    int dp[];
    public int frog_jump(int n, int k, int height[]){
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1;i<=k;i++){//loop for jumping to k steps
            if(n-i>=0){
                int steps = frog_jump(n-i, k, height)+(int)Math.abs(height[n]-height[n-i]);
                min = Math.min(min,steps);
            }
        }
        dp[n] = min;
        return min;
    }
}
