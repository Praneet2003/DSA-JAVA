import java.util.*;
public class Alien_dictionary_with_only_dict_array {
    public static void main(String[] args) {
        String dict[] = {"bba","abcd","abca","cab","cad"};
        String dic1t[] = {"ab", "cd", "ef", "ad"}; 
        Solution obj = new Solution();
        System.out.println(obj.findorder(dict));
        System.out.println(obj.findorder(dic1t));
    }
}
class Solution{
    public String findorder(String dict[]){
        List<List<Integer>> list = new ArrayList<>();
        Set<Character> set = new TreeSet<>();
        for(String word:dict){
            for(char c:word.toCharArray()){
                set.add(c);
            }
        }
        int k = set.size();
        for(int i = 0;i<k;i++){
            list.add(new ArrayList<>());
        }
        Map<Character,Integer> map = new HashMap<>();
        Map<Integer,Character> rev = new HashMap<>();
        int index=0;
        for(char c:set){
            map.put(c,index);
            rev.put(index,c);
            index++;
        }
        for(int i = 0;i<dict.length-1;i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            if(s1.length()>s2.length() && s1.startsWith(s2)){
                return "";
            }
            int len = Math.min(s1.length(),s2.length());
            for(int j = 0;j<len;j++){
                if(s1.charAt(j)!=s2.charAt(j)){
                    int u = map.get(s1.charAt(j));
                    int v = map.get(s2.charAt(j));
                    list.get(u).add(v);
                    break;
                }
            }
        }
        List<Integer> res = Topological_sort_khans_algo(list);
        if(res.size()!=k){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(int i: res){
            sb.append(rev.get(i));
        }
        return sb.toString();
    }
    public List<Integer> Topological_sort_khans_algo(List<List<Integer>> list){
        List<Integer> res = new ArrayList<>();
        int n = list.size();
        int indeg[] = new int[n];
        for(int i = 0;i<n;i++){
            for(int v:list.get(i)){
                indeg[v]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<n;i++){
            if(indeg[i]==0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int v = queue.poll();
            res.add(v);
            for(int u:list.get(v)){
                indeg[u]--;
                if(indeg[u]==0){
                    queue.offer(u);
                }
            }
        }
        return res;
    }
}
