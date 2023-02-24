/*
 * @lc app=leetcode id=221 lang=java
 *
 * [221] Maximal Square
 *
 * https://leetcode.com/problems/maximal-square/description/
 *
 * algorithms
 * Medium (44.81%)
 * Likes:    8558
 * Dislikes: 180
 * Total Accepted:    567.1K
 * Total Submissions: 1.3M
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * Given an m x n binary matrix filled with 0's and 1's, find the largest
 * square containing only 1's and return its area.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix =
 * [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: matrix = [["0","1"],["1","0"]]
 * Output: 1
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: matrix = [["0"]]
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] is '0' or '1'.
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * Subproblem:
     * len[i][j] = the side length of the largest square filled with only 1's 
     * and including matrix[i-1][j-1] as the bottom right corner.
     * 
     * Recursive relation:
     * len[i][j] = 1 + min{len[i-1][j], len[i][j-1], len[i-1][j-1]} if matrix[i-1][j-1] == '1'
     *           = 0                                                otherwise
     * len[i][0] = 0
     * len[0][j] = 0
     * 
     * Time complexity:
     * O(MN)
     */
    public int maximalSquare(char[][] matrix) {
        int M = matrix.length, N = matrix[0].length;
        int[][] len = new int[M + 1][N + 1];
        int maxLen = 0;
        for (int i = 1; i <= M; ++i) {
            for (int j = 1; j <= N; ++j) {
                if (matrix[i - 1][j - 1] == '1') {
                    len[i][j] = 1 + Math.min(len[i - 1][j - 1], 
                            Math.min(len[i - 1][j], len[i][j - 1]));
                    maxLen = Math.max(maxLen, len[i][j]);
                }

            }
        }
        return maxLen * maxLen;
    }
}
// @lc code=end

