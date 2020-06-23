package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Fcb
 * @date 2020/6/23
 * @description 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem46 {

    /**
     * 解题思路：回溯
     * 这题是回溯算法的入门问题，适合和本人一样学习体会一下回溯算法。
     * 回溯算法的思路是：依次遍历每一种出现的可能，每到达合适的结果点时保存结果，然后清除状态返回上一级，继续遍历
     * 回溯指的就是保存结果后、清除状态返回这样一个过程。
     * 上面的话看起来有点抽象，其实结合到本题翻译一下就是：
     * 一个数字一个数字的找出来并排列，当排好的结果为一种排列时保存结果，清除当前状态返回上一个数字，继续遍历
     * 下面看代码
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //边界条件
        if (nums.length == 0) {
            return res;
        }
        //回溯往往是一个递归的过程，需要的参数为：当前状态、当前结果、用来保存当前结果的list
        //当前状态，用布尔类型数组标志每个数字当前是否有使用，初始化默认都为false因此不用显式赋值
        boolean[] visited = new boolean[nums.length];
        //当前结果：用来保存当前遍历的结果，为了体现"回溯"这个特点，用栈这个结构来存储
        Deque<Integer> stack = new ArrayDeque<>();
        //用来保存当前结果的list：res
        backTrack(stack, visited, res, nums);
        return res;
    }

    private void backTrack(Deque<Integer> stack, boolean[] visited, List<List<Integer>> res, int[] nums) {
        //递归返回条件：当前结果（栈）的大小等于目标数组的大小，此时是一个排列，记录排列
        //记录排列时要记录新的数组，而不是记录引用，引用后续会发生变化最后变为空数组
        if (stack.size() == nums.length) {
            res.add(new ArrayList<>(stack));
            return;
        }

        //遍历数组搜寻排列
        for (int i = 0; i < nums.length; i++) {
            //当前数字的状态已经被使用，则跳过，继续下个数字
            if (visited[i]) {
                continue;
            }

            stack.push(nums[i]);
            visited[i] = true;
            backTrack(stack, visited, res, nums);
            //回溯：清除状态
            stack.pop();
            visited[i] = false;
        }
    }
}
