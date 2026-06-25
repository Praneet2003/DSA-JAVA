import java.util.*;
class Insertion_sort{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(insertion_sort(arr)));
    }
    public static int[] insertion_sort(int arr[]){
        int n = arr.length;
        for(int i=1;i<n;i++){
            int k = arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>k){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = k;
        }
        return arr;
    }
}