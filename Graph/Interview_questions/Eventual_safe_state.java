import java.util.*;
public class Eventual_safe_state {
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
        List<Integer> res = obj.eventual_safe(list);
        for(int i: res){
            System.out.print(i+" ");
        }
    }
}
class Solution{
    public List<Integer> eventual_safe(List<List<Integer>> list){
        List<Integer> res = new ArrayList<>();
        int v = list.size();
        boolean visited[] = new boolean[v];
        boolean path[] = new boolean[v];
        boolean safe[] = new boolean[v];
        for(int i = 0;i<v;i++){
            if(!visited[i]){
                dfs(list,i,visited,path,safe);
            }
        }
        for(int i = 0;i<v;i++){
            if(safe[i]){
                res.add(i);
            }
        }
        return res;
    }
    public boolean dfs(List<List<Integer>> list, int s, boolean visited[], boolean path[], boolean safe[]){
        visited[s] = true;
        path[s] = true;
        for(int v: list.get(s)){
            if(!visited[v]){
                if(dfs(list,v,visited,path,safe)){
                    safe[s] = false;
                    return true;
                }
            }else if(path[v]){
                safe[s] = false;
                return true;
            }
        }
        path[s] = false;
        safe[s] = true;
        return false;
    }
}
class Graph{
    List<List<Integer>> g;
    int v;
    public Graph(int v){
        this.v = v;
        this.g = new ArrayList<>();
        for(int i = 0;i<v;i++){
            g.add(new ArrayList<>());
        }
    }
    public void addEdge(int u,int v){
        g.get(u).add(v);
    }
    public List<List<Integer>> getlist(){
        return g;
    }
}
