class Solution {
    public void reverseString(char[] s) {
        if(s.length <= 0) return;
        if(s.length <= 1) return;
        int mid = s.length % 2 == 0 ? s.length / 2 - 1 : s.length / 2;
        for(int first = 0; first <= mid; first++) {
            int end = (s.length - 1) - first;
            char temp = s[first];
            s[first] = s[end];
            s[end] = temp;
        }
    }
}
