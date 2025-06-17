
import java.util.Scanner;

class Find_even_odd_using_bitwise{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to check Even or Odd: ");
        int n = sc.nextInt();
        if((n & 1) == 1){
            System.out.println("Odd");
        }else{
            System.out.println("Even");
        }
    }
}