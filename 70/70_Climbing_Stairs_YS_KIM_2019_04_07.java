class Solution {
    public int climbStairs(int n) {
        if(n <= 0) return 0;
        if(n <= 1) return 1;
        if(n <= 2) return 2;
        
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        
        for(int i = 3; i < arr.length; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }
        
        return arr[n];
    }
}
