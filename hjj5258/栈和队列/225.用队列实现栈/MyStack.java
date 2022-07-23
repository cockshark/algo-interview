package aigo.com.yz;

/**
 * 分析： 队列先进先出，想要用队列实现 先进后出，那么两个队列就要分开
 *       queue2 进行 添加元素，并且把 queue1 的元素添加到 queue2 中
 *       然后交换 queue1 与 queue2 的指向， queue1 指向 原有 queue2， queue2 指向原有 queue1
 *       这样下次，在进行添加元素时候，当前 queue2 添加元素，原有 queue2 在转移进 当前 queue2
 *       在进行 指向交换，queue1 就拥有了所有元素，在进行出栈操作时候 这时候元素已经 是栈形式了
 *       简单说就是，每进行一次 push 操作 就先入 q2，q2 此时一定是空，q1（存储原来的元素），把 q1（原来元素）转移到 q2，此时就完成了先入后出
 *       所以 q2 来负责 push 操作，push 完后 指向 q1，那么 q1 就该负责 查看、弹出、是否为空
 * /
class MyStack {
    Queue<Integer> queue1,queue2;
    public MyStack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    public void push(int x) {
        queue2.add(x);
        while(!queue1.isEmpty()){
            queue2.add(queue1.poll());
        }
        Queue<Integer> tmep = queue1;
        queue1 = queue2;
        queue2 = tmep;
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
