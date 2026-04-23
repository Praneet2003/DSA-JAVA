import java.util.*;
class House_robber_2_circular_arrangement{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        System.out.println("Maximum profit that the robber can gain without getting caught is: "+obj.max_profit(arr));
    }
}
class Solution{
    public int max_profit(int arr[]){
        int n = arr.length;
        if(n==0){
            return 0;
        }if(n==1){
            return arr[0];
        }
        int leave_last = find_max(Arrays.copyOfRange(arr,0,n-1));
        int leave_first = find_max(Arrays.copyOfRange(arr,1,n));
        return Math.max(leave_first,leave_last);
    }
    public int find_max(int arr[]){
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0],arr[1]);
        return findmax(arr,n-1,dp);
    }
    private int findmax(int arr[], int i, int dp[]){
        if(i==0){
            return arr[0];
        }
        if(i<0){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int pick = arr[i]+findmax(arr, i-2,dp);
        int notpick = findmax(arr, i-1,dp);
        dp[i] = Math.max(pick,notpick);
        return dp[i];
    }
}