package zhouhengzhe.华哥指导下的做题方式.链表.done;

public class LC_287_删除链表中的节点 {
    public void deleteNode(ListNode node) {
        node.val =node.next.val;
        node.next=node.next.next;
    }
}
