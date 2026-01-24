class Solution {
    static boolean pairInSortedRotated(int arr[], int target) {
        int n = arr.length;

        int pivot = findpivot(arr);
        if(pivot==-1){
            pivot = n-1;
        }
        int left = (pivot + 1) % n;
        int right = pivot;

        while (left != right) {
            int sum = arr[left] + arr[right];

            if (sum == target)
                return true;
            else if (sum < target)
                left = (left + 1) % n;
            else
                right = (right - 1 + n) % n;
        }
        return false;
    }

    static int findpivot(int arr[]) {
        int s = 0, e = arr.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (mid < e && arr[mid] > arr[mid + 1])
                return mid;
            if (mid > s && arr[mid - 1] > arr[mid])
                return mid - 1;
            if (arr[s] <= arr[mid])
                s = mid + 1;
            else
                e = mid - 1;
        }
        return -1;
    }
}
