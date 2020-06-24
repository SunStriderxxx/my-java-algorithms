package leetcode;

/**
 * @author Fcb
 * @date 2020/6/24
 * @description 面试题01.07：旋转矩阵
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 *
 * 不占用额外内存空间能否做到？
 *  
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-matrix-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem0107 {

    /**
     * 解题思路：解这种矩阵的题要有宏观的思想
     * 什么是宏观思想？旋转的时候将其看成一个整体，4条边上的点在同时旋转。
     * 旋转完一轮后，正方形缩减一圈，重复该步骤，直到正方形缩减为一个点或者不存在。
     */
    public void rotate(int[][] matrix) {
        //左上角、右下角的下标先确定
        //左上角行坐标
        int LR = 0;
        //左上角列坐标
        int LC = 0;
        //右下角列坐标
        int RR = matrix.length - 1;
        //右下角列坐标
        int RC = matrix.length - 1;
        //因为肯定是正方形，不是正方形的话不能这样旋转，所以只考虑LR和RR就行了
        while (LR < RR) {
            for (int i = 0; i < RC - LC; i++) {
                //左上角和右上角交换
                swap(matrix, LR, LC + i, LR + i, RC);
                //左上角和左下角交换
                swap(matrix, LR, LC + i, RR - i, LC);
                //左下角和右下角交换
                swap(matrix, RR - i, LC, RR, RC - i);
            }
            LR++;
            LC++;
            RR--;
            RC--;
        }
    }

    private void swap(int[][] matrix, int lr, int lc, int rr, int rc) {
        matrix[lr][lc] = matrix[lr][lc] ^ matrix[rr][rc];
        matrix[rr][rc] = matrix[lr][lc] ^ matrix[rr][rc];
        matrix[lr][lc] = matrix[lr][lc] ^ matrix[rr][rc];
    }
}
