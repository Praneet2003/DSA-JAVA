class Smallest_subarray_with_sum_greater_than_target{
    public static void main(String args[]){
        int arr[] = {2,3,1,2,4,3};
        int target = 7;
        int i = 0;
        int sum = 0;
        int j = 0;
        int n = arr.length;
        int minlen = Integer.MAX_VALUE;
        while(i<n){
            sum+=arr[i];
            while(sum>=target){
                minlen = Math.min(minlen,i-j+1);
                sum-=arr[j];
                j++;
            }
            i++;
        }
        System.out.println(minlen);
    }
}
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        int i = 0;
        int j = 0;
        int sum = 0;
        while(j<n){
            sum+=nums[j];
            while(sum>=target){
                min = Math.min(j-i+1,min);
                sum-=nums[i];
                i++;
            }
            j++;
        }
        return (min==Integer.MAX_VALUE)?0:min;
    }
}