import java.util.*;
class find_unique_element_where_all_other_are_repeating_3_times{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int result = 0;
        for(int i=0;i<32;i++){
            int mask = 1<<i;
            int sum=0;
            for(int num: arr){
                if((num & mask)!=0){
                    sum++;
                }
            }
            if(sum%3!=0){
                result|=mask;
            }
        }
        System.out.println("The unique element present in the array is: "+result);
    }
}