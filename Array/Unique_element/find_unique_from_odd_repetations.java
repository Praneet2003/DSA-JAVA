import java.util.*;
class find_unique_from_odd_repetations{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int arr[] = new int[n];
        int arraysum = 0;
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
            arraysum+=arr[i];
        }
        Set<Integer> uniqueelement = new HashSet<Integer>();
        for(int num:arr){
            uniqueelement.add(num);
        }
        int uniquesum =0;
        for(int i: uniqueelement){
            uniquesum+=i;
        }
        int unique = (3*uniquesum - arraysum)/2;
        System.out.println("Unique element in the array is: "+ unique); 
    }
}