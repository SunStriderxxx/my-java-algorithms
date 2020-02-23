package sort;

import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * @author Fcb
 * @date 2019/3/11
 * @description 选择排序，时间复杂度O(n^2)，空间复杂度O(1)，不稳定
 */
@Builder
@NoArgsConstructor
public class SelectionSort implements Sort {
    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
    }
}
