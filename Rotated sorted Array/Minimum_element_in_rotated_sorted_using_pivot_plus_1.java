import java.util.*;
class Minimum_element_in_rotated_sorted_using_pivot_plus_1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int pivot = find_pivot(arr);
        int min = (pivot+1)%n;
        System.out.println("The index of minimum element is: "+min);
    }
    public  static int find_pivot(int arr[]){
        int s = 0;
        int e = arr.length-1;
        if(arr[s]<arr[e]){
            return -1;
        }
        while(s<=e){
            int mid = s+(e-s)/2;
            if(mid<e && arr[mid]>arr[mid+1]){
                return mid;
            }
            if(s<mid && arr[mid-1]>arr[mid]){
                return mid-1;
            }
            if(arr[s]>=arr[mid]){
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return -1;
    }
}