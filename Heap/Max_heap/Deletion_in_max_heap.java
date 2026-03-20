import java.util.*;
public class Deletion_in_max_heap {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Heap obj = new Heap();
        for(int i = 0;i<13;i++){
            int n = sc.nextInt();
            obj.insert(n);
        }
        obj.display();
    }.
}
class Heap{
    ArrayList<Integer> list =new ArrayList<>();
    public void insert(int val){
        list.add(val);
        upheap(list.size()-1);//jo vi latest element add hoga wo sare upar ke parents se compare hokr aapne sahi index pe jayega.
    }
    private int parent(int i){
        return (i-1)/2;
    }
    private int left(int i){
        return 2*i+1;
    }
    private int right(int i){
        return 2*i+2;
    }
    private void upheap(int i){
        if(i==0){
            return;
        }
        int p = parent(i);
        if(list.get(p)<list.get(i)){
            int temp = list.get(p);
            list.set(p,list.get(i));
            list.set(i, temp);
            upheap(p);
        }
    }
    private void downheap(int i){
        int max = i;
        int left = left(i);
        int right = right(i);
        max = Math.max(max,Math.max(list.get(left),list.get(right)));
    }
}
