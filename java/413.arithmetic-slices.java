/*
 * @lc app=leetcode id=413 lang=java
 *
 * [413] Arithmetic Slices
 *
 * https://leetcode.com/problems/arithmetic-slices/description/
 *
 * algorithms
 * Medium (65.09%)
 * Likes:    4654
 * Dislikes: 274
 * Total Accepted:    267.7K
 * Total Submissions: 411.3K
 * Testcase Example:  '[1,2,3,4]'
 *
 * An integer array is called arithmetic if it consists of at least three
 * elements and if the difference between any two consecutive elements is the
 * same.
 * 
 * 
 * For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic
 * sequences.
 * 
 * 
 * Given an integer array nums, return the number of arithmetic subarrays of
 * nums.
 * 
 * A subarray is a contiguous subsequence of the array.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3,4]
 * Output: 3
 * Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and
 * [1,2,3,4] itself.
 * 
 * 
 * Example 2:
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
 * 1 <= nums.length <= 5000
 * -1000 <= nums[i] <= 1000
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Subproblem:
    //  * arithmetic[i] = the number of arithmetic subarrays in nums[0..i] 
    //  * including nums[i].
    //  * 
    //  * Recurrence relation:
    //  * arithmetic[i] = arithmetic[i-1] + 1 if nums[i] - nums[i-1] = nums[i-1] - nums[i-2]
    //  *               = 0                   otherwise
    //  * airthmetic[0] = 0
    //  * airthmetic[1] = 0
    //  * 
    //  * Time complexity:
    //  * O(N)
    //  */
    // public int numberOfArithmeticSlices(int[] nums) {
    //     int N = nums.length;
    //     int[] arithmetic = new int[N];
    //     for (int i = 2; i < N; ++i) {
    //         if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
    //             arithmetic[i] = arithmetic[i - 1] + 1;
    //         }
    //     }

    //     int count = 0;
    //     for (int num : arithmetic) {
    //         count += num;
    //     }
    //     return count;
    // }

    /**
     * Space optimization.
     */
    public int numberOfArithmeticSlices(int[] nums) {
        int arithmetic = 0, prev = 0;
        for (int i = 2; i < nums.length; ++i) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                ++prev;
                arithmetic += prev;
            } else {
                prev = 0;
            }
        }
        return arithmetic;
    }
}
// @lc code=end

