import java.util.*;
class DFS_implementation_Bipartite_graph{
    public static void main(String[] args) {
        Graph g1 = new Graph(11);
        g1.addEdge(0,1);
        g1.addEdge(1, 2);
        g1.addEdge(1, 5);
        g1.addEdge(2, 3);
        g1.addEdge(3, 4);
        g1.addEdge(3, 6);
        g1.addEdge(4, 8);
        g1.addEdge(8, 5);
        g1.addEdge(6, 7);
        g1.addEdge(9,10);
        List<List<Integer>> list = g1.getlist();
        Solution obj = new Solution();
        System.out.println(obj.dfs(list));
    }
}
class Solution{
    public boolean dfs(List<List<Integer>> adj){
        int n = adj.size();
        int color[] = new int[n];
        Arrays.fill(color,-1);
        for(int i = 0;i<n;i++){
            if(color[i]==-1){
                if(!dfs(adj,i,color,0)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfs(List<List<Integer>> adj, int s, int color[],int c){
        color[s] = c;
        for(int v:adj.get(s)){
            if(color[v]==-1){
                if(!dfs(adj,v,color,1-c)){
                    return false;
                }
            }else if(color[s]==color[v]){
                return false;
            }
        }
        return true;
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
        list.get(v).add(u);
    }
    public List<List<Integer>> getlist(){
        return list;
    }
}