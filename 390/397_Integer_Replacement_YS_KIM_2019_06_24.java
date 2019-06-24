class Solution {
    /*
    private int integerReplacementHelper(int n, int calls) {
        if(n <= 0) return Integer.MAX_VALUE;
        if(n == 1) return calls;
        if(n % 2 == 1) {
            return Math.min(integerReplacementHelper(n - 1, calls + 1), integerReplacementHelper(n + 1, calls + 1));
        }
        return integerReplacementHelper(n / 2, calls + 1);
    }
    */
    
    public int integerReplacement(int n) {
        if(n == 1) return 0;
        if(n == Integer.MAX_VALUE) {
            return integerReplacement(n - 1);
        }
        if(n % 2 == 1) {
            return Math.min(integerReplacement(n - 1), integerReplacement(n + 1)) + 1;
        } else {
            return integerReplacement(n / 2) + 1;
        }
    }
}
