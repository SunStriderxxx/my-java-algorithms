package problems;

/**
 * @author Fcb
 * @date 2020/2/17
 * @description 荷兰国旗问题
 * 存在一个数组，给出数num，小于num的全部在数组左边，等于num的在数组中间，大于num的在数组右边
 */
public class NetherlandsFlag {

    //将数组从L到R范围根据num排成荷兰国旗
    public int[] partition(int[] arr, int L, int R, int num) {
        int less = L - 1;
        int more = R + 1;
        int current = L;
        while (current < more) {
            if (arr[current] < num) {
                swap(arr, current++, ++less);
            } else if (arr[current] > num) {
                swap(arr, current, --more);
            } else {
                current++;
            }
        }
        return new int[]{less + 1, more - 1};
    }

    private void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
