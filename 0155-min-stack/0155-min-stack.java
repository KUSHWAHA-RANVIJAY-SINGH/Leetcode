class MinStack {
    private Deque<Integer> stack1=new ArrayDeque<>();
    private Deque<Integer> stack2=new ArrayDeque<>();

    public MinStack() {
        stack2.push(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        stack1.push(val);
        stack2.push(Math.min(val,stack2.peek())); 
    }
    
    public void pop() {
       stack1.pop();
        stack2.pop(); 
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int getMin() {
        return stack2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */