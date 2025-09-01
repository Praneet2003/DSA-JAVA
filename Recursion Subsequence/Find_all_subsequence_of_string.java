import java.util.*;
class Find_all_subsequence_of_string{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();//abc;
        subsequence("",s);
    }
    public static void subsequence(String p, String up){//p-> Processed and up-> unprocessed.
        if(up.isEmpty()){
            System.out.print(p+" ");
            return;
        }
        char ch = up.charAt(0);
        subsequence(p+ch, up.substring(1));//taking the first character.
        subsequence(p, up.substring(1));
    }
}
// abc
// abc ab ac a bc b c 