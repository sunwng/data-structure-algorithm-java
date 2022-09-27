import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//class Node {
//    Integer value;
//    Node leftNode;
//    Node rightNode;
//    Node(int valueIn) {
//        value = valueIn;
//        leftNode = null;
//        rightNode = null;
//    }
//    Node() {
//        value = null;
//        leftNode = null;
//        rightNode = null;
//    }
//}

public class Main {
    static int c = 0;

    public static void getC() {
        System.out.println(c);
//        c = 0;
    }

//    public static Node insert(Integer newValue) {
//        return new Node(newValue);
//    }
    public static Node insert(Integer newValue, Node rootNode) {
        if (rootNode.value == null) {
            return new Node(newValue);
        }
        c++;
//        System.out.println(c);
        if (newValue < rootNode.value) {
            if (rootNode.leftNode == null) {
                rootNode.leftNode = new Node(newValue);
            } else {
                insert(newValue, rootNode.leftNode);
            }
        } else {
            if (rootNode.rightNode == null) {
                rootNode.rightNode = new Node(newValue);
            } else {
                insert(newValue, rootNode.rightNode);
            }
        }
        return rootNode;
    }

    public static void main(String[] args) throws IOException {
//        Node rootNode = new Node();
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int len = Integer.parseInt(br.readLine());
////        Integer[] totalIn = new Integer[len];
//        for (int i = 0; i < len; i++) {
////            totalIn[i] = Integer.parseInt(br.readLine());
//            rootNode = insert(Integer.parseInt(br.readLine()), rootNode);
//            getC();
//        }
        int[] test = {1, 2, 3};

    }
}