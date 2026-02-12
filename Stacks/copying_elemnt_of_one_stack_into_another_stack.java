import java.util.*;
public class copying_elemnt_of_one_stack_into_another_stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<n;i++){
            int x = sc.nextInt();
            stack.push(x);
        }
        Stack<Integer> res = getcopied(stack);
        System.err.println(res);
    }
    public static Stack<Integer> getcopied(Stack<Integer> stack){
        if(stack.isEmpty()){
            return stack;
        }
        int val = stack.pop();
        getcopied(stack);
        stack.push(val);
        return stack;
    }    
}
