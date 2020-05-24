package leetcode;

/**
 * @author Fcb
 * @date 2020/5/23
 * @description 最小覆盖子串
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem76 {

    /**
     * 解题思路：滑动窗口算法
     * 左右指针l,r。当l到r中的字符串不包含t时，r++。
     * 当包含t时记录长度，r停止滑动，l++，继续判断是否包含t，等到不包含t时，r++。
     * 循环这个过程
     * 判断s子串包含t的过程，利用
     */
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        //记录子串频次和t频次的数组
        int[] windowFreq = new int[128];
        int[] tFreq = new int[128];

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        //记录t字符频次
        for (char c : tArray) {
            tFreq[c]++;
        }

        //滑动窗口中包含了多少T的字符，对应字符频率超过不重复计算，用来简化判断包含子串
        int distance = 0;
        int minlen = sLen + 1;

        int begin = 0;
        int left = 0;
        int right = 0;
        // [left , right) 左闭右开
        // 好处:right左边的字符都是程序看到的，right-left等于子串长度，初始化为0从0数组开始
        while (right <= sLen) {
            //相等代表包含了所有字符串,左下标滑动,否则右下标滑动
            if (distance == tLen) {
                if ((right - left) < minlen) {
                    minlen = right - left;
                    begin = left;
                }
                char c = sArray[left++];
                if (windowFreq[c]-- == tFreq[c]) {
                    distance--;
                }
            } else {
                if (right == sLen) {
                    break;
                }
                char c = sArray[right++];
                if (windowFreq[c]++ < tFreq[c]) {
                    distance++;
                }
            }

        }
        if (minlen == sLen + 1) {
            return "";
        }
        return s.substring(begin, begin + minlen);
    }

    public static void main(String[] args) {
        Problem76 problem76 = new Problem76();
        problem76.minWindow("ADOBECODEBANC", "ABC");
    }
}
