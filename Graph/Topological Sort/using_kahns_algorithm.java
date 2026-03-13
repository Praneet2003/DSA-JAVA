import java.util.*;
public class using_kahns_algorithm {
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
        System.out.print(obj.kahns_algo(list));
    }
}
class Solution{
    public List<Integer> kahns_algo(List<List<Integer>> list){
        List<Integer> res = new ArrayList<>();
        int v = list.size();
        int indegree[] = new int[v];
        for(int u=0;u<v;u++){
            for(int i:list.get(u)){
                indegree[i]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<v;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        int index = 0;
        while(!queue.isEmpty()){
            int val = queue.poll();
            res.add(val);
            index++;
            for(int i:list.get(val)){
                indegree[i]--;
                if(indegree[i]==0){
                    queue.offer(i);
                }
            }
        }
        if(index!=v){//when cycle exist index keeps on incremeting and not equal to v
            return new ArrayList<>();
        }
        return res;
    }
}
