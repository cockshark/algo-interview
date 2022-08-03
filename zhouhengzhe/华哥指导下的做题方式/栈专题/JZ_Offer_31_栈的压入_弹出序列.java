package zhouhengzhe.华哥指导下的做题方式.栈专题;

public class JZ_Offer_31_栈的压入_弹出序列 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s=new Stack<>();
        int i=0;
        for (int item : pushed) {
            s.push(item);
            while (!s.isEmpty()&&s.peek()==popped[i]){
                s.pop();
                i++;
            }
        }
        return s.isEmpty();
    }
}
