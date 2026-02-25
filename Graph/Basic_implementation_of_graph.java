import java.util.*;
public class Basic_implementation_of_graph {
    public static void main(String args[]){
        Graph g = new Graph(5);
        g.addedge(0, 1);
        g.addedge(1,2);
        g.addedge(2,3);
        g.addedge(2,4);
        g.print_addjacency_list();
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
    void addedge(int i,int j){
        list.get(i).add(j);
        list.get(j).add(i);
    }
    void print_addjacency_list(){
        for(int i = 0;i<v;i++){
            System.out.print(i+" ");
            for(int neigh:list.get(i)){
                System.out.print(neigh+" ");
            }
            System.out.println();
        }
    }
}
