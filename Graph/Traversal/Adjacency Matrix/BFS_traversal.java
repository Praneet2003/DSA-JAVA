import java.util.*;
class BFS_traversal{
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addedge(0, 1);
        g.addedge(1, 0);
        g.addedge(1, 2);
        g.addedge(1,3);
        g.addedge(1,4);
        g.addedge(2, 1);
        g.addedge(3, 1);
        g.addedge(4, 1);
        g.bfs(0);
    }
}
class Graph{
    int v;
    int matrix[][];
    public Graph(int v){
        this.v = v;
        matrix = new int[v][v];
    }
    public void addedge(int i,int j){
        matrix[i][j] = 1;
        matrix[j][i] = 1;
    }
    public void bfs(int s){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        boolean visited[] = new boolean[matrix.length];
        visited[s] = true;
        while(!queue.isEmpty()){
            int u = queue.poll();
            System.out.print(u+" ");
            for(int i = 0;i<matrix.length;i++){
                if(matrix[u][i]==1 && !visited[i]){
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}