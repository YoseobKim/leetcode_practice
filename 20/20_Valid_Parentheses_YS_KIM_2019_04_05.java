class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        if(len % 2 == 1) return false; // no need to check.
        Stack<Character> openStack = new Stack<>();
        char[] sArr = s.toCharArray();
        
        for(int i = 0; i < sArr.length; i++) {
            char c = sArr[i];
            if(c == '(' || c == '{' || c == '[') {
                // open.
                openStack.push(c);
            } else {
                if(openStack.isEmpty()) return false;
                else {
                    char prev = openStack.pop();
                    if(c == ')' && prev != '(') return false;
                    else if(c == '}' && prev != '{') return false;
                    else if(c == ']' && prev != '[') return false;
                }
            }
        }

        return openStack.isEmpty();
    }
}
