import java.util.*;
public class detect_cycle_in_directed_graph {
    public static void main(String[] args) {
        Solution obj = new Solution();
        List<List<Integer>> arr = new ArrayList<>();
        int V = 4;
        for(int i = 0; i < V; i++){
            arr.add(new ArrayList<>());
        }
        arr.get(0).add(1);
        arr.get(1).add(2);
        arr.get(2).add(3);
        arr.get(3).add(1);
        System.out.println(obj.detect_cycle(arr));
    }
}
class Solution{
    public boolean detect_cycle(List<List<Integer>> graph){
        int v = graph.size();
        boolean visited[] = new boolean[v];
        boolean path[] = new boolean[v];
        for(int i =0;i<v;i++){
            if(!visited[i]){
                if(detect_cycle(graph,i,visited,path)){
                    return true; 
                }
            }
        }
        return false;
    }
    public boolean detect_cycle(List<List<Integer>> graph,int s, boolean visited[],boolean path[]){
        visited[s] = true;
        path[s] = true;
        for(int v:graph.get(s)){
            if(!visited[v]){
                if(detect_cycle(graph,v,visited,path)){
                    return true;
                }
            }else if(path[v]){
                return true;
            }
        }
        path[s] = false;//backtrack.
        return false;
    }
}
