import java.util.*;
public class DFS_traversal {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addedge(0, 1);
        g.addedge(1,2);
        g.addedge(1,3);
        g.addedge(2,3);
        g.addedge(2,4);
        System.out.print("BFS Traversal of the graph is: ");
        g.bfs(0);
        System.out.print("\n DFS Travesal of the graph is: ");
        boolean visited[] = new boolean[5];
        g.dfs(0, visited);
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
    public void dfs(int s, boolean visited[]){
        System.out.print(s+" ");
        visited[s] = true;
        for(int i = 0;i<matrix.length;i++){
            if(matrix[s][i]==1 && !visited[i]){
                dfs(i, visited);
            }
        }
    }
}