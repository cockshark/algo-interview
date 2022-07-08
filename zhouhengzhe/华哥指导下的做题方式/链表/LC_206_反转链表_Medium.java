package com.zhz.hua.week2;

import com.zhz.utils.ListNode;

public class LC_206_反转链表_Medium {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next==null){
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return node;
    }
}
