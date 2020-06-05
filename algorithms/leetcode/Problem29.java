package leetcode;

/**
 * @author Fcb
 * @date 2020/6/5
 * @description 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 *
 * 限制：
 *
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem29 {

    /**
     * 解题思路：建立宏观思维
     * 记录左上角和右下角的坐标，分4段分别打印，循环即可。
     * 要注意边界条件在同一行或者同一列的场景
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int[] res = new int[matrix.length * matrix[0].length];
        int index = 0;
        int LR = 0;
        int LC = 0;
        int RR = matrix.length - 1;
        int RC = matrix[0].length - 1;
        while (LR < RR && LC < RC) {
            for (int i = LC; i < RC; i++) {
                res[index++] = matrix[LR][i];
            }
            for (int i = LR; i < RR; i++) {
                res[index++] = matrix[i][RC];
            }
            for (int i = RC; i > LC; i--) {
                res[index++] = matrix[RR][i];
            }
            for (int i = RR; i > LR; i--) {
                res[index++] = matrix[i][LC];
            }
            LR++;
            LC++;
            RR--;
            RC--;
        }
        //考虑边界
        if (LR == RR && LC == RC) {
            res[index] = matrix[LR][LC];
        }else if (LR == RR) {
            for (int i = LC; i <= RC; i++) {
                res[index++] = matrix[LR][i];
            }
        }else if (LC == RC) {
            for (int i = LR; i <= RR; i++) {
                res[index++] = matrix[i][LC];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem29 o = new Problem29();
        o.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }

}
