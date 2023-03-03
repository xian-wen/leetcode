/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 *
 * https://leetcode.com/problems/maximum-product-subarray/description/
 *
 * algorithms
 * Medium (34.89%)
 * Likes:    15259
 * Dislikes: 457
 * Total Accepted:    958.8K
 * Total Submissions: 2.7M
 * Testcase Example:  '[2,3,-2,4]'
 *
 * Given an integer array nums, find a subarray that has the largest product,
 * and return the product.
 * 
 * The test cases are generated so that the answer will fit in a 32-bit
 * integer.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 2 * 10^4
 * -10 <= nums[i] <= 10
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer.
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Subproblem:
    //  * max[i] = the largest product in nums[0..(i-1)] including nums[i-1].
    //  * min[i] = the smallest product in nums[0..(i-1)] including nums[i-1].
    //  * 
    //  * Recurrence relation:
    //  * max[i] = max{nums[i-1], nums[i-1] * max[i-1]} if nums[i-1] > 0
    //  *        = max{nums[i-1], nums[i-1] * min[i-1]} if nums[i-1] < 0
    //  * min[i] = min{nums[i-1], nums[i-1] * min[i-1]} if nums[i-1] > 0
    //  *        = min{nums[i-1], nums[i-1] * max[i-1]} if nums[i-1] < 0
    //  * max[0] = 1
    //  * min[0] = 1
    //  * 
    //  * Time complexity:
    //  * O(N)
    //  */
    // public int maxProduct(int[] nums) {
    //     int N = nums.length;
    //     int[] max = new int[N + 1], min = new int[N + 1];
    //     max[0] = 1; 
    //     min[0] = 1;
    //     int maxProduct = Integer.MIN_VALUE;
    //     for (int i = 1; i <= N; ++i) {
    //         if (nums[i - 1] > 0) {
    //             max[i] = Math.max(nums[i - 1], nums[i - 1] * max[i - 1]);
    //             min[i] = Math.min(nums[i - 1], nums[i - 1] * min[i - 1]);
    //         } else {
    //             max[i] = Math.max(nums[i - 1], nums[i - 1] * min[i - 1]);
    //             min[i] = Math.min(nums[i - 1], nums[i - 1] * max[i - 1]);
    //         }

    //         maxProduct = Math.max(maxProduct, max[i]);
    //     }
    //     return maxProduct;
    // }

    /**
     * Space optimization.
     */
    public int maxProduct(int[] nums) {
        int max = 1, min = 1, maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(nums[i], nums[i] * max);
            min = Math.min(nums[i], nums[i] * min);
            maxProduct = Math.max(maxProduct, max);
        }
        return maxProduct;
    }
}
// @lc code=end

