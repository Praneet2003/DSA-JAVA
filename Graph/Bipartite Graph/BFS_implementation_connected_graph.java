import java.util.*;
class BFS_implementation_connected_graph{
    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdge(0,1);
        g.addEdge(1, 2);
        g.addEdge(1, 5);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(3, 6);
        g.addEdge(6, 7);
        //this above graph have odd cycle length hence not a bipartite graph.
        Graph g1 = new Graph(9);
        g1.addEdge(0,1);
        g1.addEdge(1, 2);
        g1.addEdge(1, 5);
        g1.addEdge(2, 3);
        g1.addEdge(3, 4);
        g1.addEdge(3, 6);
        g1.addEdge(4, 8);
        g1.addEdge(8, 5);
        g1.addEdge(6, 7);
        List<List<Integer>> list = g.getlist();
        List<List<Integer>> list1 = g1.getlist();
        Solution obj = new Solution();
        System.out.println("is the graph1 biparted? "+obj.isBipartite(list));
        System.out.println("is the graph2 biparted? "+obj.isBipartite(list1));
    }
}
class Solution{
    public boolean isBipartite(List<List<Integer>> adj){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int color[] = new int[adj.size()];
        Arrays.fill(color,-1);
        color[0] = 0;//filled first node with color 0.
        while(!queue.isEmpty()){
            int u = queue.poll();
            for(int v:adj.get(u)){
                if(color[v]==-1){
                    if(color[u]==1){
                        color[v] = 0;
                    }else{
                        color[v] = 1;
                    }
                    queue.offer(v);
                }else if(color[v]==color[u]){
                    return false;
                }
            }
        }
        return true;
    }
}
class Graph{
    List<List<Integer>> list;
    int v;
    public Graph(int v){
        this.v = v;
        list = new ArrayList<>();
        for(int i = 0;i<v;i++){
            list.add(new ArrayList<>());
        }
    }
    public void addEdge(int u, int v){
        list.get(u).add(v);
        list.get(v).add(u);
    }
    public List<List<Integer>> getlist(){
        return list;
    }
}