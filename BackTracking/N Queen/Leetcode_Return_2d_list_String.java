import java.util.*;
class Leetcode_Return_2d_list_String{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = sc.nextInt();
        Solution obj = new Solution();
        List<List<String>> ans = obj.solveNQueens(n);
        System.out.println(ans);
    }
}
class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean board[][] = new boolean[n][n];
        List<List<String>> sol = new ArrayList<>();
        queens(board,0,sol);
        return sol;
    }
    public void queens(boolean board[][],int r, List<List<String>> sol){
        if(r==board.length){
            sol.add(display(board));
            return;
        }
        for(int c=0;c<board.length;c++){
            if(isSafe(board,r,c)){
                board[r][c] = true;
                queens(board,r+1,sol);
                board[r][c]=false;
            }
        }
    }
    public boolean isSafe(boolean board[][],int r,int c){
        for(int i=0;i<r;i++){
            if(board[i][c]){
                return false;
            }
        }
        int maxleft = Math.min(r,c);
        for(int i=1;i<=maxleft;i++){
            if(board[r-i][c-i]){
                return false;
            }
        }
        int rightmax = Math.min(r,board.length-1-c);
        for(int i=0;i<=rightmax;i++){
            if(board[r-i][c+i]){
                return false;
            }
        } 
        return true;
    }
    public List<String> display(boolean board[][]){
        List<String> list = new ArrayList<>();
        for(boolean row[]:board){
            StringBuilder sb = new StringBuilder();
            for(boolean element: row){
                if(element){
                    sb.append("Q");
                }else{
                    sb.append(".");
                }
            }
            list.add(sb.toString());
        }
        return list;
    }
}
// Enter N: 4
// [[.Q.., ...Q, Q..., ..Q.], [..Q., Q..., ...Q, .Q..]]