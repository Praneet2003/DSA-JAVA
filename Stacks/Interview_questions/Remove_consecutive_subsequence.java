import java.util.*;
class Remove_consecutive_subsequence{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.err.println(Arrays.toString(Removeconsecutivesubsequence(arr)));
    }
    public static int[] Removeconsecutivesubsequence(int []arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while(i<n){
            int count = 1;
            while(i+1<n && arr[i]==arr[i+1]){
                count++;
                i++;
            }
            if(count ==1){
                stack.push(arr[i]);
            }
            i++;
        }
        int []res = new int[stack.size()];
        for(int j = stack.size()-1;j>=0;j--){
            res[j] = stack.pop();
        }
        return res;
    }
}