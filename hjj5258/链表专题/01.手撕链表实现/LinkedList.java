package aigo.com.yz;

public class LinkedList<E> {
    private class Node {
        private Node next;
        private E e;

        public Node(Node next, E e) {
            this.next = next;
            this.e = e;
        }

        public Node(E e) {
            new Node(null, e);
        }
    }

    private Node headNode;
    private Node tailNode;
    private int size;

    public LinkedList() {
        headNode = null;
        tailNode = headNode;
    }

    /**
     * 在 target Node节点之前插入新节点
     *
     * @param target
     * @param e
     */
    public void addPreNode(E target, E e) {
        Node curNode = headNode;
        if (size == 1) {
            addFirst(e);
        } else {
            while (!target.equals(curNode.next.e)) {
                curNode = curNode.next;
            }
            Node eNode = new Node(null, e);
            eNode.next = curNode.next;
            curNode.next = eNode;
            size++;
        }
    }

    public void addAfterNode(E target, E e) {
        Node curNode = headNode;
        if (size == 1) {
            addLast(e);
        } else {
            while (!target.equals(curNode.e)) {
                curNode = curNode.next;
            }
            Node eNode = new Node(null, e);
            eNode.next = curNode.next;
            curNode.next = eNode;
            size++;
        }
    }

    public void addFirst(E e) {
        Node curNode = new Node(null, e);
        if (headNode == null) {
            headNode = curNode;
            tailNode = curNode;
        } else {
            curNode.next = headNode;
            headNode = curNode;
        }
        size++;
    }

    public void addLast(E e) {
        Node curNode = new Node(null, e);
        if (headNode == null) {
            headNode = curNode;
            tailNode = curNode;
        } else {
            tailNode.next = curNode;
            tailNode = curNode;
        }
        size++;
    }

    public void remove(E target) {
        Node curNode = headNode;
        if (size == 0) {
            return;
        }
        if (target.equals(headNode.e)) {
            headNode = headNode.next;
            size--;
        } else {
            Node tempNode = curNode;
            while (curNode != null && !target.equals(curNode.e)) {
                tempNode = curNode;
                curNode = curNode.next;
            }
            if (curNode != null) {
                if (curNode == tailNode) {
                    tailNode = tempNode;
                }
                Node delNode = tempNode.next;
                tempNode.next = curNode.next;
                // do gc
                delNode.next = null;
                size--;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node curNode = headNode;
        stringBuilder.append("HEADNODE---->");
        while (curNode != null) {
            stringBuilder.append(curNode.e + "----->");
            curNode = curNode.next;
        }
        stringBuilder.append("TAILNODE");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.addLast(1);
        linkedList.addLast(2);

        linkedList.remove(2);

//        linkedList.addLast(2);
//        linkedList.addLast(3);
        System.out.println(linkedList);
//        System.out.println(linkedList.tailNode);

    }

}