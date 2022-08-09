class MyStack {
    /*
    和栈实现队列一样，栈是先进后出，队列是先进先出
    queue1存元素也就是栈，queue2辅助queue1进栈，每次都为空
    每次入栈时，先把元素放进queue2，如果queue1不为空的话，
    就把queue1的元素依次出队列压进queue2，再把queue2赋值给queue1
    那么一开始在queue1的元素就变成了在queue2队列的后面，就变成了先进后出，后进先出的栈
    queue2的队列头等于栈顶，queue1的队列尾部等于栈底，最后也变成queue的头与底
     */
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public MyStack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()){
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 =queue2;
        queue2 = temp;
    }
    
    public int pop() {
        return queue1.poll();
    }
    
    public int top() {
        return queue1.peek();
    }
    
    public boolean empty() {
        return queue1.isEmpty();
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