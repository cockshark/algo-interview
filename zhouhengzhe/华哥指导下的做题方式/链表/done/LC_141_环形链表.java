package zhouhengzhe.华哥指导下的做题方式.链表.done;

public class LC_141_环形链表 {
     /**
         * 快慢指针
         */
    public boolean hasCycle(ListNode head) {
       
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
