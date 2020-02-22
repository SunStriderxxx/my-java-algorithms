package sort;

import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * @author Fcb
 * @date 2019/3/10
 * @description 冒泡排序，时间复杂度O(n^2)，空间复杂度O(1)
 */
@Builder
@NoArgsConstructor
public class BubbleSort implements Sort {

    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
