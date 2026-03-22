import java.util.*;
public class BFS_implementation_disconnected_graph {
    public static void main(String[] args) {
        Graph g1 = new Graph(11);
        g1.addEdge(0,1);
        g1.addEdge(1, 2);
        g1.addEdge(1, 5);
        g1.addEdge(2, 3);
        g1.addEdge(3, 4);
        g1.addEdge(3, 6);
        g1.addEdge(4, 8);
        g1.addEdge(8, 5);
        g1.addEdge(6, 7);
        g1.addEdge(9,10);
        List<List<Integer>> list = g1.getlist();
        Solution obj = new Solution();
        System.out.println("Is disconnected graph bipartite? "+obj.isBipartite(list));
    }
}
class Solution{
    public boolean isBipartite(List<List<Integer>> adj){
        int color[] = new int[adj.size()];
        Arrays.fill(color,-1);
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<adj.size();i++){
            if(color[i]==-1){
                queue.offer(i);
                color[i]=0;
            }
            while(!queue.isEmpty()){
                int u = queue.poll();
                for(int v: adj.get(u)){
                    if(color[v]==-1){
                        color[v] = 1-color[u];
                        queue.offer(v);
                    }else if(color[u]==color[v]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
class Graph{
    int v;
    List<List<Integer>> list;
    public Graph(int v){
        this.v = v;
        list = new ArrayList<>();
        for(int i = 0;i<v;i++){
            list.add(new ArrayList<>());
        }
    }
    public void addEdge(int v, int u){
        list.get(u).add(v);
        list.get(v).add(u);
    }
    public List<List<Integer>> getlist(){
        return list;
    }
}
