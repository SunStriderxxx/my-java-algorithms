package leetcode;

/**
 * @author Fcb
 * @date 2020/6/5
 * @description 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem7 {

    /**
     * 解题思路：首先是正常的反转
     * 然后考虑边界条件就是每次*10时检查是否溢出：*10>max或者*10=max且余数大于7或小于-8(负数)
     */
    public int reverse(int x) {
        int reverse = 0;
        while(x != 0) {
            int pop = x % 10;
            if (reverse > Integer.MAX_VALUE/10 || (reverse == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (reverse < Integer.MIN_VALUE/10 || (reverse == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            reverse = reverse * 10 + pop;
            x /= 10;
        }
        return reverse;
    }
}
