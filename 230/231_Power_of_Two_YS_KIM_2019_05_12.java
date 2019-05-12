class Solution {
    private boolean isSet(int n, int i) {
        int num = n & 1 << i;
        return num > 0;
    }
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        boolean checked = false;
        for(int i = 0; i < 32; i++) {
            boolean isOne = isSet(n, i);
            if(isOne) {
                if(!checked) checked = true;
                else return false;
            }
        }
        return true;
    }
}
