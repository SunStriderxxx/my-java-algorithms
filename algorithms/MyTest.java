import org.junit.Test;
import sort.*;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: Fcb
 * @Date: 2019/3/8
 * @Description: 测试类
 */
public class MyTest {

    public static void main(String[] args) {

    }

    private int[] makeArr(){
        int[] arr = new int[20];
        Random random = new Random();
        for (int i = 0; i < 20; i++){
            arr[i] = random.nextInt(20);
        }
        return arr;
    }

    @Test
    public void quickSortTest(){
        int[] arr = makeArr();
        System.out.println(Arrays.toString(arr));
        Sort sort = new QuickSort();
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void bubbleSortTest(){
        int[] arr = makeArr();
        System.out.println(Arrays.toString(arr));
        Sort sort = new BubbleSort();
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void selectionSortTest(){
        int[] arr = makeArr();
        System.out.println(Arrays.toString(arr));
        Sort sort = new SelectionSort();
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void insertionSortTest(){
        int[] arr = makeArr();
        System.out.println(Arrays.toString(arr));
        Sort sort = new InsertionSort();
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
