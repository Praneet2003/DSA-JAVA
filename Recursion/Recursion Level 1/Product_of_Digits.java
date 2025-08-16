import java.util.*;
class Product_of_Digits{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//1342
        int ans = digit_product(n);
        System.out.println("Product of all digits in"+n+" are: "+ans);
    }
    public static int digit_product(int n){
        if(n%10==n){
            return n;
        }
        int m = n%10;
        return m*digit_product(n/10);
    }
}