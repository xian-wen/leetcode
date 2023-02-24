/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 *
 * https://leetcode.com/problems/perfect-squares/description/
 *
 * algorithms
 * Medium (52.61%)
 * Likes:    9114
 * Dislikes: 394
 * Total Accepted:    646.3K
 * Total Submissions: 1.2M
 * Testcase Example:  '12'
 *
 * Given an integer n, return the least number of perfect square numbers that
 * sum to n.
 * 
 * A perfect square is an integer that is the square of an integer; in other
 * words, it is the product of some integer with itself. For example, 1, 4, 9,
 * and 16 are perfect squares while 3 and 11 are not.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * Similar to Knapsack with repetition.
     * 
     * Subproblem:
     * count[i] = the least number of perfect square numbers that sum to i.
     * 
     * Recursive relation:
     * count[i] = min{1 + count(i - j*j)} where 1 <= j*j <= i 
     * count[0] = 0
     * 
     * Time complexity:
     * O(n*sqrt(n))
     */
    public int numSquares(int n) {
        int[] count = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            // There are at most n perfect square numbers, i.e., n 1's.
            count[i] = n;
            for (int j = 1; j * j <= i; ++j) {
                count[i] = Math.min(count[i], 1 + count[i - j * j]);
            }
        }
        return count[n];
    }
}
// @lc code=end

