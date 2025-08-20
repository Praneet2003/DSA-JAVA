import java.util.*;
class Linear_search_using_recursion{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int index = Linear_search(arr,target,0);
        if(target !=-1){
            System.out.println("Target "+target+" Found at index "+index);
        }else{
            System.out.println("Target "+target+" Not Found.");
        }
    }
    public static int Linear_search(int arr[],int target,int index){
        if(index==arr.length-1){
            return -1;
        }
        if(arr[index]==target){
            return index;
        }
        return Linear_search(arr, target, index+1);
    }
}