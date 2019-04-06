class Solution {
    public int[] plusOne(int[] digits) {
        if(digits.length <= 0) {
            int[] ret = {1};
            return ret;
        }
        for(int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] + 1 <= 9) {
                digits[i] = digits[i] + 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        int[] ret = new int[digits.length + 1];
        ret[0] = 1;
        for(int i = 1; i < ret.length; i++) ret[i] = digits[i - 1];
        return ret;
    }
}
