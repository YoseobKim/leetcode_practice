class Solution {
   private int sqrt(int num) {
        int ret = 0;
        for(long i = 1; i * i <= num; i++) {
            ret = (int)i;
        }
        return ret;
    }
    
    public boolean isPerfectSquare(int num) {
        if(num == 0) return false;
        //int sqrt = (int)Math.sqrt(num);
        int sqrt = sqrt(num);
        return sqrt * sqrt == num;
    }
}
