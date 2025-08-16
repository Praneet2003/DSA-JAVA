import java.util.*;
class Sum_of_n_numbers{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = sum(n);
        System.out.println("Sum of 1 to "+n+"is: "+ans);
    }
    public static int sum(int n){
        if(n==0){
            return 0;
        }
        return n+sum(n-1);
    }
}