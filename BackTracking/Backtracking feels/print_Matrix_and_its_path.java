class print_Matrix_and_its_path{
    public static void main(String[] args) {
        boolean arr[][] = {{true,true,true},
                            {true,true,true},
                            {true,true,true}};
        int matrix[][] = {{0,0,0},
                            {0,0,0},
                            {0,0,0}};
        printmatrix_path("",arr,0,0,matrix,1);
    }
    public static void printmatrix_path(String p,boolean arr[][],int r,int c,int matrix[][],int i){
        if(r==arr.length-1 && c==arr[0].length-1){
            matrix[r][c]=i;
            for(int k=0;k<arr.length;k++){
                for(int j=0;j<arr[0].length;j++){
                    System.out.print(matrix[k][j]+" ");
                }
                System.out.println();
            }
            // System.out.println(Arrays.toString(matrix));
            System.out.println(p);
            System.out.println();
            return;
        }
        if(!arr[r][c]){
            return;
        }
        arr[r][c]=false;
        matrix[r][c]=i;
        if(r<arr.length-1){
            printmatrix_path(p+"D", arr, r+1, c,matrix, i+1);
        }
        if(c<arr[0].length-1){
            printmatrix_path(p+"R", arr, r, c+1,matrix, i+1);
        }
        if(r>0){
            printmatrix_path(p+"U", arr, r-1, c,matrix, i+1);
        }if(c>0){
            printmatrix_path(p+"L", arr, r, c-1,matrix, i+1);
        }
        arr[r][c]=true;
        matrix[r][c]=0;
    }
}