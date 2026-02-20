import java.util.*;
public class Heap_sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int n = sc.nextInt();
        for(int i = 0;i<n;i++){
            int x = sc.nextInt();
            list.add(x);
        }
        Solution obj = new Solution();
        obj.HeapSort(list);
    }    
}
class Solution{
    public void heapify(List<Integer> list, int i,int size){
        int max = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if(left<size && list.get(left)>list.get(max)){
            max = left;
        }
        if(right<size && list.get(right)>list.get(max)){
            max = right;
        }
        if(max!=i){
            int temp = list.get(max);
            list.set(max,list.get(i));
            list.set(i,temp);
            heapify(list, max,size);
        }
    }
    public void HeapSort(List<Integer> list){
        int n = list.size();
        for(int i = n-1;i>=0;i--){
            heapify(list,i,n);
        }
        for(int i = n-1;i>0;i--){
            int temp = list.get(0);
            list.set(0,list.get(i));
            list.set(i,temp);
            heapify(list,0,i);
        }
        display(list);
    }
    public void display(List<Integer> list){
        System.out.println(list);
    }
}
