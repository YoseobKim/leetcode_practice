class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        long ret = 0xFFFFFFFF;
        if(m == 0 || n == 0) return 0;
        for(long i = m; i <= n; i++) {
            ret = ret & i;
            if(ret == 0) break;
        }
        return (int)ret;
    }
}
