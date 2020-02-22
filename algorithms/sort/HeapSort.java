package sort;

/**
 * @author Fcb
 * @date 2020/2/19
 * @description 堆排序，时间复杂度O(nlogn)，空间复杂度O(1)
 */
public class HeapSort implements Sort {

    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);//从0到i上数组形成大根堆
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 1) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    private void heapInsert(int[] arr, int i) {
        //有个巧妙点就是到达根位置时i=0,(i-1)/2=0，arr[0]=arr[0]，比较停止
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = (left + 1 < heapSize && arr[left] < arr[left + 1]) ?
                    left + 1 : left;
            if (arr[largest] > arr[index]) {
                swap(arr, largest, index);
                index = largest;
                left = index * 2 + 1;
            } else {
                break;
            }
        }
    }

}
