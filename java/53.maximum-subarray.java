/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 *
 * https://leetcode.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Medium (50.15%)
 * Likes:    28313
 * Dislikes: 1250
 * Total Accepted:    3M
 * Total Submissions: 6M
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * Given an integer array nums, find the subarray with the largest sum, and
 * return its sum.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 
 * 
 * 
 * Follow up: If you have figured out the O(n) solution, try coding another
 * solution using the divide and conquer approach, which is more subtle.
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Subproblem:
    //  * sum[i] = the largest sum of nums[0..(i-1)] including nums[i-1].
    //  * 
    //  * Recursive relation:
    //  * sum[i] = nums[i-1] + max{0, sum[i-1]}
    //  * sum[0] = 0
    //  * 
    //  * Time complexity:
    //  * O(N)
    //  */
    // public int maxSubArray(int[] nums) {
    //     int N = nums.length;
    //     int[] sum = new int[N + 1];
    //     int max = Integer.MIN_VALUE;
    //     for (int i = 1; i <= N; ++i) {
    //         sum[i] = nums[i - 1] + Math.max(0, sum[i - 1]);
    //         max = Math.max(max, sum[i]);
    //     }
    //     return max;
    // }

    /**
     * Space optimization.
     */
    public int maxSubArray(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum = num + Math.max(0, sum);
            max = Math.max(max, sum);
        }
        return max;
    }
}
// @lc code=end

