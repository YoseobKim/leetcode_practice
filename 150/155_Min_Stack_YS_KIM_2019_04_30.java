class MinStack {
    int min = 0;
    Stack<Integer> stack_ = null;
    
    /** initialize your data structure here. */
    public MinStack() {
        min = Integer.MAX_VALUE;
        stack_ = new Stack<Integer>();
    }
    
    public void push(int x) {
        min = Math.min(x, min);
        stack_.push(x);
    }
    
    // The only O(N) operation
    public void pop() {
        if(stack_.size() > 0) {
            stack_.pop();
            List<Integer> arr = new ArrayList<>();
            while(!stack_.isEmpty()) {
                int item = stack_.pop();
                arr.add(item);
            }
            min = Integer.MAX_VALUE;
            for(int i = arr.size() - 1; i >= 0; i--) {
                int item = arr.get(i);
                push(item);
            }
        }        
        
    }
    
    public int top() {
        return stack_.size() > 0 ? stack_.peek() : 0;
    }
    
    public int getMin() {
        return stack_.size() > 0 ? min : 0;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
