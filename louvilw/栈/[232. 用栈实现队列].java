class MyQueue {
    private Stack<Integer> intStack;
    private Stack<Integer> outStack;
    public MyQueue() {
        intStack = new Stack<>();
        outStack = new Stack<>();
    }
    
    public void push(int x) {
        intStack.push(x);
    }
    
    public int pop() {
        if (!outStack.isEmpty()){
            return outStack.pop();
        }else{
            while(!intStack.isEmpty()){
                outStack.push(intStack.pop());
            }
        }
        if(outStack.isEmpty()){
            return -1;
        }else{
            return outStack.pop();
        }
    }
    
    public int peek() {
        if (!outStack.isEmpty()){
            return outStack.peek();
        }else{
            while(!intStack.isEmpty()){
                outStack.push(intStack.pop());
            }
        }
        if(outStack.isEmpty()){
            return -1;
        }else{
            return outStack.peek();
        }
    }
    
    public boolean empty() {
        if(intStack.size() == 0 && outStack.size() == 0) return true;
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */