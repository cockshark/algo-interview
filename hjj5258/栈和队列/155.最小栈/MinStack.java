package aigo.com.yz;
class MinStack {
    /**
     * 思路：使用辅助栈，一个用来顺序存储 返回 top 操作，一个用来存储最小值 getMin，当 pop 时候 两边同时 pop
     */
    Stack<Integer> stack1,minStack;
    public MinStack() {
        stack1 = new Stack<Integer>();
        minStack = new Stack<Integer>();
        // push 一个最大值，保证 在下一次push 的时候 peek 不会异常
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack1.push(val);
        // 每次都是最小
        minStack.push(Math.min(minStack.peek(), val));
    }

    public void pop() {
        stack1.pop();
        minStack.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}