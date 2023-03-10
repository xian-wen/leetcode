/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 *
 * https://leetcode.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (61.40%)
 * Likes:    12938
 * Dislikes: 329
 * Total Accepted:    2.1M
 * Total Submissions: 3.5M
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * Given an integer array nums, move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 * 
 * Note that you must do this in-place without making a copy of the array.
 * 
 * 
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * 
 * 
 * 
 * Follow up: Could you minimize the total number of operations done?
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1
    //  */
    // public void moveZeroes(int[] nums) {
    //     int N = nums.length;
    //     for (int i = 1; i < N; ++i) {
    //         if (nums[i] != 0) {
    //             int j = i - 1;
    //             // Search the first j where nums[j] != 0
    //             while (j >= 0 && nums[j] == 0) {
    //                 --j;
    //             }
                
    //             if (j < 0 || j < i - 1) {
    //                 nums[j + 1] = nums[i];
    //                 nums[i] = 0;
    //             }
    //         }
    //     }
    // }

    /**
     * Solution 2
     */
    public void moveZeroes(int[] nums) {
        int N = nums.length, last = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[last++] = num;
            }
        }

        while (last < N) {
            nums[last++] = 0;
        }
    }
}
// @lc code=end

