package leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Fcb
 * @date 2020/6/6
 * @description 最长连续子序列
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem128 {

    /**
     * 解题思路：
     * 方法2：每个数依次找连续的值，直到找到最大连续长度，
     * 利用哈希表存储数组中的值，便于判断每个值是否存在连续的值，
     * 但是这样时间复杂不能优化的O(n),最坏情况是O(n2)，因为每个数都可能要依次找N个数
     * 如何优化到O(n)呢，让我们来思考一个数的寻找过程，
     * 假如x能找到x+1,继续找下去，x,x+1,x+2,...,y。一共找到y-x+1个连续数
     * 后续遍历到x+1,x+2,y的时候还需要重复这个过程吗？答案是否定的。
     * 所以得到优化条件：当数组中存在x-1时，当前数就不用找最大连续长度了。
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //将数放入哈希表中，便于查找
        HashSet<Integer> hash = new HashSet<>();
        for (int i : nums) {
            hash.add(i);
        }
        int max = 1;
        //接下来是找最大长度
        for (int i : nums) {
            int count = 1;
            int x = i;
            if (hash.contains(x - 1)) {
                continue;
            }
            while (hash.contains(x + 1)) {
                count++;
                x = x + 1;
            }
            count = 1;
            max = Math.max(max, count);
        }
        return max;
    }

    /**
     * 解题思路：
     * 方法1：先排序，然后计算，这样做不到时间复杂度O(n)，排序的时间复杂度是O(nlogn)
     */
    public int longestConsecutive1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int max = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            //大于1，则连续
            if (nums[i] == (nums[i - 1] + 1)) {
                count++;
                //超过1以上重新计算，等于的话啥也不干
            } else if (nums[i] > nums[i - 1] + 1){
                max = Math.max(max, count);
                count = 1;
            }
        }
        max = Math.max(max, count);
        return max;
    }
}
