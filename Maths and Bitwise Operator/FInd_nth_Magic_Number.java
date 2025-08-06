import java.util.*;
class FInd_nth_Magic_Number{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = n;
        int sum =0;
        int base = 5;
        int i=0;
        while(n>0){
            int last = n&1;
            n = n>>1;
            sum+=last*base;
            base=base*5;
        }
        System.out.println("The "+x+"th Magic number is "+sum);
    }
}