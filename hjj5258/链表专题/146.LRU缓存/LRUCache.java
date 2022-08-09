class LRUCache {
    /**
     * TODO 分析
     */
    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;

    class Node {
        private Node prev;
        private Node next;
        private int key;
        private int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, Node>();
        this.head = this.tail = new Node(-2, -2);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        moveToTail(node);
        return node.val;
    }

    /**
     * 移动到末尾
     * @param node
     */
    public void moveToTail(Node node) {
        // 当前 node 前后 指向，断开与 node 的链接
        //  node 前一节点的 next 指向 node 的后一个节点
        //  node 后一个节点的 prev 指向 node 的前一个节点
        node.prev.next = node.next;
        node.next.prev = node.prev;
        // 断开 node 的 与前一节点的 prev 与 后一节点的 next，并且成为最后一个节点
        // node prev（前驱） 指向 虚拟尾节点的前一个节点
        // node next(后驱)  指向 虚拟尾节点，成为最后一个节点！
        node.prev = tail.prev;
        node.next = tail;

        // 此时 tail 还是 连接的 原来最后一个节点（不是当前的 node ！）
        // 原来最后一个节点要断开 与 tail 的 链接
        // 把 原来最后一个节点 指向 当前的 node，建立与 node 的 next 链接
        // tail的 prev（前驱）就应该为 node
        // 此时 node 建立完整的 链接关系 即是 node.prev = 原来的最后一个节点,node.next = tail
        //  tail.prev = node（当前最后一个节点）

        // 所以分为 3步，
        // 首先 1. 断开 前后的 next 和 prev 指向
        // 首先 2. 建立 node 指向 tail 的链接关系
        // 首先 3. 建立 tail 指向 node 的链接关系
        tail.prev.next = node;
        tail.prev = node;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.val = value;
            // 移动到末尾保持最新，建立与旧尾节点建立关系
            moveToTail(node);
        } else {
            node = new Node(key, value);

            map.put(node.key, node);
            // 维护最后一个节点 与 当前插入节点的关系
            // 当前的节点[现在的最后一个节点（插入尾后）] 指向 [旧的] 节点
            node.prev = tail.prev;
            node.next = tail;
            // 旧的最后一个节点的next 指向 当前插入的 node
            tail.prev.next = node;
            tail.prev = node;
            if (map.size() > capacity) {
                map.remove(head.next.key);
                head.next = head.next.next;
                head.next.prev = head;
            }
        }

    }
}