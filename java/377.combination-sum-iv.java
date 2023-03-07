/*
 * @lc app=leetcode id=377 lang=java
 *
 * [377] Combination Sum IV
 *
 * https://leetcode.com/problems/combination-sum-iv/description/
 *
 * algorithms
 * Medium (52.15%)
 * Likes:    5539
 * Dislikes: 565
 * Total Accepted:    350K
 * Total Submissions: 671K
 * Testcase Example:  '[1,2,3]\n4'
 *
 * Given an array of distinct integers nums and a target integer target, return
 * the number of possible combinations that add up to target.
 * 
 * The test cases are generated so that the answer can fit in a 32-bit
 * integer.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3], target = 4
 * Output: 7
 * Explanation:
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * Note that different sequences are counted as different combinations.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [9], target = 3
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 1000
 * All the elements of nums are unique.
 * 1 <= target <= 1000
 * 
 * 
 * 
 * Follow up: What if negative numbers are allowed in the given array? How does
 * it change the problem? What limitation we need to add to the question to
 * allow negative numbers?
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Backtracking (Time Limit Exceeded)
    //  */
    // public int combinationSum4(int[] nums, int target) {
    //     return backtrack(nums, 0, target);
    // }

    // private int backtrack(int[] nums, int index, int remain) {
    //     if (remain < 0) {
    //         return 0;
    //     }

    //     if (remain == 0) {
    //         return 1;
    //     }

    //     int res = 0;
    //     for (int i = 0; i < nums.length; ++i) {
    //         res += backtrack(nums, i, remain - nums[i]);
    //     }
    //     return res;
    // }

    /**
     * Similar to Knapsack with repetition (space optimization).
     * 
     * Solution 2: Dynamic Programming
     */
    public int combinationSum4(int[] nums, int target) {
        int[] sum = new int[target + 1];
        sum[0] = 1;
        for (int i = 1; i <= target; ++i) {
            for (int num : nums) {
                if (num <= i) {
                    sum[i] += sum[i - num];
                }
            }
        }
        return sum[target];
    }
}
// @lc code=end

