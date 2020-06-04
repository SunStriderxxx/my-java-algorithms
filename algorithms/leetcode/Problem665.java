package leetcode;

/**
 * @author Fcb
 * @date 2020/6/4
 * @description 非递减数列
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。 
 *
 * 示例 1:
 *
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 *
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 *  
 *
 * 说明：
 *
 * 1 <= n <= 10 ^ 4
 * - 10 ^ 5 <= nums[i] <= 10 ^ 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-decreasing-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem665 {

    /**
     * 解题思路：遍历时，在出现num[i] > nums[i+1]的时候，需要考虑的是修改哪个数，为了不影响后面的数，
     * 优先考虑的修改nums[i], nums[i] = nums[i+1]，假如修改nums[i+1] = nums[i]的话，nums[i+1]会变大，
     * 导致后面的比较出现问题，从而无法得到正确答案。
     * 另外假如num[i-1] > num[i+1]，这时候让nums[i]=nums[i+1]也会出现问题（因为这时候nums[i-1]>nums[i]了），
     * 此时只能尝试性的让nums[i+1]=nums[i]，看能否得到非递减序列。
     */
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length < 3) {
            return true;
        }
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i >= 1 && nums[i - 1] > nums[i + 1]) {
                nums[i + 1] = nums[i];
                count++;
                continue;
            }
            if (nums[i] > nums[i + 1]) {
                nums[i] = nums[i + 1];
                count++;
            }
        }
        return count < 2;
    }

    public static void main(String[] args) {
        Problem665 o = new Problem665();
        o.checkPossibility(new int[]{3, 4, 2, 3});
    }
}
