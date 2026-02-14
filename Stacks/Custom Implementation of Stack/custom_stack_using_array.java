import java.util.*;
public class custom_stack_using_array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x1 = 5;
        Stack1<Integer> stack= new Stack1<>(x1);
        for(int i = 0;i<n;i++){
            int x = sc.nextInt();
            stack.push(x);
        }
        System.out.println("poping from empty stack: "+stack.pop());
        System.out.println("Trying to get the peak element from empty stack: "+stack.peek());
        System.out.println(stack.size());
    }    
}
class Stack1<T>{
    int size = 0;
    ArrayList<T> list;
    int index = -1;
    public Stack1(int size){
        this.size = size;
        list = new ArrayList<>(size);
    }
    public void push(T val){
        if(isFull()){
            System.out.println("STACK OVERFLOW! Cannot push elements");
            return;
        }
        list.add(val);
        index++;
    }
    public T pop(){
        if(index==-1){
            System.out.print("STACK UNDERFLOW! Stack is Empty, Nothing to delete");
            return null;
        }
        return list.remove(index--);
    }
    public boolean isEmpty(){
        if(index==-1){
            return true;
        }
        return false;
    }
    public boolean isFull(){
        return index==size-1;
    }
    public T peek(){
        if(!isEmpty()){
            return list.get(index);
        }
        return null;
    }
    public int size(){
        return index+1;
    }
}
