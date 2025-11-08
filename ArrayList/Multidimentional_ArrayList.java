
import java.util.ArrayList;
import java.util.Scanner;

class Multidimentional_ArrayList{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        int n = sc.nextInt();
        for(int i=0;i<n;i++){//initializing by adding n no of list in the 2d list.
            matrix.add(new ArrayList<>());
        }
        for(int i=0;i<n;i ++){
            for(int j=0;j<n;j++){
                matrix.get(i).add(sc.nextInt());
            }
        }
        System.out.println("Element of the array list are: ");
        // for(ArrayList<Integer>i:matrix){
        //     for(int num: i){
        //         System.out.print(num);
        //         System.out.print(" ");
        //     }
        //     System.out.println("");
        // }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int x = matrix.get(i).get(j);
                System.out.print(x+" ");
            }
            System.out.println("");
        }
        System.out.println("Directly printing the ArrayList: "+matrix);
    }
}