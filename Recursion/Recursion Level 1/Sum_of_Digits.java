import java.util.*;
class Sum_of_Digits{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//1342
        int ans = digitsum(n);
        System.out.println("Sum of all digits in"+n+" are: "+ans);
    }
    public static int digitsum(int n){
        if(n==0){
            return 0;
        }
        int m = n%10;
        return m+digitsum(n/10);
    }
}