package com.zhz.hua.week2.done;

import com.zhz.utils.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 示例 2：
 *
 *
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC_83_删除排序链表中的重复元素_Easy {
    /**
     * 虚拟节点
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<Integer> set=new HashSet<>();
        ListNode tmp=new ListNode(0);
        tmp.next=head;
        ListNode pre=tmp;
        while (pre.next != null) {
            if (set.contains(pre.next.val)){
                pre.next=pre.next.next;
            }else {
                set.add(pre.next.val);
                pre=pre.next;
            }
        }
        return head;
    }
    public static ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre=head;
        while (pre.next != null){
            if (pre.val == pre.next.val){
                pre.next=pre.next.next;
            }else {
                pre=pre.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        //[1,2,6,3,4,5,6]
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        System.out.println(LC_83_删除排序链表中的重复元素_Easy.deleteDuplicates(node1));
    }
}
