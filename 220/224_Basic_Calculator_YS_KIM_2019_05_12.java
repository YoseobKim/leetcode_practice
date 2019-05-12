class Solution {
    private int getValidateIndex(String s, int start) {
        Stack<Character> stack = new Stack<>();
        
        for(int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') stack.push(c);
            else if(c == ')') {
                stack.pop();
                if(stack.isEmpty()) return i;
            }
        }
        
        return -1;
    }
        
    public int calculate(String s) {
        List<String> calcQueue = new LinkedList<>();
        // the reason why using queue is want to calc it in in-order.
        
        int fromNum = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '+' || c == '-') {
                String numCandidate = s.substring(fromNum, i).trim();
                if(numCandidate.length() > 0) calcQueue.add(s.substring(fromNum, i).trim());
                calcQueue.add("" + c);
                fromNum = i + 1;
            } else if(c == '(') {
                int closingValidIdx = getValidateIndex(s, i);
                String substring = s.substring(i + 1, closingValidIdx);
                int result = calculate(substring);
                i = closingValidIdx;
                fromNum = i + 1;
                calcQueue.add("" + result);
            }
        }
        
        if(fromNum < s.length()) {
            calcQueue.add(s.substring(fromNum, s.length()).trim());
        }
        /*
        System.out.println("inside Queue");
        for(String str : calcQueue) {
            System.out.print(str);
        }
        System.out.println("");
        */
        while(calcQueue.size() > 2) {
            int num1 = Integer.parseInt(calcQueue.get(0));
            String op = calcQueue.get(1);
            int num2 = Integer.parseInt(calcQueue.get(2));
            calcQueue.remove(0);
            calcQueue.remove(0);
            calcQueue.remove(0);

            if(op.equals("+")) {
                int ret = num1 + num2;
                calcQueue.add(0, "" + ret);
            } else if(op.equals("-")) {
                int ret = num1 - num2;
                calcQueue.add(0, "" + ret);
            }
        }
        
        return Integer.parseInt(calcQueue.get(0));
    }
}
