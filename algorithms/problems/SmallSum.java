package problems;

/**
 * @author Fcb
 * @date 2020/2/16
 * @description
 */
public class SmallSum {

    /**
     * @author Fcb
     * @date 2020/2/16
     * @description
     * 小和问题和逆序对问题
     * 1.在一个数组中，每一个数左边比当前数小的数累加起来，叫这个数组的小和，求一个数组的小和
     * 举例：[1,3,4,2,5]
     * 1:没有
     * 3:1
     * 4:1,3
     * 2:1
     * 5:1,3,4,2
     * 该数组的小和为:1+1+3+1+1+3+4+2=16
     * 2.在一个数组中，左边的数如果比右边的数大，则这两个数构成一个逆序对
     * 逆序对类似也可以用归并求，看左边那块对于右边某个数有多少个逆序数。
     */
    public int getSmallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    private int mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + (r - l) / 2;
        return mergeSort(arr, l, mid)
                + mergeSort(arr, mid + 1, r)
                + merge(arr, l, mid, r);
    }

    private int merge(int[] arr, int l, int mid, int r) {
        int[] sort = new int[r - l + 1];
        //声明用来合并的数组的下标和原数组两半的下标
        int index = 0;
        int index1 = l;
        int index2 = mid + 1;
        int res = 0;
        //两个下标都没有越界
        while (index1 <= mid && index2 <= r) {
            res += arr[index1] < arr[index2] ? (arr[index1] * (r - index2 + 1)) : 0;
            sort[index++] = arr[index1] < arr[index2] ? arr[index1++] : arr[index2++];
        }
        //外排一次以后有且只有一个下标越界
        while (index1 <= mid) {
            sort[index++] = arr[index1++];
        }
        while (index2 <= r) {
            sort[index++] = arr[index2++];
        }
        //将原数组的值顺序修改
        for (int i = 0; i < sort.length; i++) {
            arr[i + l] = sort[i];
        }
        return res;
    }
}
