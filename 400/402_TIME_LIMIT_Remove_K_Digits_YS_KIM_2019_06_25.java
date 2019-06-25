import java.math.*;

class Solution {
    private String charRemoveAt(String str, int p) {
        return str.substring(0, p) + str.substring(p + 1);
    }
    public String removeKdigits(String num, int k) {
        if(k == 0) return num;
        if(num.length() <= k) return "0";
        BigInteger retHelper = new BigInteger(num);
        for(int i = 0; i < num.length(); i++) {
            String next = charRemoveAt(num, i);
            String ret = removeKdigits(next, k - 1);
            retHelper = retHelper.min(new BigInteger(ret));
        }
        return retHelper.toString();
    }
}
