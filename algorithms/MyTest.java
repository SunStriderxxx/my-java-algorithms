import org.junit.Test;
import problems.NetherlandsFlag;
import problems.SmallSum;
import sort.*;

import java.util.Arrays;

/**
 * @Author: Fcb
 * @Date: 2019/3/8
 * @Description: 测试类
 */
public class MyTest {

    public static void main(String[] args) {
        String s = "aa";
        String substring = s.substring(1);
        System.out.println(substring);
    }

    // for test
    public int[] generateRandomArray(int size, int value) {
        //Math.random() -> double [0,1)
        //(int) ((size + 1) * Math.random()) -> [0,size] 整数，等概率
        //size = 6, size + 1 = 7;
        //Math.random() -> [0,1) * 7 -> [0,7) double
        //double -> int [0,6] -> int

        //生成长度随机的数组
        int[] arr = new int[(int) ((size + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((value + 1) * Math.random()) - (int) (value * Math.random());
        }
        return arr;
    }

    // for test
    public void rightMethod(int[] arr) {
        Arrays.sort(arr);
    }

    public int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public boolean isEquals(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static final int TEST_TIMES = 10000;
    private static final int SIZE = 20;
    private static final int VALUE = 100;

    @Test
    public void quickSortTest() {
        boolean succeed = true;
        Sort sort = new QuickSort();
        for (int i = 0; i < TEST_TIMES; i++) {
            int[] arr1 = generateRandomArray(SIZE, VALUE);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            sort.sort(arr1);
            rightMethod(arr2);
            if (!isEquals(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                printArray(arr3);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    @Test
    public void bubbleSortTest() {
        boolean succeed = true;
        Sort sort = new BubbleSort();
        for (int i = 0; i < TEST_TIMES; i++) {
            int[] arr1 = generateRandomArray(SIZE, VALUE);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            sort.sort(arr1);
            rightMethod(arr2);
            if (!isEquals(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                printArray(arr3);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    @Test
    public void selectionSortTest() {
        boolean succeed = true;
        Sort sort = new SelectionSort();
        for (int i = 0; i < TEST_TIMES; i++) {
            int[] arr1 = generateRandomArray(SIZE, VALUE);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            sort.sort(arr1);
            rightMethod(arr2);
            if (!isEquals(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                printArray(arr3);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    @Test
    public void insertionSortTest() {
        boolean succeed = true;
        Sort sort = new InsertionSort();
        for (int i = 0; i < TEST_TIMES; i++) {
            int[] arr1 = generateRandomArray(SIZE, VALUE);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            sort.sort(arr1);
            rightMethod(arr2);
            if (!isEquals(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                printArray(arr3);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    @Test
    public void mergeSortTest() {
        boolean succeed = true;
        Sort sort = new MergeSort();
        for (int i = 0; i < TEST_TIMES; i++) {
            int[] arr1 = generateRandomArray(SIZE, VALUE);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            sort.sort(arr1);
            rightMethod(arr2);
            if (!isEquals(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                printArray(arr3);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    @Test
    public void getSmallSumTest() {
        boolean succeed = true;
        SmallSum smallSum = new SmallSum();
        for (int i = 0; i < TEST_TIMES; i++) {
            int[] arr1 = generateRandomArray(SIZE, VALUE);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            smallSum.getSmallSum(arr1);
            rightMethod(arr2);
            if (!isEquals(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                printArray(arr3);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    @Test
    public void netherlandsFlagTest(){
        int[] arr = new int[]{3,2,5,4,1,6,1,2};
        NetherlandsFlag netherlandsFlag = new NetherlandsFlag();
        int[] partition = netherlandsFlag.partition(arr, 0, arr.length - 1, 1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(partition));
    }

    @Test
    public void heapSortTest() {
        boolean succeed = true;
        Sort sort = new HeapSort();
        for (int i = 0; i < TEST_TIMES; i++) {
            int[] arr1 = generateRandomArray(SIZE, VALUE);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            sort.sort(arr1);
            rightMethod(arr2);
            if (!isEquals(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                printArray(arr3);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
