/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode x;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        //只有一个节点或者没有节点直接返回空
        if (head == null || head.next == null) return false;
        ListNode fast = head.next,slow = head;
        //快指针和快指针的下一个和下一个节点不为空时才进入循环
        while (fast != null && fast.next != null){
            //如果相等就时有环
            if (fast == slow) return true;
            //慢指针移动一次，快指针移动两次
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}