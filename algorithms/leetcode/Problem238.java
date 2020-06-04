package leetcode;

/**
 * @author Fcb
 * @date 2020/6/4
 * @description 除自身以外数组的乘积
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 *  
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *  
 *
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 *
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem238 {

    /**
     * 解题思路：左右乘积列表
     * 维护i位置左边乘积的列表，和i位置右边乘积的列表。相乘，得到i位置上的答案
     * 题目要求空间复杂度O(1)，那么考虑一边的乘积列表可以用一个整形变量代替。
     * 为什么不可以两个列表都用变量代替呢？因为左边的乘积列表的首位与右边成绩列表中最后一位相对应;
     * 假如都用变量的话，必然有一个变量需要重复计算从而使时间复杂度退化到O(n^2)。
     * 那么剩下的乘积列表如何处理？题目说了返回数组不算额外空间复杂度，因此可以一开始将一个乘积列表放在返回数组中，从而实现了空间复杂度O(1)
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return nums;
        }
        int[] out = new int[nums.length];
        //前序乘积列表首位为0
        out[0] = 1;
        //构造前序成绩列表
        for (int i = 1; i < nums.length; i++) {
            out[i] = nums[i - 1] * out[i - 1];
        }
        //R为后序乘积和
        int R = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            R *= nums[i + 1];
            out[i] = out[i] * R;
        }
        return out;
    }
}
