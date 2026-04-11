import java.util.*;
public class climbimg_stairs_optimized_tabulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution obj = new Solution();
        System.out.println(" The no of ways to climb "+n+" stairs is: "+obj.getno_of_ways(n));
    }
}
class Solution{
    public int getno_of_ways(int n){
        if(n==0){
            return 1;
        }
        if(n<=2){
            return n;
        }
        int prev1 = 2;
        int prev2 = 1;
        for(int i = 3;i<=n;i++){
            int curr = prev1+prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
