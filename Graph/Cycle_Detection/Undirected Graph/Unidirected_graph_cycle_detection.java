public class Unidirected_graph_cycle_detection {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addedge(0,1);
        g.addedge(1,2);
        g.addedge(1,0);
        g.addedge(2,0);
        g.addedge(2,1);
        g.addedge(2,3);
        g.addedge(3,2);
        boolean visited[] = new boolean[5];
        System.out.println(g.detect_cycle_dfs(0, visited, -1));
    }
}
class Graph{
    int v;
    int matrix[][];
    public Graph(int v){
        this.v = v;
        matrix = new int[v][v];
    }
    public void addedge(int u,int v){
        matrix[u][v] = 1;
        matrix[v][u] = 1;
    }
    public boolean detect_cycle_dfs(int s, boolean visisted[],int parent){
        visisted[s]=true;
        for(int i= 0;i<v;i++){
            if(matrix[s][i]==1){
                if(!visisted[i]){
                    if(detect_cycle_dfs(i, visisted, s)){
                        return true;
                    }
                }else if(i!=parent){// if a node is visited and not parent of the current node then cycle exist.
                    return true;
                }
            }
        }
        return false;
    }
}
