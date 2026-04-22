import java.util.Scanner;
class House_robber2_optimized{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        System.out.println("The Max profit robber gets witout getting caught by alternate house is: "+obj.max_profit(arr));
    }
}
class Solution{
    public int max_profit(int arr[]){
        int n = arr.length;
        int leave_first = findmax(arr,1,n);
        int leave_last = findmax(arr,0,n-1);
        return Math.max(leave_first,leave_last);
    }
    public int findmax(int arr[], int s, int e){
        int p2 = 0;
        int p1 = 0;
        for(int i = s;i<e;i++){
            int take = arr[i]+p2;
            int nottake = p1;
            int curr = Math.max(take,nottake);
            p2 = p1;
            p1 = curr;
        }
        return p1;
    }
}