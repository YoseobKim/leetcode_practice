public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ret = 0;
        boolean isMinus = n < 0;
        for(int i = 0; i < 32; i++) {
            int bitInInt = n & (1 << i);
            int bit = bitInInt > 0 ? 1 : 0;
//            System.out.print(bit);
            ret = ret | bit << 31 - i;
        }
        // due to sign bit, the first bit (as it is reversed, the MSB of the parameter n) should be specially treated.
        if(isMinus) ret = ret | 1 << 0;
        return ret;
    }
}
