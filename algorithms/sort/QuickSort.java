package sort;

/**
 * @author Fcb
 * @date 2019/3/8
 * @description 快速排序
 */
public class QuickSort {

    public void sort(int[] arr){
        int l = 0;
        int r = arr.length;
        while (l < r){
            int part = part(arr, l, r);

        }
    }

    public int part(int[] arr, int l, int r){
        int i = arr[l];
        while (l != r){
            while (r > l && arr[--r] > i);
            while (l < r && arr[++l] < i);
            if (l >= r){
                break;
            }
            exchange(arr, l, r);
        }
        exchange(arr, i, l);
        return l;
    }

    private void exchange(int[] arr, int l, int r) {
        int i  = arr[l];
        arr[l] = arr[r];
        arr[r] = i;
    }


}
