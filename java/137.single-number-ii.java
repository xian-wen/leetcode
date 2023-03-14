/*
 * @lc app=leetcode id=137 lang=java
 *
 * [137] Single Number II
 *
 * https://leetcode.com/problems/single-number-ii/description/
 *
 * algorithms
 * Medium (58.23%)
 * Likes:    5347
 * Dislikes: 538
 * Total Accepted:    402.2K
 * Total Submissions: 688.9K
 * Testcase Example:  '[2,2,3,2]'
 *
 * Given an integer array nums where every element appears three times except
 * for one, which appears exactly once. Find the single element and return it.
 * 
 * You must implement a solution with a linear runtime complexity and use only
 * constant extra space.
 * 
 * 
 * Example 1:
 * Input: nums = [2,2,3,2]
 * Output: 3
 * Example 2:
 * Input: nums = [0,1,0,1,0,1,99]
 * Output: 99
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 3 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * Each element in nums appears exactly three times except for one element
 * which appears once.
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Bit Manipulation
    //  */
    // public int singleNumber(int[] nums) {
    //     int res = 0;
    //     for (int bit = 31; bit >= 0; --bit) {
    //         int count = 0;
    //         for (int num : nums) {
    //             count += (num >> bit) & 1;
    //         }

    //         if (count % 3 != 0) {
    //             res |= 1 << bit;
    //         }
    //     }
    //     return res;
    // }

    /**
     * Solution 2: XOR + AND
     * 
     * ones ^ num: add num if num not in ones
     * ones ^ num: remove num if num in ones
     * (ones ^ num) & ~twos: do the above if num not in twos
     * 
     * For num:
     * first: ones = num, twos = 0
     * second: ones = 0, twos = num
     * third: ones = 0, twos = 0
     * 
     * nums: [2 2 3 2]
     * num = 2
     * ones = 2, twos = 0
     * num = 2
     * ones = 0, twos = 2
     * num = 3
     * ones = 1, twos = 0
     * num = 2
     * ones = 3, twos = 0
     */
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }
}
// @lc code=end

