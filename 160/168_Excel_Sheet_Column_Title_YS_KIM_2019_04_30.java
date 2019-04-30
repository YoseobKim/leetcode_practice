class Solution {
    private String convertToAlpha(int n) {
        if(n == 0) return "Z";
        char c = (char)(n - 1 + (int) 'A');
        return "" + c;
    }
    public String convertToTitle(int n) {
        if(n <= 26) return convertToAlpha(n);
        int rem = n % 26;
        if(rem == 0) return convertToTitle(n / 26 - 1) + convertToAlpha(rem);
        return convertToTitle(n / 26) + convertToAlpha(rem);
    }
}
