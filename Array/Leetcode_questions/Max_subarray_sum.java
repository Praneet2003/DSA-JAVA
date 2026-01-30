// Input: arr[] = [2, 3, -8, 7, -1, 2, 3]
// Output: 11
// Explanation: The subarray [7, -1, 2, 3] has the largest sum 11.
// Input: arr[] = [-2, -4]
// Output: -2
// Explanation: The subarray [-2] has the largest sum -2.
// Input: arr[] = [5, 4, 1, 7, 8]
// Output: 25
// Explanation: The subarray [5, 4, 1, 7, 8] has the largest sum 25.
//kadenes algorithm
import java.util.*;
public class Max_subarray_sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        System.out.println(obj.maxSubarraySum(arr));
    }
}
class Solution {
    int maxSubarraySum(int[] arr) {
        // Code here
        int sum = 0;
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            max = Math.max(max,sum);
            if(sum<0){
                sum = 0;
            }
        }
        return max;
    }
}
