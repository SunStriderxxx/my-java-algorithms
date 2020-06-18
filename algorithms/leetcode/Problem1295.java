package leetcode;

/**
 * @author Fcb
 * @date 2020/6/18
 * @description Find Numbers with Even Number of Digits
 * Given an array nums of integers, return how many of them contain an even number of digits.
 *
 * Example 1:
 *
 * Input: nums = [12,345,2,6,7896]
 * Output: 2
 * Explanation:
 * 12 contains 2 digits (even number of digits). 
 * 345 contains 3 digits (odd number of digits). 
 * 2 contains 1 digit (odd number of digits). 
 * 6 contains 1 digit (odd number of digits). 
 * 7896 contains 4 digits (even number of digits). 
 * Therefore only 12 and 7896 contain an even number of digits.
 * Example 2:
 *
 * Input: nums = [555,901,482,1771]
 * Output: 1
 * Explanation:
 * Only 1771 contains an even number of digits.
 *  
 *
 * Constraints:
 *
 * 1 <= nums.length <= 500
 * 1 <= nums[i] <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-numbers-with-even-number-of-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem1295 {

    public static void main(String[] args) {
        Problem1295 o = new Problem1295();
        int numbers = o.findNumbers(new int[]{555, 901, 482, 1771});
        System.out.println(numbers);
    }

    public int findNumbers(int[] nums) {
        int count = 0;
        for (int i : nums) {
            int number = 0;
            while (i > 0) {
                i /= 10;
                number++;
            }
            if ((number & 1) == 0) {
                count++;
            }
        }
        return count;
    }
}
