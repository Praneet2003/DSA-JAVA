import java.util.*;
class First_Negative_in_every_window_of_size_k{
    public static void main(String[] args) {
        int arr[] = {-8,2,3,-6,10};
        int k = 2;
        Solution obj = new Solution();
        System.out.println(obj.firstNegInt(arr,k));
    }
}
class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        // code here
        List<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        int n = arr.length;
        Queue<Integer> queue = new LinkedList<>();
        while(j<n){
            if(arr[j]<0){
                queue.offer(arr[j]);
            }
            if(j-i+1==k){
                if(queue.isEmpty()){
                    res.add(0);
                }else{
                    res.add(queue.peek());
                }
                if(!queue.isEmpty() && arr[i]==queue.peek()){
                    queue.poll();
                }
                i++;
            }
            j++;
        }
        return res;
    }
}