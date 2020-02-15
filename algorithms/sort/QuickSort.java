package sort;

import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * @author Fcb
 * @date 2019/3/8
 * @description 自己靠感觉手写的快速排序
 */
@Builder
@NoArgsConstructor
public class QuickSort implements Sort {

    @Override
    public void sort(int[] arr) {
        part(arr, 0, arr.length);
    }

    public void part(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int left = l;
        int right = r;
        int i = arr[l];
        while (l != r) {
            while (r > l && arr[--r] > i) {};
            while (l < r && arr[++l] < i) {};
            if (l >= r) {
                break;
            }
            exchange(arr, l, r);
        }
        exchange(arr, left, l);
        part(arr, left, l);
        part(arr, l + 1, right);
    }

    private void exchange(int[] arr, int l, int r) {
        int i = arr[l];
        arr[l] = arr[r];
        arr[r] = i;
    }


}
