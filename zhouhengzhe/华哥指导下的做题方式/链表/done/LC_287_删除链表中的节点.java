package com.zhz.hua.week2;

public class LC_287_删除链表中的节点 {
    public void deleteNode(ListNode node) {
        node.val =node.next.val;
        node.next=node.next.next;
    }
}
