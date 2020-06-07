package leetcode;

/**
 * @author Fcb
 * @date 2020/6/6
 * @description 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem31 {

    /**
     * 解题思路：这题主要是数学分析，让数字的排列变大，直接抄答案
     *
     * 我们希望下一个数比当前数大，这样才满足“下一个排列”的定义。因此只需要将后面的「大数」与前面的「小数」交换，就能得到一个更大的数。比如 123456，将 5 和 6 交换就能得到一个更大的数 123465。
     * 我们还希望下一个数增加的幅度尽可能的小，这样才满足“下一个排列与当前排列紧邻“的要求。为了满足这个要求，我们需要：
     * 在尽可能靠右的低位进行交换，需要从后向前查找
     * 将一个 尽可能小的「大数」 与前面的「小数」交换。比如 123465，下一个排列应该把 5 和 4 交换而不是把 6 和 4 交换
     * 将「大数」换到前面后，需要将「大数」后面的所有数重置为升序，升序排列就是最小的排列。以 123465 为例：首先按照上一步，交换 5 和 4，得到 123564；然后需要将 5 之后的数重置为升序，得到 123546。显然 123546 比 123564 更小，123546 就是 123465 的下一个排列
     *
     * 1.从后向前查找第一个相邻升序的元素对 (i,j)，满足 A[i] < A[j]。此时 [j,end) 必然是降序
     * 2.在 [j,end) 从后向前查找第一个满足 A[i] < A[k] 的 k。A[i]、A[k] 分别就是上文所说的「小数」、「大数」
     * 3.将 A[i] 与 A[k] 交换
     * 4.可以断定这时 [j,end) 必然是降序，逆置 [j,end)，使其升序
     * 5.如果在步骤 1 找不到符合的相邻元素对，说明当前 [begin,end) 为一个降序顺序，则直接跳到步骤 4
     *
     * 作者：imageslr
     * 链接：https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        //从后往前找,后面的数比以前的数小才有变大的空间,找到最近的小数,然后拿右边最小大于小数的数和小数交换，并将交换位置后面的数重新排序
        int index = nums.length - 1;
        while (index >= 1 && nums[index] <= nums[index - 1]) {
            index--;
        }
        //如果全部找不到，则全体逆序，颠倒回去即可
        if (index == 0) {
            for (int i = 0; i < nums.length / 2; i++) {
                int tmp = nums[i];
                nums[i] = nums[nums.length - 1 - i];
                nums[nums.length - 1 - i] = tmp;
            }
            return;
        }
        //此时num[index] > nums[index - 1]，倒着找到最小大于nums[index - 1]的数并交换
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[index - 1]) {
                int tmp = nums[i];
                nums[i] = nums[index - 1];
                nums[index - 1] = tmp;
                break;
            }
        }
        //再从index到结尾调整正序,此时(index,end)还是逆序的，为什么呢？因为交换的index >= i + 1，所以交换后逆序不变。
        for (int i = index; i < index + (nums.length - index) / 2; i++) {
            int tmp = nums[i];
            nums[i] = nums[nums.length + index - 1 - i];
            nums[nums.length + index - 1 - i] = tmp;
        }
    }

    public static void main(String[] args) {
        Problem31 o = new Problem31();
        o.nextPermutation(new int[]{1, 3 ,2});
    }
}
