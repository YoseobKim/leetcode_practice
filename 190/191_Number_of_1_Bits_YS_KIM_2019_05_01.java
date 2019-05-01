public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ret = 0;
        if(n < 0) ret++;
        for(int i = 0; i < 32; i++) {
            if((n & (1 << i)) > 0) ret++;
        }
        return ret;
    }
}
