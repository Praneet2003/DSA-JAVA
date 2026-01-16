import java.util.*;
class Selection_sort_recursion_method2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Selection_sort(arr,n-1,0,0);
        System.out.println(Arrays.toString(arr));
    }
    public static void Selection_sort(int arr[],int r, int c, int max){
        if(r==0){
            return;
        }
        if(c<=r){
            if(arr[c]>arr[max]){
                Selection_sort(arr, r, c+1, c);
            }else{
                Selection_sort(arr, r, c+1, max);
            }
        }else{
            int temp = arr[max];
            arr[max] = arr[r];
            arr[r] = temp;
            Selection_sort(arr, r-1, 0, 0);
        }
    }
}