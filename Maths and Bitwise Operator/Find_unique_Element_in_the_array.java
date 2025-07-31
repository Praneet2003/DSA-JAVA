import java.util.*;
class Find_unique_Element_in_the_array{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // int arr[] = {2,3,4,1,2,1,3,6,4};  
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){//[2,3,4,1,2,1,3,6,4]
            arr[i] = sc.nextInt();
        }
        int res = 0;
        for(int i=0;i<arr.length;i++){
            res ^=arr[i];
        }
        System.out.println("The unique Element is: "+res);
    }
}