import java.util.*;
public class Next_Greater_element_in_stack {
    public static void main(String args[]){
        int arr[] = {1,3,2,1,8,6,3,4};
        arr = getnextgreater(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
    public static int[] getnextgreater(int arr[]){
        Stack<Integer> stack = new Stack<>();
        int i = arr.length-1;
        while(i>=0){
            int curr = arr[i];
            while(!stack.isEmpty() && stack.peek()<arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                arr[i]=-1;
            }else{
                arr[i] = stack.peek();
            }
            stack.push(curr);
            i--;
        }
        return arr;
    }
}

