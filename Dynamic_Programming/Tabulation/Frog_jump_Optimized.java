import java.util.*;
public class Frog_jump_Optimized {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//n>=0
        int height[] = new int[n];
        for(int i =0;i<n;i++){
            height[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        System.out.println("The enery need by frog is: "+obj.frog_jump(n-1, height));
    }
}
class Solution{
    public int frog_jump(int n, int height[]){
        if(n==0){
            return 0;
        }
        int prev2 = 0;
        int prev1 = Math.abs(height[1]-height[0]);
        if(n==1){
            return prev1;
        }
        for(int i=2;i<=n;i++){
            int step1 = prev1+Math.abs(height[i]-height[i-1]);
            int step2 = prev2+Math.abs(height[i]-height[i-2]);
            int curr = Math.min(step1,step2);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
