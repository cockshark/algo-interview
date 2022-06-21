//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [], val = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [7,7,7,7], val = 7
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 列表中的节点数目在范围 [0, 10⁴] 内 
// 1 <= Node.val <= 50 
// 0 <= val <= 50 
// 
// Related Topics 递归 链表 👍 933 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
    public ListNode removeElements(ListNode head, int val) {
        /*
        新建一个node1.next存head的头节点，免得到时候head被删除了找不到链表
        遍历链表的元素，如果next为空就退出
        如果next非空并等于val值，就通过temp.next = temp.next.next来删除这个值
        如果next非空也不等于val值，就直接正常遍历 temp = temp.next
         */
        ListNode node1 = new ListNode();
        node1.next = head;
        ListNode temp = node1;
        while (temp.next != null){
            if (temp.next.val == val) temp.next = temp.next.next;
            else temp = temp.next;
        }
        return node1.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
