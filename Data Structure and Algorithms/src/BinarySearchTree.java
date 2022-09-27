class Node {
    Integer value;
    Node leftNode;
    Node rightNode;
    Node() {
        value = null;
        leftNode = null;
        rightNode = null;
    }
    Node(Integer valueIn) {
        value = valueIn;
        leftNode = null;
        rightNode = null;
    }
}

public class BinarySearchTree {
    public Node rootTree = new Node();

    public Boolean search(Integer valueIn, Node nodeIn) {
        if (nodeIn.value == null) {
            return null;
        } else if (valueIn.intValue() == nodeIn.value.intValue()) {
            return true;
        } else if (valueIn < nodeIn.value) {
            return search(valueIn, nodeIn.leftNode);
        } else if (valueIn > nodeIn.value) {
            return search(valueIn, nodeIn.rightNode);
        } else {
            return false;
        }
    }
    public Node insert(Integer valueIn, Node nodeIn) {
        if (nodeIn.value == null) {
            nodeIn.value = valueIn;
        } else {
            if (valueIn < nodeIn.value) {
                if (nodeIn.leftNode == null) {
                    nodeIn.leftNode = new Node();
                }
                nodeIn.leftNode = insert(valueIn, nodeIn.leftNode);
            } else {
                if (nodeIn.rightNode == null) {
                    nodeIn.rightNode = new Node();
                }
                nodeIn.rightNode = insert(valueIn, nodeIn.rightNode);
            }
        }
        rootTree = nodeIn;
        return nodeIn;
    }
    public Node delete(Integer valueIn, Node nodeIn) {
        if (valueIn < nodeIn.value) {
            nodeIn.leftNode = delete(valueIn, nodeIn.leftNode);
        } else if (valueIn > nodeIn.value) {
            nodeIn.rightNode = delete(valueIn, nodeIn.rightNode);
        } else {
            if ((nodeIn.leftNode == null) && (nodeIn.rightNode == null)) {
                nodeIn = null;
            } else if (nodeIn.leftNode != null) {
                return nodeIn.leftNode;
            } else if (nodeIn.rightNode != null) {
                return nodeIn.rightNode;
            } else {
                Node targetNode = findSuccessor(nodeIn);
                if (targetNode.rightNode == null) {
                    nodeIn.value = targetNode.value;
                } else {
                    nodeIn.value = targetNode.value;
                    targetNode.value = targetNode.rightNode.value;
                }
                return nodeIn;
            }
        }
        return nodeIn;
    }
    public Node findSuccessor(Node nodeIn) {
        if (nodeIn.leftNode == null) {
            return nodeIn;
        } else{
            return findSuccessor(nodeIn);
        }
    }

    public void traverse(Node nodeIn) {
        if (nodeIn == null) {
            return;
        }
        traverse(nodeIn.leftNode);
        System.out.println(nodeIn.value);
        traverse(nodeIn.rightNode);
    }

    public static void main(String[] args) {
        BinarySearchTree test = new BinarySearchTree();
        Node testNode = new Node();
        testNode = test.insert(5, testNode);
        testNode = test.insert(10, testNode);
        testNode = test.insert(9, testNode);
        testNode = test.insert(19, testNode);
        testNode = test.insert(91, testNode);
        testNode = test.insert(43, testNode);
        testNode = test.insert(28, testNode);
        testNode = test.insert(8, testNode);
        testNode = test.delete(91, testNode);
        test.traverse(testNode);
    }
}
