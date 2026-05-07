import java.util.*;
class Triangle{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][];
        for(int i =0;i<n;i++){
            arr[i] = new int[i+1];
            for(int j = 0;j<i+1;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        Solution obj = new Solution();
        System.out.println("The minimum cost to reach at the bottom row int he triangle is: "+obj.min_cost_path(arr));
    }
}
class Solution{
    public int min_cost_path(int arr[][]){
        int n = arr.length;
        int dp[][] = new int[n][n];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return min_path(0,0,arr,dp);
    }
    private int min_path(int i, int j, int arr[][], int dp[][]){
        if(i==arr.length-1){
            return arr[i][j];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int down = min_path(i+1, j, arr, dp);
        int diagonal = min_path(i+1, j+1, arr, dp);
        dp[i][j] = arr[i][j]+Math.min(down,diagonal);
        return dp[i][j];
    }
}