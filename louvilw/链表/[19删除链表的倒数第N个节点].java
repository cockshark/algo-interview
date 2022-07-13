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
        /*
        先遍历一遍算链表总共有count个数
        一共有count个数，删去倒数第几个，就是正数第count-n+1（从1开始算起）
        */
        if (head.next == null) return null;
        ListNode temp = head;
        int count = 1;
        //算出链表长度
        while (temp.next != null){
            count++;
            temp = temp.next;
        }
        //从1开始算
        int number = 1;
        //新建一个哑巴节点，哑巴的后驱节点指向头节点
        // ListNode dummy = new ListNode(0, head);
        ListNode cur = head;
        if (count == n){
            return head.next;
        }
        for (int i = 1; i < count - n ; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;
    }
}