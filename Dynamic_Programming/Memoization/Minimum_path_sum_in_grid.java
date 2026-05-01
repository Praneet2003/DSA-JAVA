import java.util.*;
class Minimum_path_sum_in_grid{
    public static void main(String[] args) {
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
        System.out.println("THe minimim cost to reach from (0,0) to (n-1,m-1) is: "+obj.find_min_cost(arr));
    }
}
class Solution{
    public int find_min_cost(int arr[][]){
        int n = arr.length;
        int m = arr[0].length;
        int dp[][] = new int[n][m];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return min_path(n-1,m-1,arr,dp);
    }
    public int min_path(int n, int m, int arr[][], int dp[][]){
        if(n<0||m<0){
            return Integer.MAX_VALUE;
        }
        if(n==0 && m==0){
            return arr[0][0];
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        int up = min_path(n-1, m, arr, dp);
        int left = min_path(n,m-1,arr,dp);
        dp[n][m] = arr[n][m]+Math.min(left,up);
        return dp[n][m];
    }
}
// 5 5
// 10 3 1 1 1
// 1 1 3 14 4
// 3 2 1 5 2
// 3 4 1 1 1
// 1 1 1 1 1