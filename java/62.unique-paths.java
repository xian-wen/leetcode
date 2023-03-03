/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 *
 * https://leetcode.com/problems/unique-paths/description/
 *
 * algorithms
 * Medium (62.55%)
 * Likes:    13132
 * Dislikes: 375
 * Total Accepted:    1.3M
 * Total Submissions: 2.1M
 * Testcase Example:  '3\n7'
 *
 * There is a robot on an m x n grid. The robot is initially located at the
 * top-left corner (i.e., grid[0][0]). The robot tries to move to the
 * bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move
 * either down or right at any point in time.
 * 
 * Given the two integers m and n, return the number of possible unique paths
 * that the robot can take to reach the bottom-right corner.
 * 
 * The test cases are generated so that the answer will be less than or equal
 * to 2 * 10^9.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: m = 3, n = 7
 * Output: 28
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation: From the top-left corner, there are a total of 3 ways to reach
 * the bottom-right corner:
 * 1. Right -> Down -> Down
 * 2. Down -> Down -> Right
 * 3. Down -> Right -> Down
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= m, n <= 100
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Subproblem:
    //  * paths[i][j] = the possible unique paths moving from top-left corner to 
    //  * position (i, j).
    //  * 
    //  * Recurrence relation:
    //  * paths[i][j] = paths[i-1][j] + paths[i][j-1]
    //  * paths[i][0] = 1
    //  * paths[0][j] = 1
    //  * 
    //  * Time complexity:
    //  * O(mn)
    //  */
    // public int uniquePaths(int m, int n) {
    //     int[][] paths = new int[m][n];
    //     for (int i = 0; i < m; ++i) {
    //         for (int j = 0; j < n; ++j) {
    //             if (i == 0 || j == 0) {
    //                 paths[i][j] = 1;
    //             } else {
    //                 paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
    //             }
    //         }
    //     }
    //     return paths[m - 1][n - 1];
    // }

    /**
     * Space optimization.
     */
    public int uniquePaths(int m, int n) {
        int[] paths = new int[n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || j == 0) {
                    paths[j] = 1;
                } else {
                    // paths[j]: up, paths[j-1]: left
                    paths[j] = paths[j] + paths[j - 1];
                }
            }
        }
        return paths[n - 1];
    }
}
// @lc code=end

