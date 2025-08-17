import java.util.*;
class print_n_to_1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        print(n);
    }
    public static void print(int n){
        if(n==0){
            return;
        }
        System.out.print(n+" ");//ye statement function call ke stack me load hone ke saath saath hi work krega.
        //Yaha aandar ki baat hai.
        print(n-1); 
    }
}