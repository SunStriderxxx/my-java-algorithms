package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Fcb
 * @date 2020/6/20
 * @description 接雨水
 *
 */
public class Problem42 {


    public static void main(String[] args) {

    }

    /**
     * @author Fcb
     * @date 2020/6/20
     * @description 解题思路：暴力解法、动态规划、单调栈、双指针
     * 原理：每个柱子的积水量= Math.min(该柱子左侧最高柱子，该柱子右侧最高柱子) - 当前柱子高度
     * 动态规划：存储每个位置左侧最大值和右侧最大值
     * 单调栈：后续柱子只有比当前柱子高，当前柱子才能积水
     * 双指针：假设左侧指针比右侧高，可以把右侧当前柱子的垂直积水量算出；否则相反算出。左右指针会在最高的柱子重合，重合时计算完毕
     */
    //双指针版本
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int lMax = 0;
        int rMax = 0;
        int res = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] > lMax) {
                    lMax = height[l];
                } else {
                    res += lMax - height[l];
                }
                l++;
            } else {
                if (height[r] > rMax) {
                    rMax = height[r];
                } else {
                    res += rMax - height[r];
                }
                r--;
            }
        }
        return res;
    }

    //单调栈版本
    public int trapStack(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                Integer index = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = i - stack.peek() - 1;
                int high = Math.min(height[i], height[stack.peek()]) - height[index];
                res += distance * high;
            }
            stack.push(i);
        }
        return res;
    }
}
