import java.util.*;
public class GCD_of_two_strings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println("The GCD of these two strings are: "+solve(s1,s2));
    }
    static String solve(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)){
            return "";
        }
        int gcdlen = gcd(str1.length(),str2.length());
        return str1.substring(0,gcdlen);
    }
    static int gcd(int a,int b){
        if(b==0){
            return a;
        }
    return gcd(b,a%b);
    }
}
//Inputs:
// ABABAB ABAB
// Output
// AB