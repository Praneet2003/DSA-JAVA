import java.util.Scanner;
public class check_sorted_bubble_sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n]; 
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        bubblesort(arr);
        System.out.print("[");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+",");
        }
        System.out.print("]");
    }
    public static void bubblesort(int arr[]){
    int n = arr.length;
    boolean swaped = false;
    for(int i=0;i<n;i++){
        for(int j = 0;j<n-i-1;j++){
            if(arr[j]>arr[j+1]){
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                swaped = true;
            }
        }
        if(swaped==false){
            break;
        }
    }
}
}
// 5
// -1 -2 -3 -4 -5
// [-5,-4,-3,-2,-1,]