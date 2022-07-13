package zhouhengzhe.华哥指导下的做题方式.链表.done;

public class LC_234_回文链表_Medium {
    /**
     * 借助Java 数组实现回文
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> list=new ArrayList<>();
        if (head == null || head.next == null) {
            return true;
        }
        while (head!=null){
            list.add(head.val);
            head=head.next;
        }
        for (int i = 0; i < list.size()/2; i++) {
            if (!list.get(i).equals(list.get(list.size()-1-i))){
                return false;
            }
        }
        return true;
    }
}
