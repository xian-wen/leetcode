/*
 * @lc app=leetcode id=172 lang=java
 *
 * [172] Factorial Trailing Zeroes
 *
 * https://leetcode.com/problems/factorial-trailing-zeroes/description/
 *
 * algorithms
 * Medium (42.05%)
 * Likes:    2530
 * Dislikes: 1805
 * Total Accepted:    357.5K
 * Total Submissions: 849.7K
 * Testcase Example:  '3'
 *
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: n = 0
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= n <= 10^4
 * 
 * 
 * 
 * Follow up: Could you write a solution that works in logarithmic time
 * complexity?
 * 
 */

// @lc code=start
class Solution {
    /**
     * 2 * 5 makes trailing zeros, thus count # 2s and # 5s, then take the
     * minimum of them. Since # 2s >> # 5s, only counting # 5s is enough.
     */
    public int trailingZeroes(int n) {
        if (n == 0) {
            return 0;
        }

        return n / 5 + trailingZeroes(n / 5);
    }
}
// @lc code=end

