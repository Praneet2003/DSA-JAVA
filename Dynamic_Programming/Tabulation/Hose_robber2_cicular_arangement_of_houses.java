import java.util.*;
public class Hose_robber2_cicular_arangement_of_houses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        System.out.println(obj.max_profit(arr));
    }
}
class Solution{
    public int max_profit(int arr[]){
        int n = arr.length;
        if(n==0){
            return 0;
        }
        if(n==1){
            return arr[0];
        }
        int case1 = findmax(Arrays.copyOfRange(arr,0,n-1));//skip last.
        int case2 = findmax(Arrays.copyOfRange(arr,1,n));//skip first.
        return Math.max(case1, case2);
    }
    public int findmax(int arr[]){
        int n = arr.length;
        if(n==0){
            return 0;
        }if(n==1){
            return arr[0];
        }
        int dp[] = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0],arr[1]);
        for(int i =2;i<n;i++){
            int pick = arr[i]+dp[i-2];
            int notpick = dp[i-1];
            int curr = Math.max(pick, notpick);
            dp[i] = curr;
        }
        return dp[n-1];
    }
}
