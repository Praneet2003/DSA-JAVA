import java.util.*;
class Reverse_array{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int s = 0;
        int e = n-1;
        while(s<e){
            int temp = arr[s];
            arr[s]=arr[e];
            arr[e]=temp;
            s++;
            e--;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}