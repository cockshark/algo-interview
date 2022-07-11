class SortedStack {
    /*
    入栈前，先判断栈是否为空或者入栈元素是否小于栈顶元素，如果是的话直接入栈
    如果大于栈顶元素的话，就把栈中小于value的值依次弹出压进temp中
    然后再把temp中的内容重新依次压进栈回来
    */
    private Deque<Integer> stack, temp;
    public SortedStack() {
        stack = new LinkedList<>();
        temp = new LinkedList<>();
    }
    public void push(int val) {
        if (isEmpty() || val < stack.peek()) stack.push(val);
        else {
            // 将栈中小于val的值暂存到temp中
            while (!stack.isEmpty() && val > stack.peek()) {
                temp.push(stack.pop());
            }
            stack.push(val);
            // 将temp中的内容重新依次push回来
            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) return;
        stack.pop();
    }
    
    public int peek() {
        if (stack.isEmpty()) return -1;
        return stack.peek();
    }
    
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

/**
 * Your SortedStack object will be instantiated and called as such:
 * SortedStack obj = new SortedStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.isEmpty();
 */