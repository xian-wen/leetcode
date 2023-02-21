/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 *
 * https://leetcode.com/problems/house-robber/description/
 *
 * algorithms
 * Medium (49.31%)
 * Likes:    16924
 * Dislikes: 328
 * Total Accepted:    1.5M
 * Total Submissions: 3.1M
 * Testcase Example:  '[1,2,3,1]'
 *
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping
 * you from robbing each of them is that adjacent houses have security systems
 * connected and it will automatically contact the police if two adjacent
 * houses were broken into on the same night.
 * 
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the
 * police.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house
 * 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * Subproblem:
     * amount[i] = The maximum amount of money attainable by robbing the subset
     * of house 1, 2, ..., i.
     * 
     * Recursive relation:
     * amount[i] = max{amount[i - 1], amount[i - 2] + nums[i - 1]}
     * amount[0] = 0
     * amount[1] = nums[0]
     * 
     * Time complexity:
     * O(N)
     */
    public int rob(int[] nums) {
        int N = nums.length;
        int[] amount = new int[N + 1];
        // By default, amount[0] = 0
        amount[1] = nums[0];
        for (int i = 2; i <= N; ++i) {
            amount[i] = Math.max(amount[i - 1], amount[i - 2] + nums[i - 1]);
        }
        return amount[N];
    }
}
// @lc code=end

