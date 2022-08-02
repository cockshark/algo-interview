package zhouhengzhe.华哥指导下的做题方式.链表.done;

public class LC_24_两两交换链表中的节点 {
     /**
     * 解答：
     * 1、两两交换的本质就是重复子问题，把重复的问题细粒化之后就是一个简单的交换数据，然后递归解决就行
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode cur = head;
        //临界点
        if (cur == null || cur.next == null) {
            return cur;
        }
        ListNode next = cur.next;
        cur.next = swapPairs(next.next);
        next.next = cur;
        return next;
    }
}
