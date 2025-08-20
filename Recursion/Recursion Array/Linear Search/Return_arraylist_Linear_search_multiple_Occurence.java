import java.util.*;
class Return_arraylist_Linear_search_multiple_Occurence{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        ArrayList<Integer> list = linear_search(arr, target, 0, new ArrayList<>());
        System.out.println(list);
    }
    static ArrayList<Integer> linear_search(int arr[],int target,int index, ArrayList<Integer>list){
        if(index==arr.length){
            return list;
        }if(arr[index]==target){
            list.add(index);
        }
        return linear_search(arr, target, index+1, list);
    }
}