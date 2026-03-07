import java.util.*;
public class How_to_store_weighted_graph {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1, 2);
        g.addEdge(0, 2, 4);
        g.addEdge(1, 2, -4);
        g.addEdge(1, 4, -1);
        g.addEdge(2, 3, 2);
        g.addEdge(3, 4, 4);
        g.display();
    }
}
class Edge{
    int v;
    int wt;
    public Edge(int v, int wt){
        this.v =v;
        this.wt = wt;
    }
}
class Graph{
    List<List<Edge>> g;
    int v;
    public Graph(int v){
        this.v = v;
        this.g = new ArrayList<>();
        for(int i =0;i<v;i++){
            g.add(new ArrayList<>());
        }
    }
    public void addEdge(int src,int des,int wt){
        g.get(src).add(new Edge(des,wt));
        g.get(des).add(new Edge(src,wt));
    }
    public void display(){
        for(int i = 0;i<v;i++){
            System.out.print("For node "+i+" ");
            for(Edge e: g.get(i)){
                System.out.print("(" + e.v + ", wt=" + e.wt + ") ");
            }
            System.out.println();
        }
    }
}
