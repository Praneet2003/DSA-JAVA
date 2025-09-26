class N_Queen{
    public static void main(String[] args) {
        int n =4;
        boolean arr[][] = new boolean[n][n];
        int count = Queens(arr, 0);
        System.out.println(count);
    }
    public static int Queens(boolean board[][],int row){
        if(row==board.length){
            display(board);
            System.out.println();
            return 1;
        }
        int count=0;
        //placing the queen and checking whether it is safe or not?
        for(int c=0;c<board.length;c++){
            if(isSafe(board,row,c)){
                board[row][c]=true;
                count+=Queens(board, row+1);//if current queen position is safe the go for next row.
                board[row][c]=false;//backtrack it as it was previously.
            }
        }
        return count;
    }
    public static boolean isSafe(boolean board[][],int r,int c){
        for(int i=0;i<r;i++){//checking 0 to r rows.(i.e staraight upwards)
            if(board[i][c]){
                return false;
            }
        }
        //diagonal left ckeck krega.
        int maxleft = Math.min(r,c);
        for(int i=1;i<=maxleft;i++){
            if(board[r-i][c-i]){
                return false;
            }
        }
        //diagonal right check krega
        int maxright = Math.min(r,board.length-1-c);
        for(int i=1;i<=maxright;i++){
            if(board[r-i][c+i]){
                return false;
            }
        }
        return true;
    }
    public static void display(boolean[][] board){
        for(boolean row[]:board){
            for(boolean element: row){
                if(element){
                    System.out.print("Q ");
                }else{
                    System.out.print("x ");
                }
            }
            System.out.println();
        }
    }
}