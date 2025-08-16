import java.util.*;
class Print_1_to_n{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        print(n);
    }
    public static void print(int n){
        if(n==0){
            return;
        }
        print(n-1);
        System.out.print(n+" ");//ye statement tb hi work krega jb sare function call stack me load ho jaye.
        // ye bahar ki baat hai
    }
}