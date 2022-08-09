package com.zhz.datastructures.swordfingeroffer.stack_queue;

import java.util.Stack;

/**
 * @author zhouhengzhe
 * @description: 包含min函数的栈
 * @since v1
 */
public class JZOffer_30_包含min函数的栈 {

    Stack<Integer> xStack;
    Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public JZOffer_30_包含min函数的栈() {
        xStack = new Stack<>();
        minStack = new Stack<>();

    }
    public void push(int x) {
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
        xStack.push(x);
    }

    public void pop() {
        if (xStack.pop().equals(minStack.peek())){
            minStack.pop();
        }
    }

    public int top() {
        return xStack.peek();
    }

    public int min() {
        if (minStack.isEmpty()){
            return 0;
        }
        return minStack.peek();
    }
}
