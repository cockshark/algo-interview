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
    ListNode reverseAfter = null;

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            int n = k;

            // 先模拟一次
            while (fast != null && n > 0) {
                fast = fast.next;
                n--;
            }
            if (n > 0) {
                // 不够了
                ListNode temp = reverseAfter;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = slow;
                return reverseAfter;
            }
            n = k;

            if (reverseAfter == null) {
                reverseAfter = reverse(slow, fast);
                ListNode reverseTemp = reverseAfter;
                reverseAfter = reverseTemp;
            } else {
                ListNode s = reverse(slow, fast);
                ListNode reverseTemp = s;
                ListNode temp = reverseAfter;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = reverseTemp;
            }


            slow = fast;
        }

        return reverseAfter;
    }

    public ListNode reverse(ListNode start, ListNode end) {
        ListNode prevNode = null;
        ListNode curNode = start;

        while (curNode != null && !curNode.equals(end)) {
            ListNode tempNode = curNode.next;
            curNode.next = prevNode;

            prevNode = curNode;
            curNode = tempNode;
        }

        return prevNode;
    }
}