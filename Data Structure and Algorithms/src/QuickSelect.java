import java.util.*;

public class QuickSelect {
    int[] array;

    public QuickSelect(int[] array_in) {
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


    int quickSelect(int nthNum, int leftIndex, int rightIndex) {
        if ((rightIndex - leftIndex) <= 0) {
            return -1;
        }
        int pivotIndex = this.getLeft(leftIndex, rightIndex);
        if (nthNum < pivotIndex) {
            return quickSelect(nthNum, leftIndex, pivotIndex - 1);
        } else if (nthNum > pivotIndex) {
            return quickSelect(nthNum, pivotIndex + 1, rightIndex);
        } else {
            return array[pivotIndex];
        }
    }

    static public void main(String[] args) {
        int[] test = {0, 5, 2, 1, 6, 3, 11, 4, 9, 18, 29, 22, 14, 7};
        QuickSelect solution = new QuickSelect(test);
        int result = solution.quickSelect(7, 0, test.length-1);
        System.out.println(result);

    }
}
