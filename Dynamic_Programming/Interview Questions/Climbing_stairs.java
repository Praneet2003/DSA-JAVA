// you are given n stairs and you have to reach at the top (i.e on nth stair).
// either you can jump 1 stair or 2 stair.
// you need to return the distinct no of ways in which you can reach at the top
import java.util.*;
public class Climbing_stairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution obj = new Solution();
        obj.dp = new int[n+1];
        Arrays.fill(obj.dp,-1);
        System.out.println(obj.getno_of_ways(n));
    }
}
class Solution{
    int dp[];
    public int getno_of_ways(int n){
        if(n<=1){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n] = getno_of_ways(n-1)+getno_of_ways(n-2);
        return dp[n];
    }
}
