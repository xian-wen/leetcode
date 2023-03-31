/*
 * @lc app=leetcode id=931 lang=java
 *
 * [931] Minimum Falling Path Sum
 *
 * https://leetcode.com/problems/minimum-falling-path-sum/description/
 *
 * algorithms
 * Medium (69.12%)
 * Likes:    4595
 * Dislikes: 120
 * Total Accepted:    237.9K
 * Total Submissions: 344.3K
 * Testcase Example:  '[[2,1,3],[6,5,4],[7,8,9]]'
 *
 * Given an n x n array of integers matrix, return the minimum sum of any
 * falling path through matrix.
 * 
 * A falling path starts at any element in the first row and chooses the
 * element in the next row that is either directly below or diagonally
 * left/right. Specifically, the next element from position (row, col) will be
 * (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * Output: 13
 * Explanation: There are two falling paths with a minimum sum as shown.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: matrix = [[-19,57],[-40,-5]]
 * Output: -59
 * Explanation: The falling path with a minimum sum is shown.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 100
 * -100 <= matrix[i][j] <= 100
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int N = matrix.length, minSum = Integer.MAX_VALUE;
        for (int row = 0; row < N; ++row) {
            for (int col = 0; col < N; ++col) {
                if (row > 0) {
                    if (col == 0) {
                        matrix[row][col] += Math.min(matrix[row - 1][col], 
                                matrix[row - 1][col + 1]);
                    } else if (col == N - 1) {
                        matrix[row][col] += Math.min(matrix[row - 1][col - 1], 
                                matrix[row - 1][col]);
                    } else {
                        matrix[row][col] += Math.min(matrix[row - 1][col - 1], 
                                Math.min(matrix[row - 1][col], 
                                         matrix[row - 1][col + 1]));
                    }
                }

                if (row == N - 1) {
                    minSum = Math.min(minSum, matrix[row][col]);
                }
            }
        }
        return minSum;
    }
}
// @lc code=end

