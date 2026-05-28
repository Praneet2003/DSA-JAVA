import java.util.*;
class Minimum_path_sum_grid_optimized{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        Solution obj = new Solution();
         System.out.println("THe minimum path sum in the given grid is: "+obj.min_path(arr));
    }
}
class Solution{
    public int min_path(int arr[][]){
        int prev[] = new int[arr[0].length];
        int n = arr.length;
        int m = arr[0].length;
        for(int i=0;i<n;i++){
            int curr[] = new int[m];
            for(int j = 0;j<m;j++){
                if(i==0 && j==0){
                    curr[j] = arr[0][0];
                    continue;
                }
                int up = i>0?prev[j]:Integer.MAX_VALUE;
                int left = j>0?curr[j-1]:Integer.MAX_VALUE;
                curr[j] = arr[i][j]+Math.min(up,left);
            }
            prev = curr;
        }
        return prev[m-1];
    }
}