public class No_of_Islands {
    public static void main(String[] args) {
        char arr[][] = {{'1','1','0','0','0'},
        {'1','1','0','0','0'},
        {'0','0','1','0','0'},
        {'0','0','0','1','1'}};
        Solution obj = new Solution();
        System.out.println(obj.No_of_Islands(arr));
    }    
}
class Solution{
    public int No_of_Islands(char[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        int count = 0;
        if(arr==null || arr.length==0){
            return 0;
        }
        boolean visited[][] = new boolean[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(arr[i][j]=='1' && !visited[i][j]){
                    dfs(i,j,visited,arr);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int i,int j,boolean [][]visited,char arr[][]){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j]!='1' || visited[i][j]){
            return;
        }
        visited[i][j] = true;
        dfs(i, j+1, visited, arr);
        dfs(i, j-1, visited, arr);
        dfs(i+1, j, visited, arr);
        dfs(i-1, j, visited, arr);
    }
}
