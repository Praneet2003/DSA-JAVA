import java.util.*;
public class Valid_parenthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the parenthesis to check: ");
        String s = sc.next();
        Solution obj = new Solution();
        System.out.println(obj.isValid(s));
    }
}
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('||c=='{'||c=='['){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                if(c==')' && stack.peek()=='('){
                    stack.pop();
                }else if(c=='}' && stack.peek()=='{'){
                    stack.pop();
                }else if(c==']' && stack.peek()=='['){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.size()==0;
    }
}
