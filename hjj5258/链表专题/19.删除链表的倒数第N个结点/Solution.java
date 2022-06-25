package aigo.com.yz;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow  = head;
        ListNode fast = head;
        // 构造双指针 n 差
        for(int i =0;i<n;i++){
            fast = fast.next;
        }
        // 如果 fast 走完为空，说明要删除的是头节点 1 -> 2  n=2,要删除的就是 1 这个节点
        if(fast == null) return head.next;

        // n差 一起走，fast走到最后一个，slow就刚好到 要删除的节点的前一个
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        // 改变指向，直接删除
        slow.next  = slow.next.next;


        return head;
    }

    /**
     * 头指针方法
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 由于题目头节点需要单独处理，所以构造一个虚拟节点，避免构造 n 差时候产生错误
        ListNode dumHead = new ListNode(0);
        dumHead.next = head;
        ListNode slow  = dumHead;
        ListNode fast = head;

        for(int i = 0;i<n;i++){
            fast = fast.next;
        }

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        ListNode delNode  = slow.next;
        slow.next = slow.next.next;
        return dumHead.next;
    }
}