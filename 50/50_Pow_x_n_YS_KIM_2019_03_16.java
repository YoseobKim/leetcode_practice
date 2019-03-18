class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1.0;
        if(n == 1) return x;
        if(Double.compare(x, 0.0) == 0) {
            return 0.0;
        }
        if(Double.compare(x, 1.0) == 0) {
            return 1.0;
        }
        boolean isEven = n % 2 == 0 ? true : false;
        long nextN = n; // to avoid overflow (when Integer.MIN_VALUE case)
        if(n < 0) {
            x = 1 / x; // -n means  1 / x
            nextN = -nextN; // abs
        }
        
        // after this call, the function will use x * x as x. so n should be decreased to n / 2
        // 2 ^ 6 = 2 * 2 * 2 * 2 * 2 * 2
        // 4 ^ 3 =     4   *   4   *   4
        // 16 ^ 1 * 4 =        16  *   4
        return isEven ? myPow(x * x, (int)(nextN / 2)) : x * myPow(x * x, (int)(nextN / 2));
    }
}
