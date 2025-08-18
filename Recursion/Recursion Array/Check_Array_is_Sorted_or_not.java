import java.util.*;
class Check_Array_is_Sorted_or_not{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        boolean ans = isSorted(arr); 
        System.out.println("Is the array sorted? "+ans);
    }
    public static boolean isSorted(int arr[]){
        int i=arr.length-1;
        return helper(arr,i); 
    }
    public static boolean helper(int arr[], int i){
        if(i==0){
            return true;
        }
        if(arr[i]<arr[i-1]){
            return false;
        }
        return helper(arr,i-1);
    }
}