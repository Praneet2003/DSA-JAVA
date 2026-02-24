// 5
// 1 4 5 2 3
// [5, Silver Medal, Gold Medal, 4, Bronze Medal]
//leetcode 506
import java.util.*;
public class Relative_ranking_of_elemets_in_array {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        System.out.println(Arrays.toString(obj.findRelativeRanks(arr)));
    }
}
class Solution {
    class Pair implements Comparable<Pair> {//java doesn't provide inbuilt pair to pass inside PriorityQueue, we have to define it seperately
        int first;
        int second;
        Pair(int f, int s) {
            first = f;
            second = s;
        }
        @Override
        public int compareTo(Pair p) {
            return Integer.compare(this.first, p.first);
        }
    }
    public String[] findRelativeRanks(int[] arr){
        String[] res = new String[arr.length];
        PriorityQueue<Pair> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0;i<arr.length;i++){
            queue.offer(new Pair(arr[i],i));
        }
        int i = 1;
        while(i<=arr.length && !queue.isEmpty()){
            Pair p = queue.poll();
            int val = p.second;
            if(i==1){
                res[val] = "Gold Medal";
            }else if(i==2){
                res[val] = "Silver Medal";
            }else if(i==3){
                res[val] = "Bronze Medal";
            }else{
                res[val] = Integer.toString(i);
            }
            i++;
        }
        return res;
    }
}