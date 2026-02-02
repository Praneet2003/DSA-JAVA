
import java.util.Scanner;

// Input: matrix = [[1,4,7,11,15],
                // [2,5,8,12,19],
                // [3,6,9,16,22],
                // [10,13,14,17,24],
                // [18,21,23,26,30]], 
                // target = 5
// Output: true
//here the given array is not strictly sorted.
public class Binary_search_in_stair_case_sorted_2d_array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter no of rows and columns:");
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.print("Enter elements of the matrix: ");
        int mat[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j = 0;j<n;j++){
                mat[i][j] = sc.nextInt();
            }
        }
        System.out.print("Enter the target element: ");
        int target = sc.nextInt();
        Solution obj = new Solution();
        System.out.println(obj.searchMatrix(mat, target));
    }
}
class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        int s = 0;
        int e = arr[0].length-1;
        while(s<arr.length && e>=0){
            if(arr[s][e]==target){
                return true;
            }else if(arr[s][e]<target){
                s++;
            }else{
                e--;
            }
        }
        return false;
    }
}