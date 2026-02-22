// Given a string s consisting of only lowercase alphabets, for each index i in the string (0 ≤ i < n), find the first non-repeating character in the prefix s[0..i]. If no such character exists, use '#'.
// Examples:
// Input: s = "aabc"
// Output: a#bb
// Explanation: 
// At i=0 ("a"): First non-repeating character is 'a'.
// At i=1 ("aa"): No non-repeating character, so '#'.
// At i=2 ("aab"): First non-repeating character is 'b'.
// At i=3 ("aabc"): Non-repeating characters are 'b' and 'c'; 'b' appeared first, so 'b'. 
// Input: s = "bb" 
// Output: "b#" 
// Explanation: 
// At i=0 ("b"): First non-repeating character is 'b'.
// At i=1 ("bb"): No non-repeating character, so '#'.
public class First_non_repeating_character_in_string {
    public static void main(String[] args) {
        
    }
}
class Solution {
    public String firstNonRepeating(String s) {
        // code here
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        int i = 0;
        int arr[] = new int[26];
        while(i<s.length()){
            char c = s.charAt(i);
            queue.offer(c);
            arr[c-'a'] +=1;
            while(!queue.isEmpty() && arr[queue.peek()-'a']>1){
                queue.poll();
            }
            if(queue.isEmpty()){
                sb.append('#');
            }else{
                sb.append(queue.peek());
            }
            i++;
        }
        return sb.toString();
    }
}