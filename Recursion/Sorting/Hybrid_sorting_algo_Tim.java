//Tim sort: merge sort + insertion sort.
// inbuilt algo used as Arrays.sort(arr);
// time complexity: best- O(n), average and worst - O(nlogn).
import java.util.*;
class Hybrid_sorting_algo_Tim{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
// 7
// 27 43 3 9 82 10 3
// [3, 3, 9, 10, 27, 43, 82]