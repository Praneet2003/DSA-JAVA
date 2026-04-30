import java.util.*;
class Unique_path_in_maze_with_obstacles{
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
        System.out.println("The number of unique paths in the given maze is: "+obj.No_of_unique_ways_in_maze(arr));
    }
}
class Solution{
    public int No_of_unique_ways_in_maze(int arr[][]){
        int n = arr.length;
        int m = arr[0].length;
        int dp[][] = new int[n][m];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return no_of_paths(n-1, m-1,arr,dp);
    }
    public int no_of_paths(int n, int m,int arr[][], int dp[][]){
        if(m==0 && n==0 && arr[n][m]==0){
            return 1;
        }
        if(n<0 || m<0){
            return 0;
        }
        if(arr[n][m]==1){
            return 0;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        int up = no_of_paths(n-1, m, arr, dp);
        int down = no_of_paths(n, m-1, arr, dp);
        dp[n][m] = up+down;
        return dp[n][m];
    }
}