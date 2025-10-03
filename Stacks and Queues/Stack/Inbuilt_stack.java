import java.util.*;
class Inbuilt_stack{
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();//NOTE: <> are called as generics.
        stack.push(34);
        stack.push(45);
        stack.push(2);
        stack.push(9);
        stack.push(18);
        System.out.println("The peek element of stack is: "+stack.peek());
        System.out.println("The first(bottom) element of the stack: "+stack.firstElement());
        System.out.println("The size of stack(or No of Elements) is: "+stack.size());
        while(stack.size()!=0){
            System.out.println("Deleted: "+stack.pop());
        }
        if(stack.isEmpty()){
            System.out.println("Stack is Empty");
        }else{
            System.out.println("Stack is not empty");
        }
    }
}