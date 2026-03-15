import java.util.*;
public class Eventual_safe_node_using_khans_algo {
    public static void main(String args[]){
        Graph g = new Graph(7);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,5);
        g.addEdge(3,0);
        g.addEdge(4,5);
        List<List<Integer>> list = g.getlist();
        Solution obj = new Solution();
        List<Integer> res = obj.get_safe_node_kahns_algo(list);
        System.out.println(res);
    }
}
class Solution{
    public List<Integer> get_safe_node_kahns_algo(List<List<Integer>> list){
        int v = list.size();
        boolean safe[] = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        List<List<Integer>> rev = new ArrayList<>();
        int outdeg[] = new int[v];
        for(int i = 0;i<v;i++){
            rev.add(new ArrayList<>());
        }
        for(int i = 0;i<v;i++){
            outdeg[i] = list.get(i).size();//outdegree of the original graph but acts as indegree for reversed graph
            for(int j:list.get(i)){
                rev.get(j).add(i);//reversing the graph.
            }
        }
        for(int i = 0;i<v;i++){
            if(outdeg[i]==0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int u = queue.poll();
            safe[u] = true;
            for(int i: rev.get(u)){
                outdeg[i]--;
                if(outdeg[i]==0){
                    queue.offer(i);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i<v;i++){
            if(safe[i]){
                res.add(i);
            }
        }
        return res;
    }
}
class Graph{
    List<List<Integer>> g;
    int v;
    public Graph(int v){
        this.v = v;
        g = new ArrayList<>();
        for(int i = 0;i<v;i++){
            g.add(new ArrayList<>());
        }
    }
    public void addEdge(int u, int v){
        g.get(u).add(v);
    }
    public List<List<Integer>> getlist(){
        return g;
    }
}
