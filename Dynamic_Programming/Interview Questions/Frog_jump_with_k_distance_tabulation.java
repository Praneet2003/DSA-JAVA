import java.util.*;
public class Frog_jump_with_k_distance_tabulation {
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
        System.out.println("The minimum energy required to reach at top when k distance jumps where allowed is: "+obj.Frog_jump(n-1, k,height));
    }
}
class Solution{
    int dp[];
    public int Frog_jump(int n,int k, int height[]){
        if(n==0){
            return 0;
        }
        dp[0] = 0;
        for(int i = 0;i<n;i++){
            int min = Integer.MAX_VALUE;
            for(int j =1;j<=k;j++){
                if(i-j>=0){
                    int steps = dp[i-j]+Math.abs(height[i]-height[i-j]);
                    min = Math.min(min,steps);
                }
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
