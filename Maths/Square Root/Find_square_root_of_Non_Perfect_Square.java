//Binary Search method.
import java.util.*;
class Find_square_root_of_Non_Perfect_Square{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = 3;//decimal places needed.
        double mid = binary(n,p);
        System.out.println(mid);
    }
    public static double binary(int n,int p){
        int s = 0;
        int e = n;
        int mid = s+(e-s)/2;
        int intpart = 0;
        double root =0.0;
        while(s<=e){
            if(mid*mid==n){
                return mid;
            }else if(mid*mid>n){
                e = mid-1;
            }else{
                intpart = mid;//storing the last mid where (mid)^2<=n for int part.
                s=mid+1;
            }
            mid = s+(e-s)/2;
        }
        double incr = 0.1;
        root+=intpart;
        for(int i=0;i<p;i++){
            while(root*root<=n){
                root+=incr;
            }
            root-=incr;
            incr/=10;
        }
        return root;
    }
}