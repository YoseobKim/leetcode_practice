import java.math.BigInteger; 
class Solution {
    private BigInteger getB(int[] b) {
        if(b.length <= 0) return new BigInteger("0");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < b.length; i++) {
            sb.append(b[i]);
        }
        return new BigInteger(sb.toString());
    }
    
    public int superPow(int a, int[] b) {
        if(b.length <= 0) return 0;

        BigInteger aBig = new BigInteger("" + a);
        return aBig.modPow(getB(b), new BigInteger("1337")).intValue();
    }
}
