/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    HashMap<Integer,Integer> hashMap = new HashMap();
    public ListNode deleteDuplicates(ListNode head){
        ListNode cur = head;
        if (cur == null || cur.next == null) return head;
        while (cur != null){
            hashMap.put(cur.val,hashMap.getOrDefault(cur.val,0)+1);
            cur = cur.next;
        }
        return delnode(head);
    }
    public ListNode delnode(ListNode node){
        if (node == null ) return null;
        if (hashMap.get(node.val)>1){
            return delnode(node.next);
        }else {
             node.next = delnode(node.next);
             return node;
        }
    }
}