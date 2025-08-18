import java.util.*;
class Count_zeroes_in_n{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = count_zero(n);
        System.out.println("Number of zeroes in "+n+" is: "+ans);
    }
    static int count_zero(int n){
        int count=0;
        return helper(n,count);
    }
    static int helper(int n,int count){
        int rem = n%10;
        if(n==0){
            return count;
        }
        if(rem==0){
            return helper(n/10, count+1);
        }
        return helper(n/10,count);
    }
}