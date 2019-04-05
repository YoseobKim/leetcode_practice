class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        if(n == 2) return "11";
        if(n == 3) return "21";
        if(n == 4) return "1211";
        if(n == 5) return "111221";
        String prevCountAndSay = countAndSay(n - 1);
        String ret = "";
        char prev = prevCountAndSay.charAt(0);
        int count = 1;
        for(int i = 1; i < prevCountAndSay.length(); i++) {
            if(prev == prevCountAndSay.charAt(i)) {
                count++;
                if(i >= prevCountAndSay.length() - 1) {
                    ret += Integer.toString(count) + prevCountAndSay.charAt(i);
                }
            } else {
                ret += Integer.toString(count) + prev;
                count = 1;
                if(i >= prevCountAndSay.length() - 1) {
                    ret += Integer.toString(count) + prevCountAndSay.charAt(i);
                }
            }
            prev = prevCountAndSay.charAt(i);
        }
        return ret;
    }
}
