import java.util.*;
public class Find_out_degree_of_graph {
    public static void main(String args[]){
        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 5);
        g.addEdge(3, 0);
        g.addEdge(4, 5);
        List<List<Integer>> res = g.getlist();
        Solution obj = new Solution();
        int arr[] = obj.get_OutDegree(res);
        for(int i = 0;i<arr.length;i++){
            System.out.println(i+" have outdegree of "+arr[i]);
        }
    }
}
class Solution{
    public int[] get_OutDegree(List<List<Integer>> adj){
        int v = adj.size();
        int count[] = new int[v];
        for(int i = 0;i<v;i++){
            for(int u:adj.get(i)){
                count[i]++;
            }
        }
        return count;
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
    }
    public List<List<Integer>> getlist(){
        return list;
    }
}
