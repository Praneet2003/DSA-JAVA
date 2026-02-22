import java.util.*;
public class inbuilt_queue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
