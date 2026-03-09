import java.util.*;
public class Rotting_Oranges {
    public static void main(String[] args) {
        int arr[][] = {{2,1,1},
                        {1,1,0},
                        {2,1,1}};
        rotten obj = new rotten();
        int ans = obj.orangesRotting(arr);
        System.out.println(ans);
    }
}
class rotten{
    class pair{
        int first;
        int second;
        int third;
        public pair(int f,int s,int t){
            this.first = f;
            this.second = s;
            this.third = t;
        }
    }
    int max = 0;
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0){
            return -1;
        }
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        Queue<pair> queue = new LinkedList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==2){//find all source nodes and add then into the queue.
                    queue.offer(new pair(i,j,0));
                    visited[i][j] = true;
                }
            }
        }
        while(!queue.isEmpty()){
            pair p = queue.poll();
            int i = p.first;
            int j = p.second;
            int time = p.third;
            max = Math.max(max,time);
            //top.
            if(i-1>=0 && !visited[i-1][j] && grid[i-1][j]==1){
                visited[i-1][j] = true;
                grid[i-1][j] = 2;
                queue.offer(new pair(i-1, j, time+1));
            }//bottom
            if(i+1<n && !visited[i+1][j] && grid[i+1][j]==1){
                visited[i+1][j] = true;
                grid[i+1][j] = 2;
                queue.offer(new pair(i+1, j, time+1));
            }
            //left
            if(j-1>=0 && !visited[i][j-1] && grid[i][j-1]==1){
                visited[i][j-1] = true;
                grid[i][j-1] = 2;
                queue.offer(new pair(i, j-1, time+1));
            }
            //right
            if(j+1<m && !visited[i][j+1] && grid[i][j+1]==1){
                visited[i][j+1] = true;
                grid[i][j+1] = 2;
                queue.offer(new pair(i, j+1, time+1));
            }
        }
        if(present_1(grid)){
            return -1;
        }else{
            return max;
        }
    }
    public boolean present_1(int grid[][]){
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return true;
                }
            }
        }
        return false;
    }
}