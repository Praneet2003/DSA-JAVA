import java.util.*;
class Pattern2_triangle{
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
            func(r,c+1);
            System.out.print("* ");
        }else{
            func(r-1,0);
            System.out.println();
        }
    }
}
// 5

// *
// * *
// * * *
// * * * *
// * * * * *