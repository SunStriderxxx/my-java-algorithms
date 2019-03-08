import org.junit.Test;
import sort.QuickSort;

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

    @Test
    public void quickSortTest(){
        int[] arr = new int[100];
        Random random = new Random();
        for (int i = 0; i < 100; i++){
            arr[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(arr));
        QuickSort sort = new QuickSort();
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
