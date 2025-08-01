import java.util.*;
class Reset_ith_bit_of_a_number{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int resetbit = sc.nextInt();
        int mask = ~(1<<(resetbit-1));// here we are using 1 based indexing.
        int resnum = num & mask;
        System.out.println(resnum);
    }
}
// Output:
// 182
// 5
// 166