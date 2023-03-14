/*
 * @lc app=leetcode id=260 lang=java
 *
 * [260] Single Number III
 *
 * https://leetcode.com/problems/single-number-iii/description/
 *
 * algorithms
 * Medium (67.60%)
 * Likes:    4799
 * Dislikes: 209
 * Total Accepted:    291.6K
 * Total Submissions: 431.1K
 * Testcase Example:  '[1,2,1,3,2,5]'
 *
 * Given an integer array nums, in which exactly two elements appear only once
 * and all the other elements appear exactly twice. Find the two elements that
 * appear only once. You can return the answer in any order.
 * 
 * You must write an algorithm that runs in linear runtime complexity and uses
 * only constant extra space.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,1,3,2,5]
 * Output: [3,5]
 * Explanation:  [5, 3] is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [-1,0]
 * Output: [-1,0]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [0,1]
 * Output: [1,0]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= nums.length <= 3 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * Each integer in nums will appear twice, only two integers will appear once.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] singleNumber(int[] nums) {
        // Get XOR of the two single numbers.
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        // Get the rightmost set bit ('1') in xor.
        // e.g., b110 -> setBit = b10 = 2
        int setBit = xor & (-xor);
        
        int[] res = new int[2];
        for (int num : nums) {
            // Set bit must be set in one of the operands of XOR, impossible in
            // both, i.e., set bit divide the two singles into two groups.
            if ((num & setBit) == 0) {
                res[0] ^= num;
            }
        }

        // Like swap, XOR to one of its operands will get another.
        res[1] = xor ^ res[0];
        return res;     
    }
}
// @lc code=end

