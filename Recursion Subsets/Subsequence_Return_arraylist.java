import java.util.*;
class Subsequence_Return_arraylist{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        ArrayList<String> list = subsequence("",s);
        System.out.println(list);
    }
    public static ArrayList<String> subsequence(String p,String up){
        ArrayList<String> list = new ArrayList<String>();
        if(up.isEmpty()){
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> ansfromtaken = subsequence(p+ch, up.substring(1));
        ArrayList<String> ansfromnottaken = subsequence(p, up.substring(1));
        list.addAll(ansfromnottaken);
        list.addAll(ansfromtaken);
        return list;
    }
}
// abc
// [, c, b, bc, a, ac, ab, abc]