import java.util.*;
public class Reverse_a_stack_using_recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> stack = new ArrayList<>();
        for(int i = 0;i<n;i++){
            int x = sc.nextInt();
            stack.add(x);
        }
        Solution obj = new Solution();
        obj.reverseStack(stack);
    }
}
class Solution {
    public static void reverseStack(Stack<Integer> st) {
        if(st.size()==0){
            return;
        }
        int data = st.peek();
        st.pop();
        reverseStack(st);
        insert(st,data);
    }
    public static void insert(Stack<Integer> st, int val){
        if(st.isEmpty()){
            st.push(val);
            return;
        }
        int top = st.pop();
        insert(st,val);
        st.push(top);
    }
}
