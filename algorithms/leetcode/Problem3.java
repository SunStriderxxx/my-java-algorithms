package leetcode;

/**
 * @author Fcb
 * @date 2020/5/23
 * @description 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem3 {

    /**
     * 解题思路：滑动窗口算法
     * 左右指针l,r。当l到r中的字符串不包含重复字符时，r++。
     * 包含时，l++，直到不包含重复字符。
     * 不包含重复字符时需要记录子串长度。
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] windowFreq = new int[128];

        int left = 0;
        int right = 0;
        int length = 1;
        //[left, right)
        while (right < s.length()) {
            char c = chars[right];
            //假如left指向的下标未出现过，则一直滑动
            if (windowFreq[c] == 0) {
                right++;
                windowFreq[c]++;
                continue;
            }
            //在右边界停止的时候维护一次length
            length = Math.max(length, right - left);
            //假如left指向的出现了，则左边界一直滑动到未出现
            while (windowFreq[c] != 0) {
                windowFreq[chars[left]]--;
                left++;
            }
        }
        //最后维护一次length
        length = Math.max(length, right - left);

        return length;
    }

    public static void main(String[] args) {
        Problem3 problem3 = new Problem3();
        System.out.println(problem3.lengthOfLongestSubstring("aab"));
    }
}
