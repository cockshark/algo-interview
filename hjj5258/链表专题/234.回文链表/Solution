package aigo.com.yz;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     * 解法1：正向解法
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        // 1. 前后对称 那么它就是回文
        // 2. 需要找到中间节点，快慢指针获取
        // 3. 反转后半部分链表
        // 4. 对比是否一致
        ListNode midNode = getMidNode(head);
        // 5. 后半部分的链表
        ListNode s = midNode.next;
        // 6. 反转
        ListNode reverseSStart = reverse(midNode.next);

        while (reverseSStart != null) {
            if (head.val != reverseSStart.val) {
                return false;
            }
            reverseSStart = reverseSStart.next;
            head = head.next;
        }

        return true;
    }

    public ListNode getMidNode(ListNode head) {
        ListNode fast = head;
        ListNode solw = head;
        while (fast.next != null && fast.next.next != null) {
            solw = solw.next;
            fast = fast.next.next;
        }
        return solw;
    }

    public ListNode reverse(ListNode head) {
        // 1. 申明前驱节点
        ListNode prevNode = null;
        ListNode curNode = head;

        while (curNode != null) {
            // 2. 保存后续链表节点
            ListNode tempNode = curNode.next;
            // 3. 反向指向，指向后驱改为前驱
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = tempNode;
        }

        return prevNode;
    }


    /**
     * 解法2：递归
     */
    ListNode left = null;
    public boolean isPalindrome(ListNode head) {
        left = head;
        return dfs(head);
    }

    public boolean dfs(ListNode right) {
        if (right == null) return true;
        boolean result = dfs(right.next);
        if (left.val != right.val) return false;
        left = left.next;
        return result;
    }
}
