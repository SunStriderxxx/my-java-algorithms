package sort;

/**
 * @author Fcb
 * @date 2020/2/15
 * @description 归并排序，时间复杂度O(nlogn)，空间复杂度O(n)，可以稳定，合并的时候先排左边
 */
public class MergeSort implements Sort {

    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0){
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    public void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        mergeSort(arr, l, mid);//T(n/2)
        mergeSort(arr, mid + 1, r);//T(n/2)
        merge(arr, l, mid, r);//O(n)
        //master公式:T(n) = 2T(n/2) + O(n) -> 时间复杂度：O(nlogn)
    }

    private void merge(int[] arr, int l, int mid, int r){
        int[] sort = new int[r - l + 1];
        //声明用来合并的数组的下标和原数组两半的下标
        int index = 0;
        int index1 = l;
        int index2 = mid + 1;
        //两个下标都没有越界
        while (index1 <= mid && index2 <= r){
            sort[index++] = arr[index1] <= arr[index2] ? arr[index1++] : arr[index2++];
        }
        //外排一次以后有且只有一个下标越界
        while (index1 <= mid){
            sort[index++] = arr[index1++];
        }
        while (index2 <= r){
            sort[index++] = arr[index2++];
        }
        //将原数组的值顺序修改
        for (int i = 0; i < sort.length; i++){
            arr[i + l] = sort[i];
        }
    }

}
