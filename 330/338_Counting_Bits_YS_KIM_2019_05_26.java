class Solution {
    private int countBitsHelper(int num) {
        int ret = 0;
        for(int i = 0; i < 32; i++) {
            if((num & (1 << i)) != 0) ret++;
        }
        return ret;
    }
    
    public int[] countBits(int num) {
        int[] ret = new int[num + 1];
        for(int i = 0; i <= num; i++) {
            ret[i] = countBitsHelper(i);
        }
        return ret;
    }
}
