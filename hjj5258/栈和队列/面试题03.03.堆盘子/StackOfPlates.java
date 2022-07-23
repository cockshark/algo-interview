package aigo.com.yz;

class StackOfPlates {
    /** 思路：动态数组的栈 */
    private List<Stack<Integer>> stackList;
    private int cap;

    public StackOfPlates(int cap) {
        stackList = new ArrayList<>();
        this.cap = cap;
    }

    public void push(int val) {
        if (cap <= 0) {
            return;
        }

        // 如果为空或者，达到容量，另起一个（另外开始叠盘子）
        if (stackList.isEmpty() || stackList.get(stackList.size() - 1).size() == cap) {
            Stack<Integer> stack = new Stack<>();
            stack.push(val);
            stackList.add(stack);
            return;
        }
        // 否则，在之前的基础上叠盘子，取最后一个 stack 进行叠
        stackList.get(stackList.size() - 1).push(val);
    }

    public int pop() {
        // 从最后开始 弹出
        return popAt(stackList.size() - 1);
    }

    public int popAt(int index) {
        if (index < 0 || index >= stackList.size()) {
            return -1;
        }

        Stack<Integer> stack = stackList.get(index);
        if (stack.isEmpty()) {
            return -1;
        }

        int res = stack.pop();

        // 维护
        if (stack.isEmpty()) {
            stackList.remove(index);
        }

        return res;
    }
}
