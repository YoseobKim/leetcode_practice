class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < tokens.length; i++) {
            String item = tokens[i];
            if(item.equals("+") || item.equals("-") || 
               item.equals("*") || item.equals("/")) {
                if(stack.isEmpty()) return 0;
                int val1 = stack.pop();
                int val2 = stack.pop();
                int cal = 0;
                if(item.equals("+")) {
                    cal = val2 + val1;
                } else if(item.equals("-")) {
                    cal = val2 - val1;
                } else if(item.equals("*")) {
                    cal = val2 * val1;
                } else {
                    cal = val2 / val1;
                }
                stack.push(cal);
            } else {
                int val = Integer.parseInt(item);
                stack.push(val);
            }
        }
        
        return stack.isEmpty() ? 0 : stack.pop();
    }
}
