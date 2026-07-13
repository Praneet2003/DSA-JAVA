import java.util.*;
class Search_in_rotated_sorted_array{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int tar = sc.nextInt();
        System.out.println("The target Element "+tar+"is found at : "+binary(arr, 0, n-1, tar));
    }
    public static int binary(int arr[], int s, int e,int target){
        if(s>e){
            return -1;
        }
        int mid = s+(e-s)/2;
        if(arr[mid]==target){
            return mid;
        }
        if(arr[s]<=arr[mid]){//first half of the array is sorted. 
            if(arr[s]<=target && arr[mid]>=target){
                return binary(arr,s,mid-1,target);
            }else{
                return binary(arr,mid+1,e,target);
            }
        }
        if(arr[mid]<=target && arr[e]>=target){//second half of array is sorted.
            return binary(arr, mid+1,e, target);
        }
        return binary(arr,s,mid-1,target);//array is not sorted.
    }
}