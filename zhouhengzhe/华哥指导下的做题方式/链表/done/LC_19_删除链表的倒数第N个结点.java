package com.zhz.hua.week2;

public class LC_19_删除链表的倒数第N个结点 {
    /**
     * 虚拟节点找前节点，再删除
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }
        //创建一个临时节点
        ListNode dummy = new ListNode(0, head);
        ListNode cur=dummy;
        //获取总长度
        int size = getLength(head);
        //移动指针
        for (int i = 1; i < size - n+1; i++) {
            //遍历到要删除的节点
            cur = cur.next;
        }
        //删除指针
        cur.next=cur.next.next;
        return dummy.next;
    }

    private static int getLength(ListNode cur) {
        //总长度
        int size = 0;
        while (cur != null) {
            //计数
            size++;
            //移动
            cur = cur.next;
        }
        return size;
    }
}
