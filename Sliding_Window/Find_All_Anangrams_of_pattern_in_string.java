import java.util.*;
class Find_All_Anangrams_of_pattern_in_string{
    public static void main(String args[]){
        String s = "forxxorfxdofr";
        String p = "for";
        Solution obj = new Solution();
        System.out.println(obj.findAnagrams(s,p));
    }
}
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int k = p.length();
        int n = s.length();
        int freq[] = new int[26];
        for(char c : p.toCharArray()){
            freq[c-'a']++;
        }
        int i = 0;
        int j = 0;
        while(j<n){
            freq[s.charAt(j)-'a']--;
            if(j-i+1==k){
                if(allZeroes(freq)){
                    res.add(i);
                }
                freq[s.charAt(i)-'a']++;
                i++;
            }
            j++;
        }
        return res;
    }
    public boolean allZeroes(int freq[]){
        for(int i: freq){
            if(i!=0){
                return false;
            }
        }
        return true;
    }
}