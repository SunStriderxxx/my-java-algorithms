package sort;

/**
 * @author FCB
 * @date 2019-04-08
 * @description 插入排序
 */
public class InsertionSort implements Sort {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = 1; i < arr.length; i++){
            for (int j = i - 1; j >= 0 && arr[j] > arr[j+1]; j--){
                int tmp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = tmp;
            }
        }
    }
}