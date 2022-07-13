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
    public ListNode reverseList(ListNode head) {
        //伪造一个前节点
        ListNode prev = new ListNode(0);
        ListNode curr = head;
        while (prev != null){
            //next后驱节点就是curr当前节点的后一位(临时存的)
            ListNode next = curr.next;
            //把后面的节点指回前一个节点，翻转
            curr.next = prev;
            //把前驱结点后移一位
            prev = curr;
            //把当前节点后移一位
            curr = next;
        }
        return cur;
    }
}