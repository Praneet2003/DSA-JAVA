//you have to find maximim path sum starts from any cell of first row and ends at and cell of last row
import java.util.*;
class maximum_path_sum_from_1st_row_to_last_row{
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
        System.out.println("The maximum path from 1row to the last row is: "+obj.max_path(arr));     
    }
}
class Solution{
    public int max_path(int arr[][]){
        int n = arr.length;
        int m = arr[0].length;
        int max = Integer.MIN_VALUE;
        int dp[][] = new int[n][m];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        for(int i=0;i<m;i++){
            max = Math.max(max,max_path(0,i,arr,dp));
        }
        return max;
    }
    public int max_path(int i, int j, int arr[][], int dp[][]){
        if(j<0 || j>=arr[0].length){
            return Integer.MIN_VALUE;
        }
        if(i==arr.length-1){
            return arr[i][j];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int down = max_path(i+1,j,arr,dp);
        int left = max_path(i+1,j-1,arr,dp);
        int right = max_path(i+1,j+1,arr,dp);
        dp[i][j] = arr[i][j]+Math.max(down,Math.max(left, right));
        return dp[i][j];
    }
}