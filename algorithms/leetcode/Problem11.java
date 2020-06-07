package leetcode;

/**
 * @author Fcb
 * @date 2020/6/5
 * @description 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
 *
 * 示例：
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem11 {

    /**
     * 解题思路：双指针
     * 左右位置各一个指针，算出当前盛水的容积。此时我们应该移动哪一个指针？
     * 答案是移动高度较低的那个。思考一下：从边界开始，最低的那个边一定算出了以它为边的最大容积。
     * 假设左侧高度为x，右侧高度为y，不妨设x<y。
     * 以x为边的最大容积为x*最大宽度，也就是当前宽度。假设y移动到任何一个位置，宽度都小于当前，所以当前就是x为边的最大容积。
     * x剔除后，问题的规模小了1，以新的边的最边，继续按照这个算法算下去，最后算出最大容积，时间复杂度O(n)
     */
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = Math.min(height[l], height[r]) * (r - l);
        while (l < r) {
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
        }
        return max;
    }
}
