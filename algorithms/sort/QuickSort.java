package sort;

import lombok.Builder;
import lombok.NoArgsConstructor;
import problems.NetherlandsFlag;

/**
 * @author Fcb
 * @date 2019/3/8
 * @description 快速排序，时间复杂度O(nlogn)，空间复杂度O(logn)，不稳定
 */
@Builder
@NoArgsConstructor
public class QuickSort implements Sort {

    @Override
    public void sort(int[] arr) {
        part(arr, 0, arr.length - 1);
    }

    public void part(int[] arr, int l, int r) {
        if (l < r){
            NetherlandsFlag netherlandsFlag = new NetherlandsFlag();
            int[] partition = netherlandsFlag.partition(arr, l, r, arr[r]);
            part(arr, 0, partition[0] - 1);
            part(arr, partition[1] + 1, r);
        }
    }

    private void exchange(int[] arr, int l, int r) {
        int i = arr[l];
        arr[l] = arr[r];
        arr[r] = i;
    }

}
