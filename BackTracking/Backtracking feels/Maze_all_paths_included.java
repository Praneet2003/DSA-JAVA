class Maze_all_paths_included{
    public static void main(String[] args) {
        boolean arr[][]={{true,true,true},
                        {true,false,true},
                        {true,true,true}};
        paths("",arr,0,0);
        System.out.println(count);
    }
    static int count =0;
    public static void paths(String p, boolean arr[][],int r,int c){
        if(r==arr.length-1 && c==arr[0].length-1){
            System.out.print(p+" ");
            count++;
            return;
        }
        if(!arr[r][c]){
            return;
        }
        arr[r][c]=false;
        if(r<arr.length-1){
            paths(p+"D", arr, r+1, c);
        }
        if(c<arr[0].length-1){
            paths(p+"R", arr, r, c+1);
        }
        if(r>0){
            paths(p+"U", arr, r-1, c);
        }
        if(c>0){
            paths(p+"L", arr, r, c-1);
        }
        arr[r][c]=true;
    }
}
//here the stack is going Overflow. without backtracking