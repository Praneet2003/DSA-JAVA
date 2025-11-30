import java.util.*;
class count_total_no_of_Permutations{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int ans = count_permutaion("", s);
        System.out.print("The no of permutations is: "+ans);
    }
    public static int count_permutaion(String p,String up){
        if(up.isEmpty()){
            return 1;
        }
        int count =0;
        char ch = up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            count=count+count_permutaion(f+ch+s, up.substring(1));//at every possible ans function call returns 1 and gets sum up.
        }
        return count;
    }
}
// Output:
// abcd
// The no of permutations is: 24