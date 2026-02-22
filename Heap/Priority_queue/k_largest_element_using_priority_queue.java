import java.util.*;
public class k_largest_element_using_priority_queue {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(approach1(arr,k));
        System.out.println(approach2(arr, k));
    }
    public static int approach1(int arr[],int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0;i<arr.length;i++){
            queue.offer(arr[i]);
        }
        int i = 1;
        while(i<k){
            queue.poll();
            i++;
        }
        return queue.peek();
    }
    public static int approach2(int arr[],int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0;i<arr.length;i++){
            queue.offer(arr[i]);
            if(queue.size()>k){
                queue.poll();
            }
        }
        return queue.peek();
    }
}
