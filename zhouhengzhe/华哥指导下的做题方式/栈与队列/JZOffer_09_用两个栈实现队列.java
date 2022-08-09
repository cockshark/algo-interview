package com.zhz.datastructures.swordfingeroffer.stack_queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhouhengzhe
 * @description: 用两个栈实现队列
 * @since v1
 */
public class JZOffer_09_用两个栈实现队列 {

    LinkedList<Integer> A;
    LinkedList<Integer> B;


    /**
     * initialize your data structure here.
     */
    public JZOffer_09_用两个栈实现队列() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }

    public void appendTail(int value) {
        A.addLast(value);
    }

    public int deleteHead() {
        if (!B.isEmpty()){
            return B.removeLast();
        }
        if (A.isEmpty()){
            return -1;
        }
        while (!A.isEmpty()){
            B.addLast(A.removeLast());
        }
        return B.removeLast();
    }

}
