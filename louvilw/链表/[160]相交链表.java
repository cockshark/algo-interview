/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //把其中一条链表的末尾指向另一条链表，如果链表成环就代表是有交点的
        if (headA == null || headB == null) return null;
        ListNode headB2 = headB;
        //B链表的尾部与A链表的头部连接在一起
        while (headB2.next != null) {headB2 = headB2.next;}
        headB2.next = headA;
        //快慢指针找环
        ListNode slow = headB;
        ListNode fast = headB.next;
        while (true) {
            if (fast == null || fast.next == null) {
                //没有找到环，返回空
                headB2.next = null;
                return null;
            }
            //如果快慢指针相等的时候，跳出去
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) break;
            }
        fast = headB;
        while (fast != slow){
            slow = slow.next;
            fast = fast.next;
        }
        //还原链表
        headB.next = null;
        return fast;
    }
}