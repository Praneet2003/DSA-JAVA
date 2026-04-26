import java.util.*;
public class Ninja_Training{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][3];
            for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        Solution obj = new Solution();
        System.out.println("The Maximum merit point that ninja can attain during n days training is: "+obj.ninjaTraining(n,arr));
    }
}
class Solution {
    public static int ninjaTraining(int n, int points[][]) {
        int dp[][] = new int[n][4];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return getmaxmerit(points,n-1,3,dp);
    }
    public static int getmaxmerit(int arr[][], int n, int t,int dp[][]){
        if(n==0){
            int max = 0;
            for(int i=0;i<3;i++){
                if(i!=t){
                    max = Math.max(arr[n][i],max);
                }
            }
            dp[n][t] = max;
            return dp[n][t];
        }
        if(dp[n][t]!=-1){
            return dp[n][t];
        }
        int maxi =0;
        for(int i=0;i<3;i++){
            if(i!=t){
                int point = arr[n][i]+getmaxmerit(arr,n-1,i,dp);
                maxi = Math.max(point,maxi);
            }
        }
        dp[n][t] = maxi;
        return dp[n][t];
    }
}