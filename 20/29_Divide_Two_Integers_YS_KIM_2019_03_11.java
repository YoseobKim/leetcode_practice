class Solution {
    public int divide(int dividend, int divisor) {
        boolean isDividendMinus = dividend < 0 ? true : false;
        boolean isDivisorMinus = divisor < 0 ? true : false;
        
        if(dividend == 0 || divisor == 0) return 0;
        boolean isMinus = isDividendMinus ^ isDivisorMinus; // dividend XOR divisor
        long ret = 0;
        long sum = 0;
        long absDividend = Math.abs(dividend);
        long absDivisor = Math.abs(divisor);
        if(dividend == Integer.MIN_VALUE && absDivisor == 1) return isMinus ? Integer.MIN_VALUE : Integer.MAX_VALUE; 
        // only overflow edgecase
        if(absDivisor == 1) return isMinus ? (int)-absDividend : (int)absDividend; // no need to check.
        if(absDividend == absDivisor) return isMinus ? -1 : 1; // no need to check.
        System.out.println(absDividend);
        if(absDividend < -1) {
            // overflow 
            absDividend = absDividend * -1;
        }
        while(sum <= absDividend) {
            sum += absDivisor;
            ret++;
            if(sum < 0) break; // overflow
        }
        if(ret > 0) ret--;
        
        return isMinus ? (int)-ret : (int)ret;
    }
}
