class Solution {
    private boolean isPalindrome(String s) {
        String rev = new StringBuffer(s).reverse().toString();
        return rev.equals(s);
    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<>();
        
        // exceptional case
        if(s.length() <= 0) {
            ret.add(new ArrayList<>());
            return ret;
        }
        
        // When the string length is 1, the string is always palindrome
        if(s.length() <= 1) {
            List<String> item = new ArrayList<>();
            item.add(s);
            ret.add(item);
            return ret;
        }
        
        // initial case
        if(isPalindrome(s)) {
            List<String> item = new ArrayList<>();
            item.add(s);
            ret.add(item);
        }
        
        for(int i = 1; i < s.length(); i++) {
            String sub1 = s.substring(0, i);
            String sub2 = s.substring(i, s.length());
            if(isPalindrome(sub1)) {
                // try next
                List<List<String>> nextPalindromes = partition(sub2);
                for(List<String> li : nextPalindromes) {
                    List<String> item = new ArrayList<>(li);
                    item.add(0, sub1);
                    ret.add(item);
                }
            }
        }
        
        return ret;
    }
}
