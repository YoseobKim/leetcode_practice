import java.math.BigInteger; 

class Solution {
    public int reverse(int x) {
        if(x == Integer.MIN_VALUE) return 0; // edge case. Integer.MIN_VALUE.
        int isNegative = x < 0 ? -1 : 1; // extract sign bit.

        BigInteger bi = BigInteger.valueOf(Math.abs(x)); 

        // use big integer to store x. make sure the value is absolute value.
        StringBuilder sb = new StringBuilder(bi.toString());

        // use big integer's helper method to make string.
        BigInteger reverted = new BigInteger(sb.reverse().toString());
        // overflow
        if(reverted.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) return 0;
        
        // revert the number and store it into big integer again.
        return reverted.intValue() * isNegative;
        // apply sign bit.
    }
}
