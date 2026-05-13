import java.util.*;
class Ninja_Traning_Optimized{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][3];
        for(int i =0;i<n;i++){
            for(int j=0;j<3;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        Solution obj = new Solution();
        System.out.println("The maximum merit point that ninja can acheive at the end of n days trinaing is: "+obj.Ninja_Training(arr));
    }
}
class Solution{
    public int Ninja_Training(int arr[][]){
        int n = arr.length;
        int prev[] = new int[4];
        //base cases
        prev[0] = Math.max(arr[0][1],arr[0][2]);
        prev[1] = Math.max(arr[0][0],arr[0][2]);
        prev[2] = Math.max(arr[0][1],arr[0][0]);
        prev[3] = Math.max(arr[0][1],Math.max(arr[0][2],arr[0][0]));
        for(int day = 1;day<n;day++){
            int temp[] = new int[4];
            for(int last = 0;last<4;last++){
                int max=0;
                for(int task = 0;task<3;task++){
                    if(last!=task){
                        int point = arr[day][task]+prev[task];
                        max = Math.max(max,point);
                    }
                }
                temp[last] = max;
            }
            prev = temp;
        }
        return prev[3];
    }
}