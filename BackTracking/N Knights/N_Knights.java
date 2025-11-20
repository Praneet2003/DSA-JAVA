class N_Knights{
    public static void main(String[] args) {
        int n = 2;
        boolean board[][] = new boolean[n][n];
        knights(board, 0, 0, n);
    }
    public static void knights(boolean board[][],int r,int c, int target){
        if(target==0){
            display(board);
            System.out.println("");
            return;
        }
        if(c==board.length){//when you reach at the end of column
            knights(board, r+1, 0, target);//move in next row
            return;
        }
        if(r>=board.length){//if you reach at the end row i.e STOP!
            return;
        }
        if(isSafe(board,r,c)){
            board[r][c]=true;
            knights(board, r, c+1, target-1);//if safe then store the ans and move ahead.
            board[r][c]=false;//backtracking
        }
        knights(board, r, c+1, target);//it it is not safe then also move ahead.
    }
    public static boolean isSafe(boolean board[][],int r, int c){
        if(isValid(board, r-2, c-1) && (board[r-2][c-1])){
                return false;
        }
        if(isValid(board, r-2, c+1) && (board[r-2][c+1])){
                return false;
        }if(isValid(board, r-1, c-2) && (board[r-1][c-2])){
                return false;
        }
        if(isValid(board, r-1, c+2) && (board[r-1][c+2])){
                return false;
        }
        return true;
    }
    public static boolean isValid(boolean board[][],int r, int c){
        if(r>=0 && r<board.length && c>=0 && c<board.length){
            return true;
        }
        return false;
    }
    public static void display(boolean board[][]){
        for(boolean row[]:board){
            for(boolean element:row){
                if(element){
                System.out.print("K ");
                }else{
                    System.out.print("o ");
                }
            }
            System.out.println();
        }
    }
}