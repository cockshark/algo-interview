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
    public ListNode oddEvenList(ListNode head) {
        /*
        原始链表头节点为head，也是奇数链表的头节点以及结果链表的头节点
        head的后一个节点是偶数链表的头节点。即evenhead=head.next，则evenhead是偶数链表的头节点
        然后轮流迭代更新奇偶节点，odd = head ， even = evenHead
        奇数的后一个节点指向偶数的后一个节点，odd.next = even.next，然后odd = odd.next 让odd变成even的后一个节点
        偶数的后一个节点指向奇数的后一个节点, even.next = odd.next，然后even = even.next 让even变成odd的后一个节点
        最后令 odd.next = evenHead，将偶数链表连接在奇数链表之后
        */
        if (head == null) return head;
        ListNode evenhead = head.next;
        ListNode odd = head;
        ListNode even = evenhead;
        while (even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenhead;
        return head;
    }
}