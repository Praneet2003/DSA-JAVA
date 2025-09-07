import java.util.*;
class Keypad_phone_combination{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();//12
        letters("",s);
        // int n = s.charAt(0)-'0';
        // System.err.println(n);
    }
    public static void letters(String p, String up){
        if(up.isEmpty()){
            System.out.print(p+" ");
            return;
        }
        int digit = up.charAt(0)-'0';//converts char to digit eg=> "2"->2.
        for(int i = (digit-1)*3; i<digit*3;i++){
            char ch = (char)('a'+i);
            letters(p+ch, up.substring(1));
        }
    }
}