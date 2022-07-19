package com.zhz.hua.week2;

public class JZ_Offer_06_从尾到头打印链表 {
     /**
     * 集合存储，再反转
     *
     * @param head
     * @return
     */
    public static int[] reversePrint(ListNode head) {
        List<Integer> res = new ArrayList<>();
        if (head == null) {
            return new int[0];
        }
        ListNode cur = head;
        while (cur != null) {
            res.add(cur.val);
            cur = cur.next;
        }
        Collections.reverse(res);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 栈存储打印
     *
     * @param head
     * @return
     */
    public static int[] reversePrint1(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();
        ListNode cur=head;
        while (cur!=null){
            stack.push(cur.val);
            cur=cur.next;
        }
        int size = stack.size();
        int[] res=new int[size];
        for (int i = 0; i < size; i++) {
            res[i]=stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        //[1,2,6,3,4,5,6]
//        ListNode node1 = new ListNode(2);
//        ListNode node2 = new ListNode(4);
//        ListNode node3 = new ListNode(9);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = null;
//
//        ListNode l1 = new ListNode(5);
//        ListNode l2 = new ListNode(6);
//        ListNode l3 = new ListNode(4);
//        ListNode l4 = new ListNode(9);
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next=null;
        //342+465
//        ListNode node1 = new ListNode(3);
//        ListNode node2 = new ListNode(4);
//        ListNode node3 = new ListNode(2);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = null;
//
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(6);
        ListNode l3 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = null;
        for (int i : JZ_Offer_06_从尾到头打印链表.reversePrint1(l1)) {
            System.out.println(i);
        }
    }
}
