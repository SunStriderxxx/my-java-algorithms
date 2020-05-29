package leetcode;

import java.util.PriorityQueue;

/**
 * @author Fcb
 * @date 2020/5/24
 * @description 寻找两个正序数组的中位数
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem4 {

    /**
     * 解题思路：大顶堆和小顶堆
     * 将数组中的数放到大顶堆和小顶堆中，小顶堆所有数字都比大顶堆大。
     * 那么当总数是奇数时，中位数是某个堆顶（和实现有关），当总数是偶数时，中位数是两个堆顶的平均值。
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> big = new PriorityQueue<>((x,y) -> (y - x));
        PriorityQueue<Integer> small = new PriorityQueue<>();
        for (int i = 0; i < nums1.length; i++) {
            if (i % 2 == 0) {
                int i1 = nums1[i];
                if (small.peek() == null || i1 <= small.peek()) {
                    big.add(i1);
                }else {
                    Integer poll = small.poll();
                    small.add(i1);
                    big.add(poll);
                }
            } else {
                int i1 = nums1[i];
                if (big.peek() == null || i1 >= big.peek()) {
                    small.add(i1);
                }else {
                    Integer poll = big.poll();
                    big.add(i1);
                    small.add(poll);
                }
            }
        }
        for (int i = nums1.length; i < nums2.length + nums1.length; i++) {
            if (i % 2 == 0) {
                int i1 = nums2[i - nums1.length];
                if (small.peek() == null || i1 <= small.peek()) {
                    big.add(i1);
                }else {
                    Integer poll = small.poll();
                    small.add(i1);
                    big.add(poll);
                }
            } else {
                int i1 = nums2[i - nums1.length];
                if (big.peek() == null || i1 >= big.peek()) {
                    small.add(i1);
                }else {
                    Integer poll = big.poll();
                    big.add(i1);
                    small.add(poll);
                }
            }
        }
        if ((nums1.length + nums2.length) % 2 == 0) {
            return (big.peek() + small.peek()) / 2.0;
        } else {
            return big.peek();
        }
    }

    public static void main(String[] args) {
        Problem4 problem4 = new Problem4();
        System.out.println(problem4.findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
    }
}
