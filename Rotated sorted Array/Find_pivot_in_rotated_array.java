import java.util.Arrays;
import java.util.Scanner;
//pivot is the largest element in the array
class Find_pivot_in_rotated_array{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int pivot = find_pivot(arr);
        System.out.println("The pivot element is the rotated array "+Arrays.toString(arr)+" is: "+pivot);
    }
    public static int find_pivot(int arr[]){
        int s = 0;
        int e = arr.length-1;
        if(arr[s]<arr[e]){//array is already sorted.
            return -1;
        }
        while(s<=e){
            int mid = s+(e-s)/2;
            if(mid<e && arr[mid]>arr[mid+1]){
                return mid;
            }if(s<mid && arr[mid-1]>arr[mid]){
                return mid-1;
            }
            if(arr[s]<=arr[mid]){
                s = mid+1;
            }else{
                e = mid-1;
            }
        }
        return -1;
    }
}