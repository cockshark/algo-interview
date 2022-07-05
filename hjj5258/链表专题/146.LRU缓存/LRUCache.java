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
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
        return node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.val = value;
            // 移动到末尾保持最新，建立与旧尾节点建立关系
            node.prev.next = node.next;
            node.next.prev = node.prev;


            // 与虚拟尾节点建立关系
            // 维护最后一个节点 与 当前插入节点的关系
            // 当前的节点[现在的最后一个节点（插入尾后）] 指向 [旧的] 节点
            node.prev = tail.prev;
            // 旧的最后一个节点的next 指向 当前插入的 node
            tail.prev.next = node;
            node.next = tail;
            tail.prev = node;
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