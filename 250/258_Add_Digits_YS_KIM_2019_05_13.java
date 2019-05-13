class Solution {
    public int addDigits(int num) {
        if(num < 10) return num;
        String str = Integer.toString(num);
        int sum = 0;
        for(int i = 0; i < str.length(); i++) {
            int digit = str.charAt(i) - '0';
            sum += digit;
        }
        return addDigits(sum);
    }
}
