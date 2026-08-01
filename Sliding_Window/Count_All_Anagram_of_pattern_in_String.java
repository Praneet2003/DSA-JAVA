import java.util.*;
class Count_All_Anagram_of_pattern_in_String{
    public static void main(String args[]){
        String s = "forxxorfxdofr";
        String p = "for";
        Solution obj = new Solution();
        System.out.println(obj.CountAnagrams(s,p));
    }
}
class Solution {
    public int CountAnagrams(String s, String p) {
        int count = 0;
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
                    count++;
                }
                freq[s.charAt(i)-'a']++;
                i++;
            }
            j++;
        }
        return count;
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