import java.util.*;
class Duplicates_Array_subsets{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        List<List<Integer>> ans = subsets_duplicate(arr);
        System.out.println(ans);
    }
    public static List<List<Integer>> subsets_duplicate(int arr[]){
        Arrays.sort(arr);//in order to have duplicate elements together.
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int s =0;
        int e =0;
        for(int i=0;i<arr.length;i++){
            s=0;
            if(i>0 && arr[i]==arr[i-1]){
                s = e+1;
            }
            e = outer.size()-1;//updating end for the newly created subset.
            int n = outer.size();
            for(int j=s;j<n;j++){
                List<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(arr[i]);
                outer.add(inner);
            }
        }
        return outer;
    }
}