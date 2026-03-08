import java.util.*;
public class DFS_graph_traversal {
    public static void main(String[] args) {
        Graph obj = new Graph(5);
        obj.addedge(0, 1);
        obj.addedge(1, 2);
        obj.addedge(1, 3);
        obj.addedge(2, 1);
        obj.addedge(3, 1);
        obj.addedge(2, 4);
        obj.addedge(4, 2);
        System.out.print("BFS Traversal of the graph is: ");
        obj.bfs();
        System.out.print("\n DFS Traversal of the graph is: ");
        boolean visited[] = new boolean[5];
        obj.dfs(0, visited);
    }
}
class Graph{
    int v;
    List<List<Integer>> list = new ArrayList<>();
    public Graph(int v){
        this.v= v;
        for(int i =0;i<v;i++){
            this.list.add(new ArrayList<>());
        }
    }
    public void addedge(int i,int j){
        list.get(i).add(j);
        list.get(j).add(i);
    }
    public void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        boolean visited[] = new boolean[v];
        visited[0] = true;
        while(!queue.isEmpty()){
            int u = queue.poll();
            System.out.print(u+" ");
            for(int i:list.get(u)){
                if(!visited[i]){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
    public void dfs(int s,boolean visited[]){
        System.out.print(s+" ");
        visited[s]= true;
        for(int i: list.get(s)){
            if(!visited[i]){
                dfs(i, visited);
            }
        }
    }
}
