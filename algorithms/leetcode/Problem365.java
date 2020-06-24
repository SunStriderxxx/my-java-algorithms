package leetcode;

/**
 * @author Fcb
 * @date 2020/6/13
 * @description 水壶问题
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 *
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 *
 * 你允许：
 *
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * 示例 1: (From the famous "Die Hard" example)
 *
 * 输入: x = 3, y = 5, z = 4
 * 输出: True
 * 示例 2:
 *
 * 输入: x = 2, y = 6, z = 5
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/water-and-jug-problem
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem365 {

    /**
     * 解题思路：不会做
     * 看的答案，根据裴蜀定理，ax+by=z有解时，z是x和y最大公约数的倍数。
     */
    public boolean canMeasureWater(int x, int y, int z) {
        return true;
    }

    public static void main(String[] args) {
        Problem365 o = new Problem365();
        o.canMeasureWater(34, 5, 6);
    }
}