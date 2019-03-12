class Solution {
    // should find "the longest" parentheses set that is valid.
    // not checking just a number of valid parenthesis.
    public int longestValidParentheses(String s) {
        if(s.length() <= 1) return 0;
        char[] sArr = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        stack.push(-1); // first insert -1 for when all string is valid.
        
        for(int i = 0; i < sArr.length; i++) {
            char item = sArr[i];
            if(item == '(' && i < sArr.length - 1) {
                // Opening parentheses case
                stack.push(i);
            } else if(item == ')') {
                // closing parentheses case
                stack.pop(); // first pop it.
                if(stack.empty()) { 
                    // empty stack means latest closing parenthesis was not valid one, 
                    // and already all open parentheses were consumed.
                    stack.push(i); 
                    // Base should be changed to i
                    // as next open parenthesis should be the first index.
                    // (before valid index)
                } else {
                    // valid. See previous open parenthesis index.
                    // length between preious and current can be longest.
                    int length = i - stack.peek();
                    max = max > length ? max : length;
                }
            }
        }

        return max;
    }
}
