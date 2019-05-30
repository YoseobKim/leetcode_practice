class Solution {
    private int[] merge(int[] arr1, int[] arr2) {
        int[] ret = new int[arr1.length + arr2.length];
        int left = 0;
        int right = 0;
        int index = 0;
        while(left < arr1.length && right < arr2.length) {
            if(arr1[left] < arr2[right]) {
                ret[index++] = arr1[left++];
            } else if(arr1[left] > arr2[right]) {
                ret[index++] = arr2[right++];
            } else {
                ret[index++] = arr1[left++];
                ret[index++] = arr2[right++];
            }
        }
        
        for(int i = left; i < arr1.length; i++) {
            ret[index++] = arr1[i];
        }
        
        for(int i = right; i < arr2.length; i++) {
            ret[index++] = arr2[i];
        }
        
        return ret;
    }
    
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix.length <= 0) return 0;
        if(matrix[0].length <= 0) return 0;
        int[] arr = matrix[0];
        for(int i = 1; i < matrix.length; i++) {
            arr = merge(arr, matrix[i]);
        }
        return arr[k - 1];
    }
}
