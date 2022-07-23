package com.zhz.hua.week2.done;

import com.zhz.utils.ListNode;

/**
 * 876. 链表的中间结点
 * <p>
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * 示例 2：
 * <p>
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/middle-of-the-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC_876_链表的中间结点_Easy {
    /**
     * 计数法
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {
        int size = 0;
        ListNode tmp = head;
        while (head != null) {
            size++;
            head = head.next;
        }
        if (size > 0) {
            int mid = size / 2 + 1;
            for (int i = 0; i <= mid; i++) {
                tmp = tmp.next;
            }
        }
        return tmp;
    }

    /**
     * 双指针
     * @param head
     * @return
     */
    public static ListNode middleNode1(ListNode head) {
        ListNode slow=head;
        ListNode fast=head.next;
        while (fast != null) {
            slow = slow.next;
            if(fast.next==null){
                return slow;
            }
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        //[1,2,6,3,4,5,6]
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(7);
        ListNode node3 = new ListNode(7);
        ListNode node4 = new ListNode(70);
        ListNode node5 = new ListNode(7);
        ListNode node6 = new ListNode(7);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;
        System.out.println(LC_876_链表的中间结点_Easy.middleNode(node1));
        System.out.println();
    }
}
