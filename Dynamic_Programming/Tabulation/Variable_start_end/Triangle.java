import java.util.*;
class Triangle{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][];
        for(int i=0;i<n;i++){
            arr[i] = new int[i+1];
            for(int j=0;j<i+1;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        Solution obj = new Solution();
        System.out.println("The minimum cost to reach at the bottom row is: "+obj.min_cost_path(arr));
    }
}
class Solution{
    public int min_cost_path(int arr[][]){
        int n = arr.length;
        int dp[][] = new int[n][n];
        for(int i=0;i<n;i++){
            dp[n-1][i] = arr[n-1][i];
        }
        for(int i=n-2;i>=0;i--){
            for(int j = 0;j<=i;j++){
                int up = dp[i+1][j];
                int diagonalup = dp[i+1][j+1];
                dp[i][j] = arr[i][j]+Math.min(up,diagonalup);
            }
        }
        return dp[0][0];
    }
}