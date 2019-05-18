class Solution {
    private String charRemoveAt(String str, int p) {
        return str.substring(0, p) + str.substring(p + 1);
    }
    
    private String removeInvalidParenthesesHelper(String s) {
        String ret = "";
        if(s.length() <= 1) return ret;
        Stack<Integer> parenthesesStack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            if(item == '(') {
                parenthesesStack.add(i);
                ret += item;
            } else if(item == ')') {
                if(parenthesesStack.isEmpty()) {
                    // current ')' is invalid and should be removed
                    String substringFromNow = s.substring(i + 1, s.length());
//                    System.out.println(substringFromNow);
                    String left = removeInvalidParenthesesHelper(substringFromNow);
                    ret += left;
                    return ret;
                } else {
                    parenthesesStack.pop();
                    ret += item;
                }
            } else {
                ret += item;
            }
        }
        
        int diff = 0;
        // have invalid open parentheses
        for(int invalidOpen : parenthesesStack) {
            int removeIndex = invalidOpen - diff;
            ret = charRemoveAt(ret, removeIndex);
            diff++;
        }
        
        return ret;
    }
    
    public List<String> removeInvalidParentheses(String s) {
        List<String> ret = new ArrayList<>();
        String str = removeInvalidParenthesesHelper(s);
        System.out.println(str);
        return ret;
    }
}
