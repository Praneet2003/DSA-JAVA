import java.util.*;
class Pattern1_triangle{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        func(n,0);
    }
    public static void func(int r,int c){
        if(r==0){
            return;
        }
        if(c<r){
            System.out.print("* ");
            func(r,c+1);
        }else{
            System.out.println();
            func(r-1,0);
        }
    }
}
// 5
// * * * *
// * * *
// * *
// *