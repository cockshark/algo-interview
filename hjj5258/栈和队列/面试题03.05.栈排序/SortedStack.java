class SortedStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public SortedStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int val) {
        // 思路：用 stack1 stack2 两个栈，我们只需要保证 最小的永远在栈顶即可
        // stack1 用来对外部操作，借助 stack2 达到排序，
        // 如果 push 的值比当前 stack1 栈顶大，直接 push stack1，
        // 否则，需要将 stack1 弹出至 stack2，最后在搬运回来，这样就保证了有序（每次 push）

        // 如果不是空 则把stack1 的元素 转移到 stack2中
        while (!stack1.isEmpty() && stack1.peek() < val) {
            stack2.push(stack1.pop());
        }
        // 把当前元素入stack1
        stack1.push(val);
        // 再把原来 stack1 搬运到 stack2的元素，搬运回 stack1
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public void pop() {
        if (!stack1.isEmpty()) {
            stack1.pop();
        }
    }

    public int peek() {
        if (!stack1.isEmpty()) {
            return stack1.peek();
        } else {
            return -1;
        }
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
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