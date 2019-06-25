class Solution {
    public int findNthDigit(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            sb.append(i);
            if(sb.length() >= n) return sb.toString().charAt(n - 1) - '0';
        }
        return 0;
    }
}
