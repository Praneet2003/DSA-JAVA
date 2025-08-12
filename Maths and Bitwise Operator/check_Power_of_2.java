import java.util.*;
class check_Power_of_2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean ans = (n&(n-1))==0;
        if(ans==true){
            System.out.println("The Number "+n+" is power of 2.");
        }else{
            System.out.println("The Number "+n+" is not power of 2.");
        }
    }
}