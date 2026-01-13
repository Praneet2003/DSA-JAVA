import java.util.*;
class Method2_Check_Array_is_Sorted_or_not{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        boolean ans = isSorted(arr,0);
        System.out.println("The array is Sorted? "+ans);
    }
    public static boolean isSorted(int arr[], int index){
        if(index==arr.length-1){
            return true;
        }
        return arr[index]<arr[index+1] && isSorted(arr, index+1);
    }
}