
import java.util.ArrayList;
import java.util.Scanner;

class Swap_alternate{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(sc.nextInt());
        }
        for(int i=1;i<5;i+=2){
            int temp = list.get(i-1);
            list.set(i-1,list.get(i));
            list.set(i,temp);
        }
        System.out.println(list);
    }
}