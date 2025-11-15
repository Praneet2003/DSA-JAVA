class Backtracking_Maze_paths{
    public static void main(String[] args) {
        boolean arr[][] = {{true,true,true},
                            {true,true,true},
                            {true,true,true}};
        paths("",arr,0,0);
    }
    public static void paths(String p,boolean arr[][],int r, int c){
        if(r==arr.length-1 && c==arr[0].length-1){
            System.out.println(p+" ");
            return;
        }
        if(!arr[r][c]){//if already false(i.e ostacle present)
            return;
        }
        // we are inclusing cell in the path (i.e we will make that cell as false)
        // if cell is marked as false i.e it is being used in the current path.
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
            paths(p+"L", arr, r, c);
        }
        //here the recursive call will over.
        // so before the function gets returned, also remove the changes made in the maze.
        // i.e make the path available for other recursion calls.
        arr[r][c]=true;
    }
}
// all possible paths.
// DDRR 
// DDRURD
// DDRUURDD
// DRDR
// DRRD
// DRURDD
// RDDR
// RDRD
// RRDD