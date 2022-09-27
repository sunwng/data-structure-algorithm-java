import java.util.*;

public class InsertionSort {
    int[] insertSort(int[] int_array) {
        for (int i = 1; i < int_array.length; i++) {
            int temp_num = int_array[i];
            int position = i - 1;
            while (position >= 0) {
                if (int_array[position] > temp_num) {
                    int_array[position+1] = int_array[position];
                    int_array[position] = temp_num;
                    position -= 1;
                } else {
                    break;
                }
            }
        }
        return int_array;
    }
    public static void main(String[] args) {
        InsertionSort sorter = new InsertionSort();
        int[] test = {1, 5, 12, 19, 63, 22, 3, 35};
        int[] result = sorter.insertSort(test);
        System.out.println(Arrays.toString(result));
    }
}
