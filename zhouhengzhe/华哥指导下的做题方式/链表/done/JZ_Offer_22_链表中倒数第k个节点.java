package com.zhz.hua.week2;

// public class JZ_Offer_22_链表中倒数第k个节点 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        if (k >= length) {
            return head;
        }
        int i = 0;
        while (k > i && fast.next != null) {
            fast = fast.next;
            i++;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.next;
}
