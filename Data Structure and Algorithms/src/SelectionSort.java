import java.util.*;

public class SelectionSort {
    int[] selectionSort(int[] int_array) {
        for (int i = 0; i < int_array.length; i++) {
            int lowestIndex = i;
            for (int j=i+1; j < int_array.length; j++) {
                if (int_array[j] < int_array[lowestIndex]) {
                    lowestIndex = j;
                }
            }
            int temp = int_array[i];
            int_array[i] = int_array[lowestIndex];
            int_array[lowestIndex] = temp;
        }
        return int_array;
    }

    public static void main(String[] args) {
        SelectionSort sorter = new SelectionSort();
        int[] test = {5, 1, 12, 19, 63, 22, 3, 35};
        int[] result = sorter.selectionSort(test);
        System.out.println(Arrays.toString(result));
    }
}
