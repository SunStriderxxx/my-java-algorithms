package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Fcb
 * @date 2020/7/4
 * @description 最长有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem32 {

    /**
     * 解题方法1：正反遍历
     * 从左往右遍历，记录左括号和右括号的数量
     * 当左括号数量=右括号数量 =》记录长度，作为结果候选
     * 当右括号>左括号数量 =》左右数量
     *
     * 从左往右遍历可能会出现左括号大于右括号得不出最佳答案的情况，因此还要反向遍历一遍，取正反两者的最大值的最大值。
     */
    public int longestValidParentheses(String s) {
        int res = 0;
        int leftB = 0;
        int rightB = 0;
        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i)) {
                leftB++;
            } else {
                rightB++;
            }
            if (rightB > leftB) {
                leftB = 0;
                rightB = 0;
            }
            if (rightB == leftB) {
                res = Math.max(leftB + rightB, res);
            }
        }
        leftB = 0;
        rightB = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if ('(' == s.charAt(i)) {
                leftB++;
            } else {
                rightB++;
            }
            if (leftB > rightB) {
                leftB = 0;
                rightB = 0;
            }
            if (rightB == leftB) {
                res = Math.max(leftB + rightB, res);
            }
        }
        return res;
    }

    /**
     * 解题思路2：用栈
     * 栈底存储之前一次记录最长有效子串的结尾，初始化为-1
     * 当前字符为'('时，入栈，为')'时，弹栈。
     * 假如弹完栈，栈底有元素，则当前元素下标-栈底元素（上个结尾元素）=当前最大长度
     * 假如弹完栈，栈底无元素，则说明当前子串无效，将当前下标存入栈底，记作上次有效子串的结尾
     */
    public int longestValidParentheses2(String s) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                int pre = stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            } else {
                stack.push(i);
            }
        }
        return res;
    }
}
