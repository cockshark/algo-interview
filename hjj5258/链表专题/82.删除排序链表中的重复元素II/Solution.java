package aigo.com.yz;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        // 相邻两个不同的
        if(head.val != head.next.val){
            head.next = deleteDuplicates(head.next);
        }

        else{
            // 相同处理 去除当前的，并移动下一位
            ListNode tempNode = head.next;
            while( tempNode != null  && head.val  == tempNode.val){
                tempNode = tempNode.next;
            }

            // 继续递归处理
            return  deleteDuplicates(tempNode);
        }
        return head;
    }
}