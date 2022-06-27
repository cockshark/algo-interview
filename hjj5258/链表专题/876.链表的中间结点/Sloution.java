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
     * 快慢指针
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // 快指针与慢指针始终保持2倍，快指针走到尽头，慢指针就是中间位置
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    /**
     * 暴力版本 循环计算 size 大小
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while (head != null) {
            head = head.next;
            size++;
        }

        int target = size / 2;
        int j = 0;
        while (temp != null) {
            if (j == target) {
                return temp;
            }
            temp = temp.next;
            j++;
        }
        return head;
    }
}