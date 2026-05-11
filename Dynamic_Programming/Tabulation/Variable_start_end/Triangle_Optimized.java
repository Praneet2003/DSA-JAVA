import java.util.*;
class Triangle_Optimized{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][];
        for(int i =0;i<n;i++){
            arr[i] = new int[i+1];
            for(int j=0;j<=i;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        Solution obj = new Solution();
        System.out.println("The minimum cost to reach at the bootom most row is: "+obj.min_path(arr));
    }
}
class Solution{
    public int min_path(int arr[][]){
        int n = arr.length;
        int prev[] = new int[n];
        for(int i=0;i<n;i++){
            prev[i] = arr[n-1][i];
        }
        for(int i=n-2;i>=0;i--){
            int curr[] = new int[n];
            for(int j=0;j<=i;j++){
                int down = prev[j];
                int diagonal = prev[j+1];
                curr[j] = arr[i][j]+Math.min(down,diagonal);
            }
            prev = curr;
        }
        return prev[0];
    }
}