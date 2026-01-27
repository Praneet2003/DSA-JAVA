class Duplicate_Largest_element{
    public static void main(String[] args) {
        int arr[] = {2,9,2,2,2};
        System.out.println(findpivot(arr));
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
            }
            // if(arr[s]>=arr[mid]){
            //     e = mid-1;
            // }else{
            //     s = mid+1;
            // }
            if(arr[mid]==arr[s] && arr[mid]==arr[e]){
                //skip the duplicates.
                //NOTE: what if these elements at start and end were the pivot?
                //check if start is pivot.
                if(arr[s]>arr[s+1]){
                    return s;
                }else{
                    s++;
                }
                if(arr[e]<arr[e-1]){
                    return e-1;
                }else{
                    e--;
                }
            }else if(arr[s]<arr[mid] || (arr[s]==arr[mid] && arr[e]<arr[mid])){
                s = mid+1;
            }else{
                e = mid-1;
            }
        }
        return -1;
    }
}