import java.util.*;
public class word_count {
    public static void main(String[] args) {
        String text = "Hey i am praneet as well as i am Anshu";
        String words[] = text.split(" ");//converts this text into an array of string type
        HashMap<String, Integer> map = new HashMap<>();
        for(String word: words){
            if(map.containsKey(word)){
                map.put(word,map.get(word)+1);
            }else{
                map.put(word,1);
            }
        }
        System.out.println(map);
    }
}
// {as=2, Anshu=1, i=2, praneet=1, well=1, am=2, Hey=1}