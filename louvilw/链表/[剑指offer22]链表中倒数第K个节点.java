/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        /*
        先循环一遍计算出链表长度count
        那么倒数第K个数，就是正数count - k
        */
        int count = 0;
        ListNode node = null;
        for (node = head; node != null; node = node.next) count++;
        for (node = head; count > k; count-- ) node = node.next;
        return node;
    }
}