import java.util.*;
class Rotated_binary_search{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] =sc.nextInt();
        }
        int s = 0;
        int e = n-1;
        int target = sc.nextInt();
        int res = binary_Search(arr,s,e,target);
        if(res!=-1){
            System.out.println("Elemnt found at: "+res);
        }else{
            System.out.println("Element not found!");
        }
    }
    public static int binary_Search(int arr[],int s, int e, int target){
        if(s>e){
            return -1;
        }
        int mid = s+(e-s)/2;
        if(arr[mid]==target){
            return mid;
        }
        if(arr[s]<=arr[mid]){//if 1st half is sorted.
            if(target>=arr[s] && target<=arr[mid]){//checking if the target element is present in the 1st half.
                // e = mid-1
                return binary_Search(arr, s, mid-1, target);
            }else{// got for the 2nd half
                // s = mid+1
                return binary_Search(arr, mid+1, e, target);
            }
        }
        if(target>=arr[mid] && target<=arr[e]){//if 2nd half is sorted and target is in this range.
            // s = mid+1
            return binary_Search(arr, mid+1, e, target);
        }
        // if not sorted then search on s to mid range.
        return binary_Search(arr, s, mid-1, target);
    }
}
// 8
// 5 6 7 8 9 1 2 3
// 2
// Elemnt found at: 6