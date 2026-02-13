import java.util.*;
public class Insert_at_bottom_of_Stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<n;i++){
            int x = sc.nextInt();
            stack.push(x);
        }
        int val = sc.nextInt();
        Stack<Integer> res = insert_At_Bottom(stack,val);
        System.out.println("recursive approach: "+res);
        Stack<Integer> res1 = insert_bottom(stack,val);
        System.out.println("Itterative approach: "+res1);
    }
    //recursive_Approach.
    public static Stack<Integer> insert_At_Bottom(Stack<Integer> stack,int val){
        if(stack.isEmpty()){
            stack.push(val);
            return stack;
        }
        int v = stack.pop();
        insert_At_Bottom(stack, val);
        stack.push(v);
        return stack;
    }    
    public static Stack<Integer> insert_bottom(Stack<Integer> stack, int v){
        Stack<Integer> temp = new Stack<>();
        while(stack.size()!=0){
            temp.push(stack.pop());
        }
        temp.push(v);// remove all element from stack then push the value at the end 
        while(temp.size()!=0){
            stack.push(temp.pop());// pushing all remaining element again in the stack
            
        }
        return stack;
    }
}
