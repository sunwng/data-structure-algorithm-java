import java.lang.reflect.Array;
import java.util.*;

public class ArrayStack {
    int top = -1;
    ArrayList<Integer> data = new ArrayList<>();

    public void push(int int_in) {
        data.add(int_in);
        this.top += 1;
    }
    public void pop() {
        data.remove(this.top);
        this.top -= 1;
    }
    public int peek() {
        return data.get(this.top);
    }

    public static void main(String[] args) {
        ArrayStack test = new ArrayStack();
        for (int i = 0; i < 5; i++) {
            test.push(i);
            System.out.println(test.peek());
        }
    }
}
