import java.util.Arrays;

/*
 * @lc app=leetcode id=581 lang=java
 *
 * [581] Shortest Unsorted Continuous Subarray
 *
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
 *
 * algorithms
 * Medium (36.40%)
 * Likes:    7231
 * Dislikes: 245
 * Total Accepted:    298.5K
 * Total Submissions: 819.7K
 * Testcase Example:  '[2,6,4,8,10,9,15]'
 *
 * Given an integer array nums, you need to find one continuous subarray that
 * if you only sort this subarray in ascending order, then the whole array will
 * be sorted in ascending order.
 * 
 * Return the shortest such subarray and output its length.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [2,6,4,8,10,9,15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make
 * the whole array sorted in ascending order.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,2,3,4]
 * Output: 0
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1]
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^4
 * -10^5 <= nums[i] <= 10^5
 * 
 * 
 * 
 * Follow up: Can you solve it in O(n) time complexity?
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Sort
    //  */
    // public int findUnsortedSubarray(int[] nums) {
    //     int[] sorted = nums.clone();
    //     Arrays.sort(sorted);
    //     int N = nums.length, left = 0, right = N - 1;
    //     while (left < N && nums[left] == sorted[left]) {
    //         ++left;
    //     }

    //     while (right >= 0 && nums[right] == sorted[right]) {
    //         --right;
    //     }
        
    //     int len = right - left + 1;
    //     return Math.max(0, len);
    // }

    /**
     * Solution 2
     * 
     * index: 0 1 2 3 4
     * nums: [1 3 5 2 4]
     * max from left (maxLeft): -∞, invalid index (right): -1
     * => => => ...
     * max from left (maxLeft): 5, invalid index (right): 4
     * 
     * min from right (minRight): ∞, invalid index (left): 5
     * => => => ...
     * min from right (minRight): 2, invalid index (left): 1
     * 
     * minLen = right - left + 1 = 4-1+1 = 4
     */
    public int findUnsortedSubarray(int[] nums) {
        int N = nums.length;
        int maxLeft = Integer.MIN_VALUE, right = -1;
        for (int i = 0; i < N; ++i) {
            maxLeft = Math.max(maxLeft, nums[i]);
            if (nums[i] < maxLeft) {
                right = i;
            }
        }

        if (right == -1) {
            return 0;
        }

        int minRight = Integer.MAX_VALUE, left = N;
        for (int i = N - 1; i >= 0; --i) {
            minRight = Math.min(minRight, nums[i]);
            if (nums[i] > minRight) {
                left = i;
            }
        }
        return Math.max(0, right - left + 1);
    }
}
// @lc code=end

