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
    public ListNode reverseList(ListNode head) {
        // 一个节点或者是空节点
        if (head == null || head.next == null) return head;
        ListNode curNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return curNode;
    }
}