import java.util.*;
public class Delete_middle_element_from_the_stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<n;i++){
            int x = sc.nextInt();
            stack.push(x);
        }
        delete_mid(stack);
        System.out.println(stack);
    }
    public static void delete_mid(Stack<Integer> stack){
        int mid = stack.size()/2;
        delete_mid(stack,0,mid);
    }
    public static void delete_mid(Stack<Integer> stack,int i,int n){
        if(i==n){
            stack.pop();
            return;
        }
        int v = stack.pop();
        delete_mid(stack, i+1, n);
        stack.push(v);
    }
}
