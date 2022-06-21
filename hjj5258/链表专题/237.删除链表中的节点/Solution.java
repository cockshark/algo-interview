package aigo.com.yz;

class Solution {

    /**
     * 限制了头结点的获取，思路：删除不一定要获取头结点，可以换位思考
     * 利用下一位值替换当前位置，也可达到删除效果
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}