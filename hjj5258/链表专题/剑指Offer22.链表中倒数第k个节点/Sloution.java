package aigo.com.yz;
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
        // 反转链表 正向查找，到 k 个断开,再把链表反转回去
        ListNode descNode = revers(head);
        ListNode s = descNode;
        while (k != 1) {
            s = s.next;
            k--;
        }

        s.next = null;

        return revers(descNode);
    }
    public ListNode revers(ListNode head) {
        ListNode prevNode = null;
        ListNode curNode = head;
        while (curNode != null) {
            ListNode tempNode = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = tempNode;
        }
        return prevNode;
    }

    /* ================== 解法二 双指针 ===============*/
    public ListNode getKthFromEnd(ListNode head, int k) {
        // 构造 k 差，fast == null 时候，slow刚好是 k个倒数
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}