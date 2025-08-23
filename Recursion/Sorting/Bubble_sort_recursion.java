import java.util.*;
class Bubble_sort_recursion{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        bubble_sort(arr,n-1,0);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubble_sort(int arr[],int r,int c){
        if(r==0){
            return;
        }
        if(c<r){
            if(arr[c]>arr[c+1]){
                int temp = arr[c];
                arr[c] = arr[c+1];
                arr[c+1] =temp;
            }
            bubble_sort(arr, r, c+1);
        }else{
            bubble_sort(arr, r-1, 0);
        }
    }
}