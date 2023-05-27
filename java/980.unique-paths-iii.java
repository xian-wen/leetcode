/*
 * @lc app=leetcode id=980 lang=java
 *
 * [980] Unique Paths III
 */

// @lc code=start
class Solution {
    public int uniquePathsIII(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        int startRow = 0, startCol = 0, count = 0;
        for (int r = 0; r < M; ++r) {
            for (int c = 0; c < N; ++c) {
                if (grid[r][c] == 0) {
                    ++count;
                } else if (grid[r][c] == 1) {
                    startRow = r;
                    startCol = c;
                    ++count;
                }
            }
        }
        return backtrack(grid, startRow, startCol, count);
    }

    private int backtrack(int[][] grid, int r, int c, int count) {
        if (!isValid(grid, r, c) || grid[r][c] < 0) {
            return 0;
        }

        if (grid[r][c] == 2) {
            return count == 0 ? 1 : 0;
        }

        int res = 0;
        grid[r][c] = -2;
        res += backtrack(grid, r + 1, c, count - 1);
        res += backtrack(grid, r - 1, c, count - 1);
        res += backtrack(grid, r, c + 1, count - 1);
        res += backtrack(grid, r, c - 1, count - 1);
        grid[r][c] = 0;
        return res;
    }

    private boolean isValid(int[][] grid, int r, int c) {
        int M = grid.length, N = grid[0].length;
        return r >= 0 && r < M && c >= 0 && c < N;
    }
}
// @lc code=end

