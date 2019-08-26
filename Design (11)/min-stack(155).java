// T = O(1)	
// S = O(n)
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty()) minStack.push(x);
        else {
            if(x <= minStack.peek()) minStack.push(x);
        }
    }
    
    public void pop() {
        int peek1 = stack.peek();
        if(peek1 == minStack.peek()) {
            stack.pop();
            minStack.pop();
        } else stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    // retrieve min element in stack
    public int getMin() {
        return minStack.peek();
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