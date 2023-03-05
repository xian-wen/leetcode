/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 *
 * https://leetcode.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (56.78%)
 * Likes:    19041
 * Dislikes: 424
 * Total Accepted:    2.1M
 * Total Submissions: 3.7M
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and
 * '0's (water), return the number of islands.
 * 
 * An island is surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically. You may assume all four edges of the grid are
 * all surrounded by water.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: grid = [
 * ⁠ ["1","1","1","1","0"],
 * ⁠ ["1","1","0","1","0"],
 * ⁠ ["1","1","0","0","0"],
 * ⁠ ["0","0","0","0","0"]
 * ]
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: grid = [
 * ⁠ ["1","1","0","0","0"],
 * ⁠ ["1","1","0","0","0"],
 * ⁠ ["0","0","1","0","0"],
 * ⁠ ["0","0","0","1","1"]
 * ]
 * Output: 3
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length, count = 0;
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if (grid[row][col] == '1') {
                    dfs(grid, row, col);
                    ++count;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (!isValid(grid, row, col) || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';
        dfs(grid, row + 1, col);  // South.
        dfs(grid, row - 1, col);  // North.
        dfs(grid, row, col + 1);  // East.
        dfs(grid, row, col - 1);  // West.
    }

    private boolean isValid(char[][] grid, int row, int col) {
        int rows = grid.length, cols = grid[0].length;
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}
// @lc code=end

