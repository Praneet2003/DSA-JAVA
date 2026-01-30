import java.util.*;
class Selection_sort{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int res[] = Selection_sort_algo(arr);
        System.out.println(Arrays.toString(res));
    }
    public static int[] Selection_sort_algo(int []arr){
        int n = arr.length;
        for(int i=0;i<n;i++){
            int end = n-1-i;
            int maxIndex = getMaxIndex(arr,0,end);
            swap(arr,maxIndex,end);
        }
        return arr;
    }
    public static int getMaxIndex(int []arr, int s, int e){
        int max = s;
        for(int i=s+1;i<=e;i++){
            if(arr[max]<arr[i]){
                max = i;
            }
        }
        return max;
    }
    public static void swap(int []arr,int first, int second){
        int temp = arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}