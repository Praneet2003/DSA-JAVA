import java.util.*;
public class Deletion_in_max_heap {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Heap obj = new Heap();
        for(int i = 0;i<5;i++){
            int n = sc.nextInt();
            obj.insert(n);
        }
        obj.display();
        obj.delete();
        obj.display();
    }
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
    public int delete(){
        if(list.size()==0){
            return -1;
        }x
        int del = list.get(0);
        list.set(0,list.get(list.size()-1));
        list.remove(list.size()-1);
        downheap(0);
        return del;
    }
    private void downheap(int i){
        int max = i;
        int left = left(i);
        int right = right(i);
        if(left<list.size() && list.get(left)>list.get(i)){
            max = left;
        }
        if(right<list.size() && list.get(right)>list.get(i)){
            max = right;
        }
        if(max!=i){
            int temp = list.get(i);
            list.set(i,list.get(max));
            list.set(max,temp);
            downheap(max);
        }
    }
    public void display(){
        System.out.println(list);
    }
}
