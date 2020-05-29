package leetcode;

import java.util.Arrays;

/**
 * @author Fcb
 * @date 2020/5/28
 * @description 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *  
 *
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem322 {


    /**
     * 解题思路：动态规划，自底向上。
     * 当前为i个硬币时，假设coins[]中存在i，则dp[i]=1，这意味着dp[0]=0；
     * 若不存在且coins[]中存在比i小的元素，那么dp[i]=min(dp[i-coins[x])+1 x从0->n-1。
     * 该公式的意思是当前值i需要硬币的最少数量 为 去掉一枚硬币后需要最少数量的dp[i-x]+1
     * 为了得到dp[i]，我们从x=1开始计算dp[x]，逐步递增到dp[i]
     * 例如i=11，coins[1,2,5]
     * x = 1, dp[x] = min(dp[1-1]+1, dp[1-2]+1, dp[1-5]+1) ==> dp[1] = 1 （下标为负数视为无效）
     * x = 2, dp[x] = min(dp[2-1]+1, dp[2-2]+1, dp[2-5]+1) ==> dp[2] = 1
     * x = 3, dp[x] = min(dp[2]+1, dp[1]+1, dp[3-5]+1) ==> dp[3] = 2
     * x = 4, dp[x] = min(dp[3]+1, dp[2]+1, dp[4-5]+1) ==> dp[4] = 2
     * x = 5, dp[x] = min(dp[4]+1, dp[3]+1, dp[0]+1) ==> dp[5] = 1
     * x = 6, dp[x] = min(dp[5]+1, dp[4]+1, dp[1]+1) ==> dp[6] = 2
     * x = 7, dp[x] = min(dp[6]+1, dp[5]+1, dp[2]+1) ==> dp[7] = 2
     * x = 8, dp[x] = min(dp[7]+1, dp[6]+1, dp[3]+1) ==> dp[8] = 3
     * x = 9, dp[x] = min(dp[8]+1, dp[7]+1, dp[4]+1) ==> dp[9] = 3
     * x = 10, dp[x] = min(dp[9]+1, dp[8]+1, dp[5]+1) ==> dp[10] = 2
     * x = 11, dp[x] = min(dp[10]+1, dp[9]+1, dp[6]+1) ==> dp[11] = 3
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 0; i < amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]]) + 1;
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
