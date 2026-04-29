import java.util.*;
class No_of_unique_ways_in_maze{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Solution obj = new Solution();
        System.out.println("The number of unique possible path is maze of "+m+" X "+n+" is: "+obj.no_of_paths(m,n));
    }
}
class Solution{
    public int no_of_paths(int m, int n){
        int dp[][] = new int[m][n];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return no_of_paths(m-1,n-1,dp);
    }
    public int no_of_paths(int m, int n, int dp[][]){
        if(m==0 || n==0){//if you either each at last row or col,i.e one path exists
            return 1;
        }
        if(m<0 || n<0){
            return 0;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        dp[m][n] = no_of_paths(m-1, n,dp)+no_of_paths(m, n-1,dp);
        for(int row[]:dp){
            System.out.println(Arrays.toString(row));
        }
        return dp[m][n];
    }
}