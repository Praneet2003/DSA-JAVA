import java.util.*;
class Prims_algo_returning_graph{
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1, 10);
        g.addEdge(0, 2, 15);
        g.addEdge(0, 3, 30);
        g.addEdge(1, 3, 40);
        g.addEdge(2, 3, 50);
        List<List<Edge>> list = g.getlist();
        Solution obj = new Solution();
        List<List<Edge>> res = obj.prims_Algo(list, 0);
        for(int i = 0;i<res.size();i++){
            System.out.print("For node "+i+" neigh are: ");
            for(Edge e: res.get(i)){
                System.out.print("("+e.v+" -> "+e.wt+")");
            }
            System.out.println();
        }
    }
}
class Solution{
    class pair implements Comparable<pair>{
        int parent;
        int v;
        int wt;
        public pair(int parent,int v, int wt){
            this.v = v;
            this.parent = parent;
            this.wt = wt;
        }
        public int compareTo(pair p){
            return Integer.compare(this.wt, p.wt);
        }
    }
    public List<List<Edge>> prims_Algo(List<List<Edge>> adj, int source){
        PriorityQueue<pair> queue = new PriorityQueue<>();
        Graph g1 = new Graph(adj.size());
        boolean visited[] = new boolean[adj.size()];
        queue.offer(new pair(-1,source,0));
        while(!queue.isEmpty()){
            pair p = queue.poll();
            int u = p.v;
            if(visited[u]){
                continue;
            }
            visited[u] = true;
            if(p.parent!=-1){
                g1.addEdge(p.parent, u, p.wt);
            }
            for(Edge e: adj.get(u)){
                if(!visited[e.v]){
                    queue.offer(new pair(u,e.v,e.wt));//now u is the new parent i.e(u->v).
                }
            }
        }
        return g1.getlist();
    }
}
class Edge{
    int v;
    int wt;
    public Edge(int v, int wt){
        this.v = v;
        this.wt = wt;
    }
}
class Graph{
    List<List<Edge>> g;
    int v;
    public Graph(int v){
        this.v =v;
        g = new ArrayList<>(v);
        for(int i = 0;i<v;i++){
            g.add(new ArrayList<>());
        }
    }
    public void addEdge(int src, int des, int wt){
        g.get(src).add(new Edge(des, wt));
        g.get(des).add(new Edge(src, wt));
    }
    public void display(){
        for(int i = 0;i<v;i++){
            System.out.print("For node "+i+" neigh are: ");
            for(Edge e: g.get(i)){
                System.out.print("("+e.v+" -> "+e.wt+")");
            }
        }
        System.out.println();
    }
    public List<List<Edge>> getlist(){
        return g;
    }
}