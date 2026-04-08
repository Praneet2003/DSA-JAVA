import java.util.*;
public class Max_sum_with_no_two_adjacent_element {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int dp[] = new int[n];
        System.out.println(findmax(n, arr, dp));
        for(int i: dp){
            System.out.print(i+" ");
        }
    }
    public static int findmax(int n, int arr[], int dp[]){
        if(n==0){// no element is present in arr.
            return 0;
        }
        if(n==1){//only one element present.
            return arr[0];
        }
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0],arr[1]);
        for(int i=2;i<n;i++){
            int pick = arr[i]+dp[i-2];
            int notpick = dp[i-1];
            dp[i] = Math.max(pick,notpick);
        }
        return dp[n-1];
    }
}
// 6
// 5 5 10 100 10 5
// 110
// dp = [5 5 15 105 105 110]