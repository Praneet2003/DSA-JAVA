// if n is even n = n/2 else n=n-1.
import java.util.*;
class Number_of_steps_to_reduce_n_to_0{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int steps = count_steps(n);
        System.out.println("The no of step to reduce number to 0 is: "+steps);
    }
    public static int count_steps(int n){
        int count =0;
        return helper(n,count);
    }
    public static int helper(int n, int count){
        if(n==0){
            return count;
        }
        if(n%2==0){
            return helper(n/2,count+1);
        }
        return helper(n-1,count+1);
    }
}