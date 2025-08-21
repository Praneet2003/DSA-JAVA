import java.util.*;
class Return_arraylist_without_passing_it_as_an_Argument{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        ArrayList<Integer> list = linear_Search(arr,target,0);
        System.out.println(list);
    }
    public static ArrayList<Integer> linear_Search(int arr[],int target,int index){
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(index==arr.length){
            return list;
        }
        if(arr[index]==target){
            list.add(index);
        }
        ArrayList<Integer> ansfrombelowCalls = linear_Search(arr, target, index+1);
        list.addAll(ansfrombelowCalls);
        return list;
    }
}