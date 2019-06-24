class Solution {
    public int maxRotateFunction(int[] A) {
        int n = A.length;
        if(n == 0) return 0;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++) {
            int start = (n - i) % n;
            int sum = 0;
            for(int j = 0; j < n; j++) {
                int index = (start + j) % n;
                int item = A[index];
                sum += j * item;
            }
            max = Math.max(max, sum);
        }
        
        return max;
    }
}
