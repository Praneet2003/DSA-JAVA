import java.util.*;
class implementaton_of_bellman_ford_algo{
    public static void main(String args[]){
        Graph g = new Graph(5);
        g.addEdge(0, 1, 2);
        g.addEdge(0, 2, 4);
        g.addEdge(1, 2, -4);
        g.addEdge(1, 4, -1);
        g.addEdge(2, 3, 2);
        g.addEdge(3, 4, 4);
        List<List<Edge>> list = g.getlist();
        Solution obj = new Solution();
        int res[] = obj.bellman_algo(list, 0);
        for(int i = 0;i<res.length;i++){
            System.out.println("distance from souce 0 to "+i+" is: "+res[i]);
        }
        System.out.println("Is there a negative cycle exist? "+obj.flag);
    }
}
class Solution{
    boolean flag = false;
    public int[] bellman_algo(List<List<Edge>> adj, int source){//DP algo
        int v = adj.size();
        int dist[] = new int[v];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[source] = 0;
        for(int i = 0;i<v-1;i++){
            for(int u = 0;u<v;u++){
                for(Edge e:adj.get(u)){
                    if(dist[u]!=Integer.MAX_VALUE && dist[e.v]>dist[u]+e.wt){
                        dist[e.v] = dist[u]+e.wt;
                    }
                }
            }
        }
        for(int u = 0;u<v;u++){
            for(Edge e:adj.get(u)){
                if(dist[u]!=Integer.MAX_VALUE && dist[e.v]>dist[u]+e.wt){
                    flag = true;
                    break;
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
class Graph{
    List<List<Edge>> g;
    int v;
    public Graph(int v){
        this.v =v;
        this.g = new ArrayList<>(v);
        for(int i = 0;i<v;i++){
            g.add(new ArrayList<>());
        }
    }
    public void addEdge(int src, int des, int wt){
        g.get(src).add(new Edge(des, wt));
    }
    public List<List<Edge>> getlist(){
        return g;
    }
}