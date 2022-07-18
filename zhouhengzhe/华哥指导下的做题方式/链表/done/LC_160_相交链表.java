package zhouhengzhe.华哥指导下的做题方式.链表.done;

public class LC_160_相交链表 {
    /**
     * 若相交，链表A： a+c, 链表B : b+c. a+c+b+c = b+c+a+c 。则会在公共处c起点相遇。
     * 若不相交，a +b = b+a 。因此相遇处是NULL
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null ||headB==null){
            return null;
        }
        ListNode curA=headA;
        ListNode curB=headB;
        while (curA!=curB){
            curA=curA==null?headB:curA.next;
            curB=curB==null?headA:curB.next;
        }
        return curA;
    }
    
}
