
import java.util.Scanner;

public class Product_of_array_except_self{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Solution obj = new Solution();
        int res[] = obj.productExceptSelf(arr);
        for(int i=0;i<n;i++){
            System.out.print(res[i]+" ,");
        }
        
    }
}
class Solution {
    public int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int []temp = new int[n];
        int prefix[] = new int[n];
        int suffix[] = new int[n];
        int prod =1;
        for(int i=0;i<n;i++){
        prod = prod*arr[i]; 
        prefix[i] = prod;
        }
        prod = 1;
        for(int i=n-1;i>=0;i--){
        prod = prod*arr[i]; 
        suffix[i] = prod;
        }
        prod =1;
        for(int i=0;i<n;i++){
        if(i!=0 && i!=n-1){
            temp[i] = prefix[i-1]*suffix[i+1];
        }else if(i==0){
            temp[i] = suffix[i+1];
        }else{
            temp[i] = prefix[i-1];
        }
        }
        return temp;
    }
}