
public class MyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        size = 0;
    }

    class Node {
        private Node nextNode;
        private Node prevNode;
        private Object data;

        Node (Object data) {
            this.data = data;
            this.nextNode = null;
            this.prevNode = null;
        }
    }

    public Node getNode(int index) {
        Node node;
        if (index < size/2) {
            node = head;
            for (int i = 0; i < index; i++) {
                node = node.nextNode;
            }
        } else {
            node = tail;
            for (int i = size-1; i > index; i--) {
                node = node.prevNode;
            }
        }
        return node;
    }

    public void addFirst(Object data) {
        Node newNode = new Node(data);

        if (head != null) {
            newNode.nextNode = head;
            head.prevNode = newNode;
        }
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        size++;
    }

    public void addLast(Object data) {
        if (size == 0) {
            addFirst(data);
        } else {
            Node newNode = new Node(data);
            newNode.prevNode = tail;
            tail.nextNode = newNode;
            size++;
        }
    }

    public void add(int index, Object data) {
        if (index == 0) {
            addFirst(data);
        } else if (index == size-1) {
            addLast(data);
        } else {
            Node newNode = new Node(data);
            Node oldNode = getNode(index);
            oldNode.prevNode.nextNode = newNode;
            newNode.prevNode = oldNode.prevNode;
            newNode.nextNode = oldNode;
            oldNode.prevNode = newNode;
            size++;
        }
    }

    public void add(Object data) {
        addLast(data);
    }

    public Object removeFirst() {
        if (size == 0) {
            return null;
        } else {
            Node removeNode = head;
            head = removeNode.nextNode;
            head.prevNode = null;
            size--;
            return removeNode.data;
        }
    }

    public Object removeLast() {
        if (size == 0) {
            return null;
        } else {
            Node removeNode = tail;
            tail = removeNode.prevNode;
            tail.nextNode = null;
            size--;
            return removeNode.data;
        }
    }

    public Object remove(int index) {
        if (size == 0) {
            return null;
        }
        if (index == 0) {
            return removeFirst();
        } else if (index == size-1) {
            return removeLast();
        } else {
            Node removeNode = getNode(index);
            removeNode.prevNode.nextNode = removeNode.nextNode;
            removeNode.nextNode.prevNode = removeNode.prevNode;
            size--;
            return removeNode.data;
        }
    }

    public static void main(String[] args) {
        MyLinkedList test = new MyLinkedList();
        test.addFirst(3);
        System.out.println(test);
        test.addLast(81);
        System.out.println(test);
        test.add(10);
        System.out.println(test);
        test.add(6);
        System.out.println(test);
        test.add(2, 70);
        System.out.println(test);
        test.removeFirst();
        System.out.println(test);
        test.removeLast();
        System.out.println(test);
    }
}
