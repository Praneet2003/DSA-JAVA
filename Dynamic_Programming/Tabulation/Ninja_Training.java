import java.util.*;
class Ninja_Training{
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
        System.out.print("The maximum merit point "+obj.ninjaTraining(arr));
    }
}
class Solution{
    public int ninjaTraining(int arr[][]){
        int n = arr.length;
        int dp[][] = new int[n][4];
        dp[0][0] = Math.max(arr[0][1],arr[0][2]);
        dp[0][1] = Math.max(arr[0][0],arr[0][2]);
        dp[0][2] = Math.max(arr[0][1],arr[0][0]);
        // dp[0][3] = Math.max(arr[0][1],arr[0][2],arr[0][0]); just for understanding purpose.
        dp[0][3] = Math.max(arr[0][0],Math.max(arr[0][1],arr[0][2]));
        for(int day=1;day<n;day++){
            for(int last =0;last<4;last++){
                int maxi =0;
                for(int task =0;task<3;task++){
                    if(last!=task){
                        int points = arr[day][task]+dp[day-1][task];
                        maxi = Math.max(maxi,points);
                    }
                }
                dp[day][last] = maxi;
            }
        }
        return dp[n-1][3];
    }
}