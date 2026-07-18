import java.util.Scanner;
class Search_in_rotated_sorted_Pivot_method{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int tar = sc.nextInt();
        int pivot = find_pivot(arr);
        System.out.println("The pivot element is: "+pivot);
        if(pivot==-1){
            System.out.println("Array is not rotated.");
            System.out.println("The target element found at: "+binary_search(arr, 0, n-1, tar));
        }else{
            if(tar == arr[pivot]){
                System.out.println("The target element found at: "+pivot);
            }else{
                int left = binary_search(arr, 0, pivot, tar);
                int right= binary_search(arr,pivot+1,n-1,tar);
                if(left==-1 && right==-1){
                    System.out.println("The target element not found in the rotated array.");
                }else if(left==-1){
                    System.out.println("The target element is found at: "+right);
                }else{
                    System.out.println("The target element is found at: "+left);
                }
            }
        }
    }
    public static int find_pivot(int arr[]){
        int n = arr.length;
        int s = 0;
        int e = n-1;
        if(arr[0]< arr[e]){//already sorted
            return -1;
        }
        while(s<=e){
            int mid = s+(e-s)/2;
            //case1. mid is peak itself.
            if(mid<e && arr[mid]>arr[mid+1]){
                return mid;
            }if(mid>s && arr[mid-1]>arr[mid]){
                return mid-1;
            }
            if(arr[s]>=arr[mid]){//pivot in left half 
                 e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return e;
    }
    public static int binary_search(int arr[], int s, int e, int tar){
        while(s<=e){
            int mid = s+(e-s)/2;
            if(arr[mid]==tar){
                return mid;
            }else if(arr[mid]>tar){
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return -1;//not found.
    }
}