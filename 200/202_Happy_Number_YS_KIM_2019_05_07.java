class Solution {
    Map<Integer, Boolean> memo = new HashMap<>();
    
    public boolean isHappy(int n) {
        if(memo.containsKey(n)) return false;
        
        int ncpy = n;
        int val = 0;

        while(ncpy > 0) {
            int curDigit = ncpy % 10;
            val += curDigit * curDigit;
            ncpy = ncpy / 10;
        }
        
        if(val == 1) return true;
        else {
            memo.put(n, false);
            return isHappy(val);
        }        
    }
}
