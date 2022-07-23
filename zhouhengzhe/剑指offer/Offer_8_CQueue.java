package com.zhz.SwordOffer;

import java.util.LinkedList;

/**
 * @decript 用两个栈实现一个队列。
 * 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 */
public class Offer_8_CQueue {

    private LinkedList<Integer> l1;
    private LinkedList<Integer> l2;

    public Offer_8_CQueue() {
        l1 = new LinkedList<>();
        l2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        l1.addLast(value);
    }

    public int deleteHead() {
        if (!l2.isEmpty()) {
            return l2.removeLast();
        }
        if (l1.isEmpty()) {
            return -1;
        }
        while (!l1.isEmpty()) {
            l2.addLast(l1.removeLast());
        }
        return l2.removeLast();
    }
}
