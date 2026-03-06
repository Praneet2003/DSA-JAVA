import java.util.*;
public class How_to_store_directed_weighted_graph {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1, 2);
        g.addEdge(0, 2, 4);
        g.display();
    }
}
class Edge{
    int d;
    int w;
    public Edge(int d,int w){
        this.d = d;
        this.w = w;
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
    public void addEdge(int src,int dest,int weight){
        g.get(src).add(new Edge(dest,weight));
    }
    public void display(){
        for(int i=0;i<v;i++){
            System.out.print("For node "+i+": ");
            for(int j = 0;j<g.get(i).size();j++){
                Edge e = g.get(i).get(j);
                System.out.println("->"+e.d+" weight "+e.w);
            }
        }
    }
}
