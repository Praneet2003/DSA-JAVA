import java.util.*;
//greedy algoritm.
//time complexity = O((V+E).log v)
public class Direct_weighted_graph_dijkstra_implementation {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1, 2);
        g.addEdge(0, 2, 4);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 3, 7);
        g.addEdge(2, 4, 3);
        g.addEdge(3, 5, 1);
        g.addEdge(4, 3, 2);
        g.addEdge(4, 5, 5);
        g.display();
        System.out.println();
        List<List<Edge>> list = g.getlist();
        Solution obj = new Solution();
        int res[] = obj.dijkstra_algo(list, 0);
        for(int i = 0;i<res.length;i++){
            System.out.println(i+" node have distance: "+ res[i]);
        }
    }
}
class Solution{
    class pair implements Comparable<pair>{
        int val;
        int node;
        public pair(int f,int s){
            this.val = f;
            this.node = s;
        }
        public int compareTo(pair p){
            return Integer.compare(this.val,p.val);
        }
    }
    public int[] dijkstra_algo(List<List<Edge>> adj,int source){//greedy algorithm
        PriorityQueue<pair> queue = new PriorityQueue<>();
        int v = adj.size();
        int distance[] = new int[v];
        for(int i = 0;i<v;i++){
            if(i==source){
                distance[i]=0;
            }else{
                distance[i] = Integer.MAX_VALUE;
            }
        }
        queue.offer(new pair(0,source));
        while(!queue.isEmpty()){
            pair curr = queue.poll();
            int u = curr.node;
            if(curr.val>distance[u]){
                continue;
            }
            for(Edge e: adj.get(u)){
                if(distance[u]!=Integer.MAX_VALUE && distance[e.v]>distance[u]+e.wt){//edge relaxation
                    distance[e.v] = distance[u]+e.wt;
                    queue.offer(new pair(distance[e.v], e.v));
                }
            }
        }
        return distance;
    }
}
class Edge{
    int v;
    int wt;
    public Edge(int d,int w){
        this.v = d;
        this.wt = w;
    }
}
class Graph{
    List<List<Edge>> g;
    int v;
    public Graph(int v){
        this.v = v;
        g = new ArrayList<>(v);
        for(int i = 0;i<v;i++){
            g.add(new ArrayList<>());
        }
    }
    public List<List<Edge>> getlist(){
        return this.g;
    }
    public void addEdge(int src,int dest,int weight){
        g.get(src).add(new Edge(dest,weight));
    }
    public void display(){
        for(int i = 0; i < v; i++){
            System.out.print("Node " + i + " -> ");
            for(int j = 0; j < g.get(i).size(); j++){
                Edge e = g.get(i).get(j);
                System.out.print("(" + e.v + ", wt=" + e.wt + ") ");
            }
            System.out.println();
        }
    }
}

