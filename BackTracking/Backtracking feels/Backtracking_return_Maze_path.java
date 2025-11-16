import java.util.*;
class Backtracking_return_Maze_path{
    public static void main(String[] args) {
        boolean arr[][] = {{true,true,true},
                            {true,true,true},
                            {true,true,true}};
        ArrayList<String> ans = paths("",arr,0,0);
        System.out.println(ans);
    }
    public static ArrayList<String> paths(String p,boolean arr[][],int r,int c){
        ArrayList<String> list= new ArrayList<>();
        if(r==arr.length-1 && c==arr[0].length-1){
            list.add(p);
            return list;
        }
        if(!arr[r][c]){
            return list;
        }
        arr[r][c]=false;
        if(r<arr.length-1){
            list.addAll(paths(p+"D", arr, r+1, c));
        }
        if(c<arr[0].length-1){
            list.addAll(paths(p+"R", arr, r, c+1));
        }
        if(r>0){
            list.addAll(paths(p+"U", arr, r-1, c));
        }
        if(c>0){
            list.addAll(paths(p+"L", arr, r, c-1));
        }
        arr[r][c]=true;
        return list;
    }
}
// [DDRR, DDRURD, DDRUURDD, DRDR, DRRD, DRURDD, RDDR, RDRD, RDLDRR, RRDD, RRDLDR, RRDLLDRR]