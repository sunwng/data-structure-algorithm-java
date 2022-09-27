import java.util.*;

public class QuickSort {
    int[] array;
    public QuickSort(int[] array_in) {
        array = array_in;
    }

    int getLeft(int leftIndex, int rightIndex) {
        int pivotIndex = rightIndex;
        int pivotNum = array[pivotIndex];
        rightIndex -= 1;

        while (true) {
            while (array[leftIndex] < pivotNum) {
                leftIndex += 1;
            }
            while (array[rightIndex] > pivotNum) {
                rightIndex -= 1;
            }
            if (leftIndex >= rightIndex) {
                break;
            } else {
                int temp = array[leftIndex];
                array[leftIndex] = array[rightIndex];
                array[rightIndex] = temp;
            }
        }
        array[pivotIndex] = array[leftIndex];
        array[leftIndex] = pivotNum;

        return leftIndex;
    }

    void sorter(int leftIndex, int rightIndex) {
        if ((rightIndex - leftIndex) <= 0) {
            return;
        } else {
            int pivotIndex = this.getLeft(leftIndex, rightIndex);
            sorter(leftIndex, pivotIndex - 1);
            sorter(pivotIndex + 1, rightIndex);
        }
    }

    static public void main(String[] args) {
        int[] test = {0, 5, 2, 1, 6, 3, 11, 4, 9, 18, 29, 22, 14, 7};
        QuickSort solution = new QuickSort(test);
        solution.sorter(0, test.length-1);
        System.out.println(Arrays.toString(solution.array));
    }
}
