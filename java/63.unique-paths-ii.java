/*
 * @lc app=leetcode id=63 lang=java
 *
 * [63] Unique Paths II
 *
 * https://leetcode.com/problems/unique-paths-ii/description/
 *
 * algorithms
 * Medium (39.31%)
 * Likes:    6668
 * Dislikes: 431
 * Total Accepted:    656.7K
 * Total Submissions: 1.7M
 * Testcase Example:  '[[0,0,0],[0,1,0],[0,0,0]]'
 *
 * You are given an m x n integer array grid. There is a robot initially
 * located at the top-left corner (i.e., grid[0][0]). The robot tries to move
 * to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only
 * move either down or right at any point in time.
 * 
 * An obstacle and space are marked as 1 or 0 respectively in grid. A path that
 * the robot takes cannot include any square that is an obstacle.
 * 
 * Return the number of possible unique paths that the robot can take to reach
 * the bottom-right corner.
 * 
 * The testcases are generated so that the answer will be less than or equal to
 * 2 * 10^9.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: 2
 * Explanation: There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: obstacleGrid = [[0,1],[0,0]]
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] is 0 or 1.
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * Subproblem:
     * path[i][j] = the number of unique paths from top-left to obstacleGrid[i][j].
     * 
     * Recurrence relation:
     * path[i][j] = path[i-1][j] + path[i][j-1] if obstacleGrid[i][j] = 0
     *            = 0                           if obstacleGrid[i][j] = 1
     * path[i][0] = 1 if obstacleGrid[i][0] = 0
     * path[i..M][0] = 0 if obstacleGrid[i][0] = 1
     * path[0][j] = 1 if obstacleGrid[0][j] = 0
     * path[0][j..N] = 0 if obstacleGrid[0][j] = 1
     * 
     * Time complexity:
     * O(MN)
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int M = obstacleGrid.length, N = obstacleGrid[0].length;
        int[][] path = new int[M][N];
        for (int i = 0; i < M; ++i) {
            if (obstacleGrid[i][0] == 1) {
                // By default, path[i][0] = 0.
                break;
            } else {
                path[i][0] = 1;
            }
        }
        
        for (int j = 0; j < N; ++j) {
            if (obstacleGrid[0][j] == 1) {
                // By default, path[0][j] = 0.
                break;
            } else {
                path[0][j] = 1;
            }
        }

        for (int i = 1; i < M; ++i) {
            for (int j = 1; j < N; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    path[i][j] = 0;
                } else {
                    path[i][j] = path[i - 1][j] + path[i][j - 1];
                }
            }
        }
        return path[M - 1][N - 1];
    }
}
// @lc code=end

