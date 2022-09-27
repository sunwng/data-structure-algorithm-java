import java.util.*;

public class BubbleSort {
    int[] bubbleSort(int[] int_array) {
        int checkIndex = int_array.length;
        boolean sortCheck = false;
        while (!sortCheck) {
            sortCheck = true;
            for (int i = 0; i < (checkIndex - 1); i++){
                int num_1 = int_array[i];
                int num_2 = int_array[i+1];
                if (num_1 > num_2) {
                    int_array[i] = num_2;
                    int_array[i+1] = num_1;
                    sortCheck = false;
                }
            }
            checkIndex -= 1;
        }
        return int_array;
    }
    public static void main(String[] args) {
        int[] test = {65, 55, 45, 35, 25, 15, 10};
        BubbleSort sorter = new BubbleSort();
        int[] test_res = sorter.bubbleSort(test);
        System.out.println(Arrays.toString(test_res));
    }
}