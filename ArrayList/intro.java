import java.util.ArrayList;
import java.util.Collections;
class intro{
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>(10);// here 10 is added as initial capacity in the constructor.
        // 1. add(element) => used to add elements in the arraylist.
        list.add(10);
        list.add(20);
        list.add(45);
        list.add(29);
        list.add(11);
        list.add(450);
        System.err.println(list);
        // 2. contains(element) => return true if element is present and returns false if it is not present in the ArrayList.
        System.out.println(list.contains(20));
        // 3. set(element) => used to replace an existing element with an other element.
        list.set(0,99);//it will set 99 at 0 index
        // 4. remove(element) => used to remove the specific element form the list.
        list.remove(3);
        System.err.println(list);
        // 5. get(index) => used to get the element of the list using index.
        System.out.println(list.get(3));
        Collections.sort(list);
        System.out.println(""+list);
        Collections.sort(list,Collections.reverseOrder());
        System.out.println(""+list);
        Collections.reverse(list);
        System.out.println(""+list);
    }
}