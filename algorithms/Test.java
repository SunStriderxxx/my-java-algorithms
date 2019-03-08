import sort.QuickSort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: Fcb
 * @Date: 2019/3/8
 * @Description: 测试类
 */
public class Test {

    public static void main(String[] args) {
        int[] arr = new int[30];
        Random random = new Random();
        for (int i = 0; i < 10; i++){
            arr[i] = random.nextInt(30);
        }
        System.out.println(Arrays.toString(arr));
        QuickSort sort = new QuickSort();
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
