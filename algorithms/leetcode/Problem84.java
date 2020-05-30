package leetcode;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Fcb
 * @date 2020/5/30
 * @description 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。

 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。  
 *
 * 示例:
 *
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem84 {

    /**
     * 解题思路：暴力解法、利用栈。
     * 暴力解法：依次以每个柱子为中心，向两边扩散，算出最大面积，最后选出最大的面积
     * 栈：在计算每个柱子高度的最大矩形面积时，发现存在后进先出的情况，于是考虑用栈。
     * 具体做法是：依次将柱子的下标压入栈，如果下一个柱子的高度大于等于当前柱子，则继续压入。否则弹出当前柱子，计算出面积。
     * 面积是 弹出柱子的下标-弹栈后栈内元素的下标。写代码的时候利用左右哨兵（高度0，下标-1）(高度0，下标length)保证代码的简洁性
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        //增加左右哨兵
        int[] newHeights = new int[heights.length+2];
        for (int i = 0; i < heights.length; i++) {
            newHeights[i + 1] = heights[i];
        }
        heights = newHeights;

        int max = 0;
        stack.push(0);
        for (int i = 1; i < heights.length; i++) {
            //如果当前柱子小于前面柱子长度，弹栈计算最大值，要循环计算
            while (heights[stack.peek()] > heights[i]) {
                Integer pre = stack.pop();
                int width = i - stack.peek() - 1;
                max = Math.max(max, heights[pre] * width);
            }
            //最后至少会留一个哨兵，然后压栈当前数
            stack.push(i);
        }
        return max;
    }
}
