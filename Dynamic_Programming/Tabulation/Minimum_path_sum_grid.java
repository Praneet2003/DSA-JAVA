import java.util.*;
class Minimum_path_sum_grid{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        Solution obj = new Solution();
         System.out.println("THe minimum path sum in the given grid is: "+obj.min_path(arr));
    }
}
class Solution{
    public int min_path(int arr[][]){
        int n = arr.length;
        int m = arr[0].length;
        int dp[][] = new int[n][m];
        return min_path(arr,dp);
    }
    private int min_path(int arr[][], int dp[][]){
        int n = arr.length;
        int m = arr[0].length;
        dp[0][0] = arr[0][0];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    continue;
                }
                int down = i>0 ? dp[i-1][j]:Integer.MAX_VALUE;
                int right = j>0 ?dp[i][j-1]:Integer.MAX_VALUE;
                dp[i][j] = arr[i][j]+Math.min(down,right);
            }
        }
        return dp[n-1][m-1];
    }
}