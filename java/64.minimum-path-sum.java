/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 *
 * https://leetcode.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (60.97%)
 * Likes:    9537
 * Dislikes: 123
 * Total Accepted:    850K
 * Total Submissions: 1.4M
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right, which minimizes the sum of all numbers along its
 * path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Subproblem:
    //  * sum[i][j] = the sum from grid[0][0] to grid[i][j].
    //  * 
    //  * Recursive relation:
    //  * sum[i][j] = grid[i][j] + min{sum[i-1][j], sum[i][j-1]}
    //  * sum[0][0] = grid[0][0]
    //  * sum[i][0] = grid[i][0] + sum[i-1][0]
    //  * sum[0][j] = grid[0][j] + sum[0][j-1] 
    //  * 
    //  * Time complexity:
    //  * O(MN)
    //  */
    // public int minPathSum(int[][] grid) {
    //     int M = grid.length, N = grid[0].length;
    //     int[][] sum = new int[M][N];  
    //     for (int i = 0; i < M; ++i) {
    //         for (int j = 0; j < N; ++j) {
    //             if (i == 0 && j == 0) {
    //                 sum[i][j] = grid[i][j];
    //             } else if (i == 0) {
    //                 sum[i][j] = grid[i][j] + sum[i][j - 1];
    //             } else if (j == 0) {
    //                 sum[i][j] = grid[i][j] + sum[i - 1][j];
    //             } else {
    //                 sum[i][j] = grid[i][j] + Math.min(sum[i - 1][j], sum[i][j - 1]);
    //             }
    //         }
    //     }
    //     return sum[M - 1][N - 1];
    // }

    /**
     * Space optimization.
     */
    public int minPathSum(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[M - 1][N - 1];
    }
}
// @lc code=end

