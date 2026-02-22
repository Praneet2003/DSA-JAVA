import java.util.*;
public class SImple_priority_queue_implementation {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(1);
        queue.offer(45);
        queue.offer(12);
        System.out.println("The peek element in PQ is: "+queue.peek());
        System.out.println("All element of by default queue is: ");
        while(!queue.isEmpty()){
            System.out.print(queue.peek()+" ");
            queue.poll();
        }
        System.out.println("\nThe other implementaion of PrioriyQueue with defined priority");
        PriorityQueue<Integer> queue1 = new PriorityQueue<>(Collections.reverseOrder());
        queue1.offer(10);
        queue1.offer(1);
        queue1.offer(40);
        queue1.offer(65);
        queue1.offer(1000);
        queue1.offer(123);
        queue1.offer(134);
        queue1.offer(1893);
        queue1.offer(134);
        queue1.offer(10);
        queue1.offer(12);
        while(!queue1.isEmpty()){
            System.out.print(queue1.poll()+" ");
        }
    }
}
// The peek element in PQ is: 1
// All element of by default queue is: 
// 1 10 12 20 45 
// The other implementaion of PrioriyQueue with defined priority
// 1893 1000 134 134 123 65 40 12 10 10 1 
