/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 思路：由于 A、B 两个链表长短不一，如果需要找到相交的节点，则需要距离相交节点，一样的位置开始移动
        if(headA == null || headB == null) return null;
        int headASize = 0;
        ListNode curHeadA = headA;
        ListNode preA = headA;
        ListNode preB = headB;
        // 计算 A 长度
        while(curHeadA != null){
            headASize++;
            curHeadA = curHeadA.next;
        }
        // 计算 B 长度
        int headBSize = 0;
        ListNode curHeadB = headB;
        while(curHeadB != null){
            headBSize++;
            curHeadB = curHeadB.next;
        }
        // 判断哪个哪个链表长？
        int stepSize = headASize - headBSize;
        // 如果是 A 长，则需要移动 stepSize 步
        if(stepSize > 0){
            while(stepSize > 0){
                preA = preA.next;
                stepSize--;
            }
        }else{
            // 如果是 B 长，则需要移动 stepSize 步
            while(stepSize < 0){
                preB = preB.next;
                stepSize++;
            }
        }

        // 此时 A、B 两个链表 在同一位置，开始同步前进，如果遇到 A 节点 相等 B 节点，则此节点为相交节点，返回即可
        while(preA != null){
            if(preA.equals(preB)){
                return preA;
            }
            preA = preA.next;
            preB = preB.next;
        }

        // 没有找到返回 null
        return null;
    }

    /**
     * 双指针
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 如果 a size == b size ，则两个指针会同时到达两个链表相交的节点，此时返回相交的节点；
        // 如果 a size != b size  在指针 pA 移动了 a + c + b 次、指针 移动了 b + c + a 次之后，两个指针会同时到达两个链表相交的节点，该节点也是两个指针第一次同时指向的节点，此时返回相交的节点。
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}