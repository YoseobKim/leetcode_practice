class Solution {
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        boolean carry = false;
        int sum = 0;
        // 2(0010) + 3(0011) = 5(0101)
        //c  1
        //a 0010
        //b 0011
        //   101
        for(int i = 0; i < 32; i++) {
            boolean bit1 = (a & (1 << i)) != 0 ? true : false;
            boolean bit2 = (b & (1 << i)) != 0 ? true : false;
            boolean sumbit = bit1 ^ bit2;
            sumbit = sumbit ^ carry;

            carry = (bit1 & bit2) || (bit1 ^ bit2) & carry;
            sum = sum | ((sumbit ? 1 : 0) << i);
        }
        return sum;
    }
}
