package aigo.com.yz;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     * 递归
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        // 已排序的链表 重复一定是相邻的
        if (head == null || head.next == null)
            return head;

        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val) {
            head = head.next;
        }

        return head;
    }
}