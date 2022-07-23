package aigo.com.yz;

class Solution {
    /**
     * 思路：符号匹配，先进后出，自然想到的是栈来实现，我们只需要遍历字符串，当遇到 左括号就忽略并入栈，
     * 直到遇到右边括号为止，符合条件的 自然是 (({})) 当左括号结束时候，栈顶一定是最小最内的左括号
     * 所以会一直简化 最小最内 符号匹配，匹配一个 pop 一个，直到 stack size 为 0，说明完全匹配
     */
    public boolean isValid(String s) {
        // 奇数一定不是匹配的
        int n = s.length();
        if (n % 2 == 1) return false;

        // 构造一个 map，便于判断操作
        Map<Character, Character> map = new HashMap<>() {{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};
        // 声明栈 保存 左括号
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            // 包含说明是 右括号
            if (map.containsKey(ch)) {
                // 如果还没判断完所有 左括号，栈就为空 那么一定不是，或者 右括号，与栈顶不同，说明 最内最小的符号不匹配
                if (stack.isEmpty() || map.get(ch) != stack.peek()) {
                    return false;
                }
                // 满足条件 弹出删除该次匹配，相当于简化符号
                stack.pop();
            } else { // 左括号，直接入栈
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }
}