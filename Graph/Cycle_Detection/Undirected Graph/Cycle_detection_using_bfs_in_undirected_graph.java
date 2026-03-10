import java.util.*;
class Cycle_detection_using_bfs_in_undirected_graph{
    public static void main(String args[]){
        Graph g = new Graph(5);
        g.addedge(0,1);
        g.addedge(1,2);
        g.addedge(1,0);
        g.addedge(2,0);
        g.addedge(2,1);
        g.addedge(2,3);
        g.addedge(3,2);
        System.out.println(g.detectcycle(0));
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
    class pair{
        int first;
        int second;
        public pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
    public boolean detectcycle(int s){
        boolean visited[] = new boolean[matrix.length];
        Queue<pair> queue = new LinkedList<>();
        queue.offer(new pair(s,-1));
        visited[s] = true;
        while(!queue.isEmpty()){
            pair p = queue.poll();
            int par = p.second;
            int u = p.first;
            for(int i = 0;i<v;i++){
                if(matrix[u][i]==1){
                    if(!visited[i]){
                        queue.offer(new pair(i,u));
                        visited[i] = true;
                    }else if(i!=par){ 
                        return true;
                    }
                }
            }
        }
        return false;
    }
}