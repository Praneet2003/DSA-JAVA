import java.util.*;
public class Deletion_from_min_heap {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Heap obj = new Heap();
        for(int i = 0;i<n;i++){
            int x = sc.nextInt();
            obj.insert(x);
        }
        obj.display();
        System.out.println("Deleted element is: "+obj.delete());
        obj.display();
    }    
}
class Heap{
    ArrayList<Integer> list = new ArrayList<>();
    private int parent(int i){
        return (i-1)/2;
    }
    private int left(int i){
        return 2*i+1;
    }
    private int right(int i){
        return 2*i+2;
    }
    public void insert(int val){
        list.add(val);
        upheap(list.size()-1);
    }
    private void upheap(int i){
        if(i==0){
            return;
        }
        int p = parent(i);
        if(list.get(p)>list.get(i)){
            int temp = list.get(i);
            list.set(i,list.get(p));
            list.set(p,temp);
            upheap(p);
        }
    }
    public int delete(){
        if(list.size()==0){
            return -1;
        }
        int del = list.get(0);
        list.set(0,list.get(list.size()-1));
        list.remove(list.size()-1);
        downheap(0);
        return del;
    }
    private void downheap(int i){
        int min = i;
        int left = left(i);
        int right = right(i);
        int n = list.size();
        if(left<n && list.get(left)<list.get(min)){
            min = left;
        }
        if(right<n && list.get(right)<list.get(min)){
            min = right;
        }
        if(min!=i){
            int temp = list.get(i);
            list.set(i,list.get(min));
            list.set(min,temp);
            downheap(min);
        }
    }
    public void display(){
        System.err.println(list);
    }
}
