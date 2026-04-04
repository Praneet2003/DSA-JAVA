import java.util.*;
public class Frog_jump_using_dp {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int height[] = new int[n];
        for(int i =0;i<n;i++){
            height[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        obj.dp = new int[n];
        Arrays.fill(obj.dp,-1);
        System.out.println("The minimum energy required to reach at the top is: "+obj.get_min_energy_required(n-1,height));
    }
}
class Solution{
    int dp[];
    public int get_min_energy_required(int n, int height[]){
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int left =  get_min_energy_required(n-1, height)+(int)Math.abs(height[n]-height[n-1]);
        int right = Integer.MAX_VALUE;
        if(n>1){
            right = get_min_energy_required(n-2, height)+(int)Math.abs(height[n-2]-height[n]);
        }
        dp[n] = Math.min(left,right);
        return dp[n];
    }
}
//Input:
//n= 6
//height[] = 30 10 60 10 60 50
// Output:
// The minimum energy required to reach at the top is: 40