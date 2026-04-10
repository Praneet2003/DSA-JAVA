import java.util.*;
class maximum_sum_with_no_two_adjacent_element{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        System.out.println(findmax(n-1,arr,dp));
    }
    public static int findmax(int n, int arr[], int dp[]){
        if(n==0){
            return arr[0];
        }
        if(n<0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int pick = arr[n]+findmax(n-2, arr, dp);
        int notpick = findmax(n-1, arr, dp);
        dp[n] = Math.max(pick,notpick);
        return dp[n];
    }
}