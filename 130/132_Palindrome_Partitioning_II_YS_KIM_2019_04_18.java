class Solution {
    private Map<String, Integer> memo = new HashMap<>();
    
    private boolean isPalindrome(String s) {
        String rev = new StringBuffer(s).reverse().toString();
        return rev.equals(s);
    }
    
    public int minCut(String s) {
        int min = Integer.MAX_VALUE;
        if(memo.containsKey(s)) return memo.get(s);
        
        if(s.length() <= 1) {
            memo.put(s, 0);
            return 0;
        }
        
        if(isPalindrome(s)) {
            memo.put(s, 0);
            return 0;
        }
        
        for(int i = 1; i < s.length(); i++) {
            String sub1 = s.substring(0, i);
            String sub2 = s.substring(i, s.length());
            if(isPalindrome(sub1)) {
                int nextMin = minCut(sub2);
                min = Math.min(min, nextMin + 1);
            }
        }
        
        memo.put(s, min);
        return min;
    }
}
