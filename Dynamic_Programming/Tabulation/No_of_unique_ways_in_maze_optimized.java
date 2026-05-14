import java.util.*;
class No_of_unique_ways_in_maze_optimized{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        Solution obj = new Solution();
        System.out.println("The no of unique paths in maze of "+m+" X "+n+" is: "+obj.no_of_paths(m, n));
    }
}
class Solution{
    public int no_of_paths(int m, int n){
        int prev[] = new int[n];
        for(int i = 0;i<m;i++){
            int curr[] = new int[n];
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    curr[j] = 1;//base case
                }else{
                    int up = i>0?prev[j]:0;
                    int left = j>0?curr[j-1]:0;
                    curr[j] = up+left;
                }
            }
            prev = curr;
        }
        return prev[n-1];
    }
}