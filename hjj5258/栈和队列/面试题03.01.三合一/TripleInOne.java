package aigo.com.yz;

class TripleInOne {
    /**
     * 题目的意思是，怎么用数组去表示三个栈，那么我们首先想到的是，分段 0-3 stack1（代表栈 1） 4-7代表stack 2.....
     * 最后我们思考，如何解决 pop 与 peek 支持栈顶，我们需要保存 栈顶指针，我们可以构造一个 top[] 分别保存三个栈分段起始位置的栈顶指针（对应下标）
     */
    int N = 3;
    int[] data;
    int[] top;
    int size;
    public TripleInOne(int stackSize) {
        size = stackSize;
        data = new int[size * N];
        top = new int[N];
        // 假设 stackSize = 3，
        // 即是top[0] = 0 代表（0-2）为 stacknum 1
        // 即是top[1] = 3 代表（3-5）为 stacknum 2
        // 即是top[2] = 6 代表（6-8）为 stacknum 3
        for (int i = 0; i < N; i++) {
            top[i] = i * size;
        }
    }

    public void push(int stackNum, int value) {
        // 取出下标，用假设值 stackNum = 0 带入
        int idx = top[stackNum];
        // 对应下标，(stackNum + 1) * size 代表当前栈最大元素个数，如果当前栈下标起始 已经满了，就不在push
        if (idx < (stackNum + 1) * size) {
            data[idx] = value;
            // 当前栈元素个数 + 1，0 变为 1 代表 stackNum 1 有一个元素 push 了
            top[stackNum]++;
        }
    }

    public int pop(int stackNum) {
        // 取出下标，用假设值 stackNum = 0 带入
        int idx = top[stackNum];
        // 如果当前 栈起始下标元素 比 栈初始值下标元素大，则代表有元素
        if (idx > stackNum * size) {
            // 当前栈元素个数 - 1
            top[stackNum]--;
            return data[idx - 1];
        } else {
            return -1;
        }
    }

    public int peek(int stackNum) {
        // 与 pop 逻辑无异，peek 只是查看栈顶，所以不用维护 top
        int idx = top[stackNum];
        if (idx > stackNum * size) {
            return data[idx - 1];
        } else {
            return -1;
        }
    }

    public boolean isEmpty(int stackNum) {
        // stackNum * size 就是等于 我们初始化 stackNum 的位置，如 stack 1 为 0，
        // 但如果我们 使用了 push,top[stackNum] 会进行 ++ 操作，此时与 stackNum * size（预初始值） 不同
        return top[stackNum] == stackNum * size;
    }
}