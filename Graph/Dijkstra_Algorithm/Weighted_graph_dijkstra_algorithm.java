import java.util.*;
public class Weighted_graph_dijkstra_algorithm {
    public static void main(String args[]){
        graph g = new graph(7);
        g.addEdge(0, 1, 2);
        g.addEdge(0, 2, 4);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 3, 7);
        g.addEdge(2, 4, 3);
        g.addEdge(3, 5, 1);
        g.addEdge(4, 3, 2);
        g.addEdge(4, 5, 5);
        List<List<Edge>> list = g.getlist();
        Solution obj = new Solution();
        int res[] = obj.dijkstra_algo(list, 0);
        for(int i=0;i<res.length;i++){
            System.out.println("Distance from source node 0 to node "+i+" is "+res[i]);
        }
    }
}
class Solution{
    class pair implements Comparable<pair>{
        int val;
        int node;
        public pair(int v, int n){
            this.val = v;
            this.node = n;
        }
        public int compareTo(pair p){
            return Integer.compare(this.val,p.val);
        }
    }
    public int[] dijkstra_algo(List<List<Edge>> adj, int source){
        int v = adj.size();
        int dist[] = new int[v];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[source]=0; 
        PriorityQueue<pair> queue = new PriorityQueue<>();
        queue.offer(new pair(0, source));
        while(!queue.isEmpty()){
            pair p = queue.poll();
            int u = p.node;
            if(p.val>dist[u]){
                continue;
            }
            for(Edge e: adj.get(u)){
                if(dist[u]!=Integer.MAX_VALUE && dist[e.v]>dist[u]+e.wt){
                    dist[e.v] = dist[u]+e.wt;
                    queue.offer(new pair(dist[e.v], e.v));
                }
            }
        }
        return dist;
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
class graph{
    List<List<Edge>> g;
    int v;
    public graph(int v){
        this.v = v;
        this.g = new ArrayList<>();
        for(int i = 0;i<v;i++){
            g.add(new ArrayList<>());
        }
    }
    public void addEdge(int src, int des, int wt){
        g.get(src).add(new Edge(des, wt));
        g.get(des).add(new Edge(src, wt));
    }
    public List<List<Edge>> getlist(){
        return g;
    }
}
