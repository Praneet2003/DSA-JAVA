import java.util.*;
public class minimum_no_brackets_to_remove_for_making_a_sequence_balanced {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(remove(s));
    }
    public static int remove(String s){
        int count = 0;
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        int i = 0;
        while(i<n){
            char c = s.charAt(i);
            if(c=='('){
                stack.push(c);
            }else if (c==')'){
                if(stack.isEmpty()){
                    count++;
                }else{
                    stack.pop();
                }
            }
            i++;
        }
        return count+stack.size();
    }
}
