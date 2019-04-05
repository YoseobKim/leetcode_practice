class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        String str = Integer.toString(x);
        int mid = str.length() % 2 == 0 ? str.length() / 2 - 1 : str.length() / 2;
        boolean ret = true;
        for(int i = 0; i <= mid; i++) {
            int left = i;
            int right = str.length() - 1 - i;
            if(str.charAt(left) == str.charAt(right)) continue;
            ret = false;
            break;
        }
        
        return ret;
    }
}
