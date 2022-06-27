package aigo.com.yz;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        head = reverse(head);
        int[] retArr =  new int[length(head)];
        for(int i = 0;i<retArr.length;i++){
            retArr[i] = head.val;
            head = head.next;
        }

        return retArr;
    }

    public int length(ListNode head){
        ListNode curNode = head;
        int size = 0;
        while(curNode != null){
            curNode = curNode.next;
            size++;
        }
        return size;
    }

    public ListNode reverse(ListNode head){
        ListNode prevNode = null;
        ListNode curNode = head;
        while(curNode != null){
            ListNode tempNode = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = tempNode;
        }
        return prevNode;
    }

    /*===================== 解法二：空间换时间 （栈）先进后出==================*/
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }
}