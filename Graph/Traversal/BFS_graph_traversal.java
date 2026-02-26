import java.util.*;

public class BFS_graph_traversal {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addedge(0, 1);
        g.addedge(1,2);
        g.addedge(1,3);
        g.addedge(2,3);
        g.addedge(2,4);

        g.bfs(0);   // Start BFS from node 0
    }    
}

class Graph{
    int v;
    List<List<Integer>> list = new ArrayList<>();

    public Graph(int v){
        this.v = v;
        for(int i = 0; i < v; i++){
            list.add(new ArrayList<>());
        }
    }

    public void addedge(int i,int j){
        list.get(i).add(j);
        list.get(j).add(i);
    }

    public void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[v];

        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int u = queue.poll();
            System.out.print(u + " ");

            for(int neighbor : list.get(u)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        System.out.println();
    }
}
