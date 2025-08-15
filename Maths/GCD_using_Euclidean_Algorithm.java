import java.util.*;
class GCD_using_Euclidean_Algorithm{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int res = GCD(a, b);
        System.out.println(res);
    }
    public static int GCD(int a,int b){
        if(a==0){
            return b;
        }
        return GCD(b%a, a);
    }
}
