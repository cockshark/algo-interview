package com.zhz.SwordOffer;

import com.zhz.utils.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 从尾到头打印链表
 */
public class Offer_6_ReversePrint {

    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     * 输入：head = [1,3,2]
     * 输出：[2,3,1]
     * 解决：
     * 栈
     * 递归
     * 链表
     * 双指针
     *
     * @param head 链表
     * @return 返回倒叙值
     */
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    List<Integer> res = new ArrayList<>();

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public int[] reversePrint1(ListNode head) {
        reversePrintRec(head);
        return res.stream().mapToInt(Integer::intValue).toArray();

    }


    public void reversePrintRec(ListNode head) {
        if (head == null) {
            return;
        }
        reversePrintRec(head.next);
        res.add(head.val);
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        Offer_6_ReversePrint offer_6 = new Offer_6_ReversePrint();
        for (int i : offer_6.reversePrint(listNode)) {
            System.out.println(i);
        }
        for (int i : offer_6.reversePrint1(listNode)) {
            System.out.print(i+"\t");
        }
    }

}
