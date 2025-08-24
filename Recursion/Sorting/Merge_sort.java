import java.util.*;
class Merge_sort{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));//here the original array is not modified.
        System.out.println(Arrays.toString(mergeSort(arr)));
    }
    static int[] mergeSort(int arr[]){
        if(arr.length==1){
            return arr;
        }
        int mid = arr.length/2;
        int left[] = mergeSort(Arrays.copyOfRange(arr, 0,mid));
        int right[] = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left,right);
    }
    static int[] merge(int first[], int second[]){
        int sorted[] = new int[first.length + second.length];
        int i=0;
        int j =0;
        int k =0;
        while(i<first.length && j<second.length){
            if(first[i]<second[j]){
                sorted[k++] = first[i];
                i++;
            }else{
                sorted[k++] = second[j];
                j++;
            }
        }
        while(i<first.length){
            sorted[k++] = first[i++];
        }
        while(j<second.length){
            sorted[k++] = second[j++];
        }
        return sorted;
    }
}