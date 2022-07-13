package zhouhengzhe.华哥指导下的做题方式.链表.done;

import com.zhz.utils.ListNode;

public class LC_206_反转链表_Medium {
    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        ListNode listNode = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return listNode;
    }
    /**
     * 栈
     * @param head
     * @return
     */
     public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = new ListNode(0);
        ListNode cur=temp;
        Stack<Integer> s = new Stack<>();
        while (head != null) {
            s.push(head.val);
            head = head.next;
        }
        while (!s.isEmpty()) {
            cur.next = new ListNode(s.pop());
            cur=cur.next;
        }
        return temp.next;
    }
     /**
     * 迭代
     *
     * @param head
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

}
