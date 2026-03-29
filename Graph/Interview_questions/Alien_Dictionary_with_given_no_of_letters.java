import java.util.*;
class Alien_Dictionary_with_given_no_of_letters{
    public static void main(String args[]){
        String dict[] = {"baa","abcd","abca","cab","cad"};
        int n = 5;
        int k = 4;
        Solution obj = new Solution();
        System.out.println(obj.findorder(dict,n,k));
    }
}
class Solution{
    public String findorder(String dict[],int n, int k){//n is no of words and k is starting alphabets of the dictoionary.
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0;i<k;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<n-1;i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            int len = Math.min(s1.length(),s2.length());
            if(s1.length()>s2.length() && s1.startsWith(s2)){
                return "";
            }
            for(int j = 0;j<len;j++){
                if(s1.charAt(j)!=s2.charAt(j)){
                    list.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    break;
                }
            }
        }
        List<Integer> res = Topological_sort_khans_algo(list);
        if(res.size()!=k){//detecting the cycle
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(int i :res){
            sb.append((char)(i+'a'));
        }
        return sb.toString();
    }
    public List<Integer> Topological_sort_khans_algo(List<List<Integer>> list){
        List<Integer> res = new ArrayList<>();
        int indeg[] = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            for(int j:list.get(i)){
                indeg[j]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<list.size();i++){
            if(indeg[i]==0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int val = queue.poll();
            res.add(val);
            for(int i:list.get(val)){
                indeg[i]--;
                if(indeg[i]==0){
                    queue.offer(i);
                }
            }
        }
        return res;
    }
}