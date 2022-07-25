package aigo.com.yz;

class Solution {
    /**
     * 思路： 用栈来保存，在push 之前 peek 看一下是不是与当前push 的一样，一样则移除栈顶，不进行push操作
     */
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char curCh = s.charAt(i);
            if(!stack.isEmpty()){
                char preCh = stack.peek();
                if (curCh == preCh) {
                    stack.pop();
                }else {
                    stack.push(curCh);
                }
            }else {
                stack.push(curCh);
            }
        }

        String result = "";
        while (!stack.isEmpty()) {
            // 左边加值操作，栈后面出来的是正序
            result = stack.pop() + result;
        }
        return result;
    }
}