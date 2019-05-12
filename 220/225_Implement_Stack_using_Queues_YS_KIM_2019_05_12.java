class MyStack {
    // Since deque is also queue, I'll use deck. (But implementation is linked list)
    List<Integer> list = new LinkedList<>();
    
    /** Initialize your data structure here. */
    public MyStack() {
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        list.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int index = list.size() - 1;
        int item = list.get(index);
        list.remove(index);
        return item;
    }
    
    /** Get the top element. */
    public int top() {
        return list.get(list.size() - 1);
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return list.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
