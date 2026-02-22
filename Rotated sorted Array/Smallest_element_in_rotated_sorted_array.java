import java.util.*;
public class Smallest_element_in_rotated_sorted_array {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            int x = sc.nextInt();
            arr[i] = x;
        }
        System.out.print("Minimum element: "+minimum(arr));
    }
    public static int minimum(int arr[]){
        int s = 0;
        int e = arr.length-1;
        while(s<e){
            int mid = s+(e-s)/2;
            if(arr[mid]>arr[e]){
                s = mid+1;
            }else{
                e = mid;
            }
        }
        return arr[s];
    }
}
