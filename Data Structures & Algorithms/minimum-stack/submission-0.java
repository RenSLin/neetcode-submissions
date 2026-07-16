class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minTrack;

    public MinStack() {
        this.stack = new ArrayDeque<>();
        this.minTrack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minTrack.isEmpty()) {
            minTrack.push(val);
        } else {
            minTrack.push(Math.min(minTrack.peek(), val));
        }
    }
    
    public void pop() {
        stack.pop();
        minTrack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minTrack.peek();
    }
}
