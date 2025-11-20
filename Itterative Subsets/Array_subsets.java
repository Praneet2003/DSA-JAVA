import java.util.*;
class Array_subsets{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int idx = 0; idx < n; idx++) {
            arr[idx] = sc.nextInt();   
        }
        List<List<Integer>> ans = subsets(arr);
        System.out.print(ans);
        // for(List<Integer> list:ans){
        //     System.out.print(list);
        // }
    }
    public static List<List<Integer>> subsets(int arr[]){
        List<List<Integer>> outer = new ArrayList<>();
        // adding an empty arraylist.
        outer.add(new ArrayList<>());
        for(int num:arr){
            int n = outer.size();
            for(int i=0;i<n;i++){//as we are copying the previous array,we have make new inner list n times.
                List<Integer> inner = new ArrayList<>(outer.get(i));//making copy of the previous lists.
                inner.add(num);
                outer.add(inner);
            }
        }
        return outer;
    }
}