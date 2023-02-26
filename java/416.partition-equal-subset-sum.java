/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 *
 * https://leetcode.com/problems/partition-equal-subset-sum/description/
 *
 * algorithms
 * Medium (46.36%)
 * Likes:    9923
 * Dislikes: 173
 * Total Accepted:    595K
 * Total Submissions: 1.3M
 * Testcase Example:  '[1,5,11,5]'
 *
 * Given an integer array nums, return true if you can partition the array into
 * two subsets such that the sum of the elements in both subsets is equal or
 * false otherwise.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Subproblem:
    //  * partitionable[i] = whether array can be partitioned using a subset of
    //  * nums[0..(N-1)] with a total sum = i.
    //  * 
    //  * Recursive relation:
    //  * partitionable[i] = OR(partitionable[i - nums[j]]) if nums[j] <= i
    //  * partitionable[0] = true
    //  * 
    //  * Time complexity:
    //  * O(N*half) where N = nums.length, half = sum(nums) / 2
    //  */
    // public boolean canPartition(int[] nums) {
    //     int sum = 0;
    //     for (int num : nums) {
    //         sum += num;
    //     }

    //     // sum must be even.
    //     if ((sum & 1) != 0) {
    //         return false;
    //     }

    //     int half = sum >> 1;
    //     boolean[] partitionable = new boolean[half + 1];
    //     partitionable[0] = true;
    //     for (int num : nums) {
    //         for (int i = half; i >= num; --i) {
    //             partitionable[i] = partitionable[i] || partitionable[i - num];
    //         }
    //     }
    //     return partitionable[half];
    // }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // sum must be even.
        if ((sum & 1) != 0) {
            return false;
        }

        int half = sum >> 1;
        return knapsack(nums, nums, half) == half;
    }

    /**
     * Knapsack without repetition (space compression).
     */
    private int knapsack(int[] values, int[] weights, int B) {
        int[] knapsack = new int[B + 1];
        for (int i = 0; i < values.length; ++i) {
            int v = values[i], w = weights[i];
            for (int b = B; b >= w; --b) {
                knapsack[b] = Math.max(knapsack[b], v + knapsack[b - w]);
            }
        }
        return knapsack[B];
    }
}
// @lc code=end

