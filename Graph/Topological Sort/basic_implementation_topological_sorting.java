import java.util.*;
public class basic_implementation_topological_sorting{
    public static void main(String[] args) {
        Solution obj = new Solution();
        List<List<Integer>> list = new ArrayList<>();
        int V = 6;
        // Create adjacency list
        for(int i = 0; i < V; i++){
            list.add(new ArrayList<>());
        }
        list.get(5).add(2);
        list.get(5).add(0);
        list.get(4).add(0);
        list.get(4).add(1);
        list.get(2).add(3);
        list.get(3).add(1);
        System.out.print(obj.Topolical_sort(list));
    }
}
class Solution{
    ArrayList<Integer> res = new ArrayList<>();
    public ArrayList<Integer> Topolical_sort(List<List<Integer>> list){
        int v = list.size();
        boolean visited[] = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<v;i++){
            if(!visited[i]){
                dfs(list,i,visited,stack);
            }
        }
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }
    public void dfs(List<List<Integer>>list, int s,boolean visited[], Stack<Integer> stack){
        visited[s] = true;
        for(int i:list.get(s)){
            if(!visited[i]){
                dfs(list,i,visited,stack);
            }
        }
        stack.push(s);
    }
}
