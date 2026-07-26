import java.util.*;
class Minimum_window_substring{
    public static void main(String[] args) {
        String s = "adobecodebanc";
        String t = "abc";
        Solution obj = new Solution();
        System.out.print(obj.minWindow(s, t));
    }
}
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c: t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int i =0;
        int n = s.length();
        int j = 0;
        String res = "";
        int min = Integer.MAX_VALUE;
        while(j<n){
            char c = s.charAt(j);
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
            }
            while(allZeroes(map)){
                if(j-i+1<min){
                    min = j-i+1;
                    res = s.substring(i,j+1);
                }
                char x = s.charAt(i);
                if(map.containsKey(x)){
                    map.put(x,map.get(x)+1);
                }
                i++;
            }
            j++;
        }
        return res;
    }
    public boolean allZeroes(HashMap<Character, Integer> map){
        for(char k: map.keySet()){
            if(map.get(k)>0){
                return false;
            }
        }
        return true;
    }
}