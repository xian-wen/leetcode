/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 *
 * https://leetcode.com/problems/product-of-array-except-self/description/
 *
 * algorithms
 * Medium (64.98%)
 * Likes:    16707
 * Dislikes: 917
 * Total Accepted:    1.6M
 * Total Submissions: 2.4M
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given an integer array nums, return an array answer such that answer[i] is
 * equal to the product of all the elements of nums except nums[i].
 * 
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer.
 * 
 * You must write an algorithm that runs in O(n) time and without using the
 * division operation.
 * 
 * 
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= nums.length <= 10^5
 * -30 <= nums[i] <= 30
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer.
 * 
 * 
 * 
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The
 * output array does not count as extra space for space complexity analysis.)
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Division
    //  */
    // public int[] productExceptSelf(int[] nums) {
    //     int N = nums.length, product = 1, zeros = 0, zeroIndex = 0;
    //     for (int i = 0; i < N; ++i) {
    //         if (nums[i] != 0) {
    //             product *= nums[i];
    //         } else {
    //             if (zeroIndex == 0) {
    //                 zeroIndex = i;
    //             }
    //             ++zeros;
    //         }
    //     }

    //     int[] res = new int[N];
    //     if (zeros > 1) {
    //         return res;
    //     }

    //     if (zeros == 1) {
    //         res[zeroIndex] = product;
    //         return res;
    //     }

    //     for (int i = 0; i < N; ++i) {
    //         res[i] = product / nums[i];
    //     }
    //     return res;
    // }

    // /**
    //  * Solution 2: Prefix and Suffix Product
    //  */
    // public int[] productExceptSelf(int[] nums) {
    //     int N = nums.length;
    //     int[] prefix = new int[N], suffix = new int[N];
    //     prefix[0] = 1;
    //     suffix[N - 1] = 1;
    //     for (int i = 1; i < N; ++i) {
    //         int j = N - 1 - i;
    //         prefix[i] = nums[i - 1] * prefix[i - 1];
    //         suffix[j] = nums[j + 1] * suffix[j + 1]; 
    //     }

    //     int[] res = new int[N];
    //     for (int i = 0; i < N; ++i) {
    //         res[i] = prefix[i] * suffix[i];
    //     }
    //     return res;
    // }

    /**
     * Solution 3: Prefix and Suffix Product (Space Optimization)
     */
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int res[] = new int[N];
        // Prefix product first.
        res[0] = 1;
        for (int i = 1; i < N; ++i) {
            res[i] = nums[i - 1] * res[i - 1];
        }

        int suffix = 1;
        for (int i = N - 1; i >= 0; --i) {
            res[i] *= suffix;
            suffix *= nums[i];
        }
        return res;
    }
}
// @lc code=end

