package zhouhengzhe.华哥指导下的做题方式.链表.done;

import com.zhz.utils.ListNode;

import java.math.BigDecimal;

/**
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC_2_两数相加_Medium {

    /**
     * 长度限制在0-13位之间该方法可用
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        while (l1 != null) {
            sb.append(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            sb1.append(l2.val);
            l2 = l2.next;
        }
        BigDecimal b1 = new BigDecimal(sb.reverse().toString());
        BigDecimal b2 = new BigDecimal(sb1.reverse().toString());
        //总额
        BigDecimal b3 = b1.add(b2);
        StringBuilder s = new StringBuilder();
        s.append(b3);
        s.reverse();
        ListNode dummy = new ListNode(0);
        ListNode cur=dummy;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            System.out.println(c);
            cur.next = new ListNode(Integer.parseInt(String.valueOf(c)));
            cur = cur.next;
        }
        return dummy.next;
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {

        return null;
    }
    public static void main(String[] args) {
        //[1,2,6,3,4,5,6]
//        ListNode node1 = new ListNode(2);
//        ListNode node2 = new ListNode(4);
//        ListNode node3 = new ListNode(9);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = null;
//
//        ListNode l1 = new ListNode(5);
//        ListNode l2 = new ListNode(6);
//        ListNode l3 = new ListNode(4);
//        ListNode l4 = new ListNode(9);
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next=null;
        //342+465
//        ListNode node1 = new ListNode(3);
//        ListNode node2 = new ListNode(4);
//        ListNode node3 = new ListNode(2);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = null;
//
//        ListNode l1 = new ListNode(4);
//        ListNode l2 = new ListNode(6);
//        ListNode l3 = new ListNode(5);
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = null;
//        System.out.println(LC_2_两数相加_Medium.addTwoNumbers(node1,l1));
    }

}
