package leetcode;

/**
 * @author Fcb
 * @date 2020/7/3
 * @description N天后的牢房
 * 8 间牢房排成一排，每间牢房不是有人住就是空着。
 *
 * 每天，无论牢房是被占用或空置，都会根据以下规则进行更改：
 *
 * 如果一间牢房的两个相邻的房间都被占用或都是空的，那么该牢房就会被占用。
 * 否则，它就会被空置。
 * （请注意，由于监狱中的牢房排成一行，所以行中的第一个和最后一个房间无法有两个相邻的房间。）
 *
 * 我们用以下方式描述监狱的当前状态：如果第 i 间牢房被占用，则 cell[i]==1，否则 cell[i]==0。
 *
 * 根据监狱的初始状态，在 N 天后返回监狱的状况（和上述 N 种变化）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：cells = [0,1,0,1,1,0,0,1], N = 7
 * 输出：[0,0,1,1,0,0,0,0]
 * 解释：
 * 下表概述了监狱每天的状况：
 * Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
 * Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
 * Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
 * Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
 * Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
 * Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
 * Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
 * Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
 *
 * 示例 2：
 *
 * 输入：cells = [1,0,0,1,0,0,1,0], N = 1000000000
 * 输出：[0,0,1,1,1,1,1,0]
 *  
 *
 * 提示：
 *
 * cells.length == 8
 * cells[i] 的值为 0 或 1 
 * 1 <= N <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/prison-cells-after-n-days
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem957 {

    public static void main(String[] args) {
        Problem957 o = new Problem957();
        o.prisonAfterNDays(new int[]{0,1,0,1,1,0,0,1}, 7);
    }

    /**
     * 解题思路：依次遍历：N很大时超时
     * 实际上变化有规律，思路是找出变化的周期，然后再用N%周期得到结果
     * 评论区有大佬指出周期是14，但是没有根据，待定
     */
    public int[] prisonAfterNDays(int[] cells, int N) {
        for (int i = 0; i < N; i++) {
            cells = change(cells);
        }
        return cells;
    }

    private int[] change(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1] == arr[i + 1]) {
                res[i] = 1;
            } else {
                res[i] = 0;
            }
        }
        return res;
    }
}
