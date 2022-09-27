import java.util.ArrayList;

public class Heap {

    ArrayList<Integer> content = new ArrayList<>();

    public void insert(int valueIn) {
        content.add(valueIn);
        upTrickling(valueIn);
    }

    public void delete() {
        content.set(0, content.get(content.size() - 1));
        content.remove(content.size() - 1);
        downTrickling(content.get(0));
    }

    public void upTrickling(int valueIn) {
        int currentIndex = content.indexOf(valueIn);
        int parentIndex = (int) (currentIndex - 1) / 2;
        if (parentIndex >= 0) {
            int parentValue = content.get(parentIndex);
            if (valueIn > parentValue) {
                content.set(currentIndex, parentValue);
                content.set(parentIndex, valueIn);
                upTrickling(parentValue);
            } else {
                return;
            }
        } else {
            return;
        }
    }

    public void downTrickling(int valueIn) {
        int currentIndex = content.indexOf(valueIn);
        System.out.println(valueIn);
        System.out.println(currentIndex);
        int indexOut = indexCheck(currentIndex);
        if (indexOut == -1) {
            return;
        } else {
            if (valueIn < content.get(indexOut)) {
                content.set(currentIndex, content.get(indexOut));
                content.set(indexOut, valueIn);
                downTrickling(content.get(currentIndex));
            } else {
                return;
            }
        }
    }

    public int indexCheck(int indexIn) {
        if (content.size() >= indexIn * 2 + 3) {
            if (content.get(indexIn * 2 + 2) > content.get(indexIn * 2 + 1)) {
                return indexIn * 2 + 2;
            } else {
                return indexIn * 2 + 1;
            }
        } else if (content.size() >= indexIn * 2 + 2) {
            return indexIn * 2 + 1;
        } else {
            return -1;
        }
    }

    public void printList() {
        System.out.println(content);
    }

    public static void main(String[] args) {
        Heap test = new Heap();
        test.insert(1);
        test.printList();
        test.insert(17);
        test.insert(83);
        test.insert(32);
        test.printList();
        test.delete();
        test.printList();
    }
}
