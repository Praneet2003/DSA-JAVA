import java.util.*;
public class Insert_in_minheap {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Heap obj = new Heap();
        for(int i = 0;i<n;i++){
            int x = sc.nextInt();
            obj.insert(x);
        }
        obj.display();
        obj.insert(19);
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
    public void display(){
        System.out.println(list);
    }
}
