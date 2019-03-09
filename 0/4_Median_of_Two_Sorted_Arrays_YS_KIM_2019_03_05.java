class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        int[] arr = new int[size];
        int i = 0;
        int j = 0;
        for(int arri = 0; arri < size; arri++) {
            int item = 0;
            int num1 = nums1.length > i ? nums1[i] : Integer.MAX_VALUE;
            int num2 = nums2.length > j ? nums2[j] : Integer.MAX_VALUE;
            if(num1 > num2) {
                item = nums2[j];
                j++;
            } else {
                item = nums1[i];
                i++;
            }
            arr[arri] = item;
        }
        
        int mid = size / 2;
        if(size % 2 == 0) {
            // even
            return (double)(arr[mid] + arr[mid - 1]) / 2;
        } else {
            //odd
            return arr[mid];
        }
    }
}
