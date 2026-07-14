import java.util.*;
class Minimum_element_in_rotataed_sorted_array{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int smallest = find_smallest(arr); 
        System.out.println("The Minimum element is the rotated array "+Arrays.toString(arr)+" is: "+smallest);
    }
    public static int find_smallest(int arr[]){
        int s = 0;
        int e = arr.length-1;
        if(arr[s]<=arr[e]){
            return s;
        }
        while(s<e){
            int mid = s+(e-s)/2;
            if(arr[mid]>arr[e]){
                s = mid+1;
            }else{
                e = mid;
            }
        }
        return s;
    }
}