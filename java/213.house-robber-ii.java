/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 *
 * https://leetcode.com/problems/house-robber-ii/description/
 *
 * algorithms
 * Medium (40.91%)
 * Likes:    7875
 * Dislikes: 116
 * Total Accepted:    551.5K
 * Total Submissions: 1.3M
 * Testcase Example:  '[2,3,2]'
 *
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed. All houses at this place are
 * arranged in a circle. That means the first house is the neighbor of the last
 * one. Meanwhile, adjacent houses have a security system connected, and it
 * will automatically contact the police if two adjacent houses were broken
 * into on the same night.
 * 
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the
 * police.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money
 * = 2), because they are adjacent houses.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1,2,3]
 * Output: 3
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 * 
 * 
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int N = nums.length;
        if (N == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, N - 1), rob(nums, 1, N));
    }
    
    // /**
    //  * Subproblem:
    //  * sum[i] = the maximum amount of money can be robbed without alerting the
    //  * police in nums[0..(i-1)].
    //  * 
    //  * Recurrence relation:
    //  * sum[i] = max{sum1, sum2}
    //  * sum1 = max{sum[i-1], nums[i-1] + sum[i-2]} where 2 <= i <= N - 1
    //  * sum2 = max{sum[i-1], nums[i-1] + sum[i-2]} where 2 <= i <= N
    //  * sum[0] = 0
    //  * sum[1] = 0
    //  * 
    //  * Time complexity:
    //  * O(N)
    //  */
    // private int rob(int[] nums, int start, int end) {
    //     int N = end - start + 1;
    //     int[] sum = new int[N + 1];
    //     sum[start + 1] = nums[start];
    //     for (int i = start + 2; i <= end; ++i) {
    //         sum[i] = Math.max(sum[i - 1], nums[i - 1] + sum[i - 2]);
    //     }
    //     return sum[end];
    // }

    /**
     * Space optimization.
     */
    private int rob(int[] nums, int start, int end) {
        int pre = 0, cur = nums[start], prepre;
        for (int i = start + 2; i <= end; ++i) {
            prepre = pre;
            pre = cur;
            cur = Math.max(pre, nums[i - 1] + prepre);
        }
        return cur;
    }
}
// @lc code=end

