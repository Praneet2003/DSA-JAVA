import java.util.*;
public class Insertion_max_heap {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Heap obj = new Heap();
        for(int i=0;i<9;i++){
            int n = sc.nextInt();
            obj.insert(n);
        }
        obj.display();
    }    
}
class Heap{
    ArrayList<Integer> list = new ArrayList<>();
    //insertion in heap takes time of O(log n)
    public void insert(int val){
        list.add(val);
        upheap(list.size()-1);
    }
    private int parent(int i){
        return (i-1)/2;
    }
    private void upheap(int i){
        int p = parent(i);
        if(list.get(p)<list.get(i)){//swap.
            int temp = list.get(p);
            list.set(p,list.get(i));
            list.set(i,temp);
            upheap(p);
        }
    }
    public void display(){
        for(int i = 0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
    }
}
// Input: 9 9 11 11 2 3 4 2 1
// Output: 11 11 9 9 2 3 4 2 1 (max element at the root acess time is O(1))
