////堆盘子。设想有一堆盘子，堆太高可能会倒下来。因此，在现实生活中，盘子堆到一定高度时，我们就会另外堆一堆盘子。请实现数据结构SetOfStacks，模拟这
//种行
////为。SetOfStacks应该由多个栈组成，并且在前一个栈填满时新建一个栈。此外，SetOfStacks.push()和SetOfStacks.pop(
//)应该与
////普通栈的操作方法相同（也就是说，pop()返回的值，应该跟只有一个栈时的情况一样）。 进阶：实现一个popAt(int index)方法，根据指定的子栈
//，执行
////pop操作。 
////
//// 当某个栈为空时，应当删除该栈。当栈中没有元素或不存在该栈时，pop，popAt 应返回 -1. 
////
//// 示例1: 
////
//// 输入：
////["StackOfPlates", "push", "push", "popAt", "pop", "pop"]
////[[1], [1], [2], [1], [], []]
//// 输出：
////[null, null, null, 2, 1, -1]
//// 
////
//// 示例2: 
////
//// 输入：
////["StackOfPlates", "push", "push", "push", "popAt", "popAt", "popAt"]
////[[2], [1], [2], [3], [0], [0], [0]]
//// 输出：
////[null, null, null, null, 2, 1, 3]
//// 
//// Related Topics 栈 设计 链表 👍 47 👎 0
//


import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class StackOfPlates {
    /*
    采用栈中栈的意思
    push()就是简单的在最后一个栈添加数据，满了就建新栈。
    popAt()就是指定第几个栈出栈
    pop()可以复用popAt()，就是在最后一个栈取数据，空了就删栈。
     */
    private List<Stack<Integer>> stackList;
    private int cap;

    public StackOfPlates(int cap) {
        this.stackList = new LinkedList<>();
        this.cap = cap;
    }
    
    public void push(int val) {
        if (this.cap == 0) return;
        Stack<Integer> curStack = null;
        //如果栈为空，那么就直接新建一个栈，压进栈里面去
        //如果栈中的最后一个栈的长度满了的话，那就再新建一个栈压到栈里面去
        if (this.stackList.isEmpty() || (curStack = this.stackList.get(this.stackList.size() - 1)).size() >= this.cap) {
            curStack = new Stack<>()
            this.stackList.add(curStack);
        }
        curStack.push(val);
    }
    
    public int pop() {
        return popAt(this.stackList.size() - 1);
    }
    
    public int popAt(int index) {
        if (cap == 0 || index >= this.stackList.size() || index < 0) {
            return -1;
        }
        Stack<Integer> curStack = null;
        if ((curStack = this.stackList.get(index)).isEmpty()) {
            return -1;
        }
        int res = curStack.pop();
        if (curStack.isEmpty()) {
            this.stackList.remove(index);
        }
        return res;
    }
}

/**
 * Your StackOfPlates object will be instantiated and called as such:
 * StackOfPlates obj = new StackOfPlates(cap);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAt(index);
 */
//leetcode submit region end(Prohibit modification and deletion)
