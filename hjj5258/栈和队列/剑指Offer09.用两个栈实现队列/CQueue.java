package aigo.com.yz;
class CQueue {
    /**
     * 分析：队列是先进先出，栈是先进后出，那么用两个栈则应该是 如 stack 1 后在 pop 到 stack 2
     *      这样数据就是 先进先出，需要主要的是，什么时候转移元素？
     *      - appendTail 入队操作 添加到队尾，直接累积在 stack 1即可
     *      - deleteHead 这里需要判断 stack 2 是不是空，如果是说明 还没有从 stack 1 转移元素到 stack2，
     *                   那么进行转移，在 pop 即可
     *                   如果不是空，那应该是 pop stack 2 中的元素
     */
    Stack<Integer> stack1,stack2;
    public CQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                Integer stack1Top = stack1.pop();
                stack2.push(stack1Top);
            }
            if(stack2.isEmpty()){
                return -1;
            }
        }
        return stack2.pop();
    }
}