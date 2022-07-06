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
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode curNode = dummyNode;
        while (curNode != null && curNode.next != null && curNode.next.next != null) {
            ListNode node1 = curNode.next;
            ListNode node2 = curNode.next.next;

            node1.next = node2.next;
            node2.next = node1;
            curNode.next = node2;
            curNode = node1;
        }

        return dummyNode.next;
    }
}