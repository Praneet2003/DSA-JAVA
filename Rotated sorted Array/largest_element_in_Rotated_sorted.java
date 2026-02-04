class largest_element_in_Rotated_sorted{
    public static void main(String args[]){
        int arr[] = {3,6,2};
        int res = findpivot(arr);
        System.out.println(res);
    }
    public static int findpivot(int arr[]){
        //this method of finding the pivot is only applicable for the 
        int s = 0;
        int e = arr.length - 1;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(mid<e && arr[mid]>arr[mid+1]){
                return mid;
            }if(mid>s && arr[mid-1]>arr[mid]){
                return mid-1;
            }if(arr[s]>=arr[mid]){
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return -1;
    }
}