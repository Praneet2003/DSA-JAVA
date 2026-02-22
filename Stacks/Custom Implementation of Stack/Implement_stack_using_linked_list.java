import java.util.*;
public class Implement_stack_using_linked_list {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack1<Integer> stack = new Stack1<>(5);
        int n = sc.nextInt();
        for(int i = 0;i<n;i++){
            int x = sc.nextInt();
            stack.push(x);
        }
        System.out.println(stack);
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }    
}
class Stack1<T>{
    ListNode head = null;
    ListNode tail = null;
    int size;
    int len;
    public Stack1(int len){
        this.len = len;
        this.size = 0;
    }
    class ListNode{
        T val;
        ListNode next;
        public ListNode(T val){
            this.val = val;
            this.next = null;
        }
    }
    public void insert_at_end(T val){
        ListNode node = new ListNode(val);
        if(head==null){
            head = node;
            tail = head;
            size++;
            return;
        }
        tail.next = node;
        tail = tail.next;
        size++;
    }
    public T delete_from_end(){
        if(size==0||head==null){
            return null;
        }
        if(head==tail){
            T v = head.val;
            head = null;
            tail = null;
            size--;
            return v;
        }
        ListNode temp = head;
        while(temp.next!=tail){
            temp = temp.next;
        }
        T v = tail.val;
        tail = temp;
        tail.next = null;
        size--;
        return v;
    }
    public void push(T val){
        if(isFull()){
            System.out.println("STACK OVERFLOW!!");
            return;
        }
        insert_at_end(val);
    }
    public T pop(){
        T val = delete_from_end();
        if(val==null){
            System.out.println("STACK UNDERFLOW");
            return null;
        }
        return val;
    }
    public boolean isFull(){
        return size==len;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public T peek(){
        if(isEmpty()){
            System.out.println("STACk is Empty!!");
            return null;
        }
        return tail.val;
    }
    public int size(){
        return this.size;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        ListNode temp = head;
        while(temp != null){
            sb.append(temp.val).append(" ");
            temp = temp.next;
        }
        return sb.toString();
    }
}
