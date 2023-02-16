/*
 * @lc app=leetcode id=338 lang=java
 *
 * [338] Counting Bits
 *
 * https://leetcode.com/problems/counting-bits/description/
 *
 * algorithms
 * Easy (75.60%)
 * Likes:    8433
 * Dislikes: 403
 * Total Accepted:    732.6K
 * Total Submissions: 968.8K
 * Testcase Example:  '2'
 *
 * Given an integer n, return an array ans of length n + 1 such that for each i
 * (0 <= i <= n), ans[i] is the number of 1's in the binary representation of
 * i.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 2
 * Output: [0,1,1]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= n <= 10^5
 * 
 * 
 * 
 * Follow up:
 * 
 * 
 * It is very easy to come up with a solution with a runtime of O(n log n). Can
 * you do it in linear time O(n) and possibly in a single pass?
 * Can you do it without using any built-in function (i.e., like
 * __builtin_popcount in C++)?
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * Subproblem:
     * count[i] = # 1s in binary i.
     * 
     * Recursive relation:
     * count[i] = count[i - 1] if LSB(i) = 1
     *          = count[i >> 1] if LSB(i) = 0
     * where LSB = i & 1
     * count[0] = 0
     * 
     * e.g., 
     * count[0b1001] = count[0b1000] + 1
     * count[0b1010] = count[0b101]
     * 
     * Time complexity:
     * O(n)
     */
    public int[] countBits(int n) {
        int[] count = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            int last = i & 1;
            if (last == 1) {
                count[i] = count[i - 1] + 1;
            } else {
                count[i] = count[i >> 1];
            }
        }
        return count;
    }
}
// @lc code=end

