/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 *
 * https://leetcode.com/problems/target-sum/description/
 *
 * algorithms
 * Medium (45.62%)
 * Likes:    8878
 * Dislikes: 310
 * Total Accepted:    442K
 * Total Submissions: 968.5K
 * Testcase Example:  '[1,1,1,1,1]\n3'
 *
 * You are given an integer array nums and an integer target.
 * 
 * You want to build an expression out of nums by adding one of the symbols '+'
 * and '-' before each integer in nums and then concatenate all the
 * integers.
 * 
 * 
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1
 * and concatenate them to build the expression "+2-1".
 * 
 * 
 * Return the number of different expressions that you can build, which
 * evaluates to target.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,1,1,1,1], target = 3
 * Output: 5
 * Explanation: There are 5 ways to assign symbols to make the sum of nums be
 * target 3.
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1], target = 1
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * Divide the nums into two groups, P and N, where P stands for the numbers
     * added "+" before them, and N represents the numbers added "-" before.
     * sum(P) - sum(N) = target
     * sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
     * 2*sum(P) = target + sum(nums)
     * sum(P) = (target + sum(nums)) / 2
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // (target + sum) must be even.
        if (target > sum || ((target + sum) & 1) == 1) {
            return 0;
        }

        target = (target + sum) >> 1;
        return target < 0 ? 0 : subsetSum(nums, target);
    }

    /**
     * Similar to Knapsack without repetition (space optimization).
     * 
     * Subproblem:
     * count[t] = the number of different subsets of nums[0..(n-1)] with a total
     * sum = t.
     * 
     * Recurrence relation:
     * count[t] = sum(count[t - nums[i]]) if nums[i] <= t
     * count[0] = 1  // Empty set.
     * 
     * Time complexity:
     * O(N*target)
     */
    private int subsetSum(int[] nums, int target) {
        int[] count = new int[target + 1];
        count[0] = 1;
        for (int num : nums) {
            for (int t = target; t >= num; --t) {
                count[t] += count[t - num];
            }
        }
        return count[target];
    }
}
// @lc code=end

