class counting_paths{
    public static void main(String[] args) {
        int ans = path(3,3);//here we are going down to up.
        int ans2 = path1(0,0);//here we are going up to down.
        //row and columns are entered as arguments here.
        System.out.println("Going down to top: "+ans);
        System.out.print("Going top to down: "+ans2);
    }
    public static int path(int r, int c){
        if(r==1 || c==1){
            return 1;
        }
        int count=0;
        count+=path(r-1,c);
        count+=path(r,c-1);
        return count; 
    }
    public static int path1(int r, int c){
        if(r==2 ||c==2){
            return 1;
        }
        int count=0;
        count+=path1(r+1, c);
        count+=path1(r, c+1);
        return count;
    }
}