import java.util.*;
class Sqare_root_using_Newton_Raphsons_method{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double x=n;
        double root;
        if(n<2){
            root = n;
        }
        while(true){
            root = (x+(n/x))/2;
            if(Math.abs(root-x)<1){
                break;
            }
            x = root;
        }
        System.out.println(root);
    }
}