class Solution {
    // Time Limit Exceeded
    /*
    public int countDigitOne(int n) {
        int ret = 0;
        for(int i = 1; i <= n; i++) {
            String converted = Integer.toString(i);
            for(int j = 0; j < converted.length(); j++) {
                if(converted.charAt(j) == '1') {
                    ret++;
                }
            }
        }
        return ret;
    }
    */
    // Mathematically solve it
    public int countDigitOne(int n) {
        int ones = 0;
        for (long m = 1; m <= n; m *= 10)
            ones += (n / m + 8) / 10 * m + (n / m % 10 == 1 ? n % m + 1 : 0);
        return ones;
    }
}
