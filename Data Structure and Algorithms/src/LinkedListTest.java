import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> test = new LinkedList<>();
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
        System.out.println(test.size());
        test.removeFirst();
        System.out.println(test);
        test.removeLast();
        System.out.println(test);
    }
}
