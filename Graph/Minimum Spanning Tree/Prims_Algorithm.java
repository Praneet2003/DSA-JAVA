import java.util.*;
class Prims_Algorithm{
    public static void main(String args[]){
        Graph g = new Graph(4);
        g.addEdge(0, 1, 10);
        g.addEdge(0, 2, 15);
        g.addEdge(0, 3, 30);
        g.addEdge(1, 3, 40);
        g.addEdge(2, 3, 50);
        List<List<Edge>> list = g.getlist();
        Solution obj = new Solution();
        System.out.println(obj.MST_prims_Algo(list, 0));
    }
}
class Solution{
    class pair implements Comparable<pair>{
        int wt;
        int v;
        public pair(int wt, int v){
            this.wt=wt;
            this.v = v;
        }
        public int compareTo(pair p){
            return Integer.compare(this.wt,p.wt);
        }
    }
    public int MST_prims_Algo(List<List<Edge>> list, int src){
        int mst = 0;
        boolean visited[] = new boolean[list.size()];
        PriorityQueue<pair> queue = new PriorityQueue<>();
        queue.offer(new pair(0, src));
        while(!queue.isEmpty()){
            pair p = queue.poll();
            int u = p.v;
            if(!visited[u]){
                mst+=p.wt;
                visited[u] = true;
                for(Edge e:list.get(u)){
                    if(!visited[e.v]){
                        queue.offer(new pair(e.wt,e.v));
                    }
                }
            }
        }
        return mst;
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
        this.v = v;
        g = new ArrayList<>(v);
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