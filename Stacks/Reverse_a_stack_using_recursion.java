import java.util.*;
public class Reverse_a_stack_using_recursion {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<n;i++){
            int x = sc.nextInt();
            stack.push(x);
        }
        Solution obj = new Solution();
        Stack<Integer> res = obj.reverse(stack);
        System.out.println(res);
    }
}
class Solution{
    public Stack<Integer> reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return stack;
        }
        int val = stack.pop();
        reverse(stack);
        Insert_At_bottom(stack,val);
        return stack;
    }
    public void Insert_At_bottom(Stack<Integer> stack, int val){
        if(stack.isEmpty()){
            stack.push(val);
            return;
        }
        int v = stack.pop();
        Insert_At_bottom(stack, val);
        stack.push(v);
    }
}
