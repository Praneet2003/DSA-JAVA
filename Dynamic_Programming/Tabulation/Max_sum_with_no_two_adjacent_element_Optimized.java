import java.util.*;
public class Max_sum_with_no_two_adjacent_element_Optimized {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int dp[] = new int[n];
        System.out.println(findmax(n, arr, dp));
    }
    public static int findmax(int n, int arr[], int dp[]){
        if(n==0){// no element is present in arr.
            return 0;
        }
        if(n==1){//only one element present.
            return arr[0];
        }
        int p1 = arr[0];
        int p2 = Math.max(arr[0],arr[1]);
        for(int i = 2;i<n;i++){
            int pick = arr[i]+p1;
            int notpick = p2;
            p1 = p2;
            p2 = Math.max(pick,notpick);
        }
        return p2;
    }
}