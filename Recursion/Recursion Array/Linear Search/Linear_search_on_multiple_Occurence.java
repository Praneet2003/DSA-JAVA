import java.util.*;
class Linear_search_on_multiple_Occurence{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        Linear_search(arr, target,0);
        // for(int i=0;i<list.size();i++){
        //     System.out.print(list.get(i)+" ");
        // }
        System.out.println(list);
    }
    static ArrayList<Integer> list = new ArrayList<Integer>();
    static void Linear_search(int arr[],int target,int index){
        if(index>arr.length-1){
            return;
        }
        if(arr[index]==target){
            list.add(index);
        }
        Linear_search(arr, target, index+1);
    }
}