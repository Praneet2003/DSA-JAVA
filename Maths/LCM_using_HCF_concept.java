import java.util.*;
class LCM_using_HCF_concept{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int HCF = GCD(a,b);
        int LCM = (a*b)/HCF;
        System.out.println("LCM of "+a+", "+b+" is: "+LCM);
    }
    public static int GCD(int a, int b){
        if(a==0){
            return b;
        }
        return GCD(b%a,a);
    }
}