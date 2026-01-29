class Peak_index_in_mountain_array{
    public static void main(String[] args) {
        int arr[] ={1, 5,10,6,3,2};
        System.out.println("Index of the peak element is: "+Binary_search_index(arr));
    }
    public static int Binary_search_index(int[] arr){
        int s = 0;
        int e = arr.length - 1;
        int mid = s+(e-s)/2; 
       // you can either find pivot or
        while(s<e){
            // you can also use s<=e but in that case if(arr[mid]>arr[mid+1])=> e = mid;
            if(arr[mid]<arr[mid+1]){
                s=mid+1;
            }
            else if(arr[mid]>arr[mid+1]){
                e = mid;
            }
            mid = s+(e-s)/2;
        }
        return mid;
    }
}
