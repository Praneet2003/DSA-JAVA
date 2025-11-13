import java.util.ArrayList;
import java.util.Scanner;
class Taking_input_in_ArrayList{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
        }
        list.remove(3);
        System.out.println("ArrayList is: \n"+list);
        System.out.println("Traversing an ArrayList: ");
        for(int i=0;i<list.size();i++){// if you use her i<n i will give an exception of out of bound.
            System.out.print(list.get(i)+" ");// as like array you cannot get the element by arr[index].
        }
    }
}