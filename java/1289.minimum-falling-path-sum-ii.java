/*
 * @lc app=leetcode id=1289 lang=java
 *
 * [1289] Minimum Falling Path Sum II
 *
 * https://leetcode.com/problems/minimum-falling-path-sum-ii/description/
 *
 * algorithms
 * Hard (58.66%)
 * Likes:    1352
 * Dislikes: 77
 * Total Accepted:    40.2K
 * Total Submissions: 68.8K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given an n x n integer matrix grid, return the minimum sum of a falling path
 * with non-zero shifts.
 * 
 * A falling path with non-zero shifts is a choice of exactly one element from
 * each row of grid such that no two elements chosen in adjacent rows are in
 * the same column.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: arr = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: 13
 * Explanation: 
 * The possible falling paths are:
 * [1,5,9], [1,5,7], [1,6,7], [1,6,8],
 * [2,4,8], [2,4,9], [2,6,7], [2,6,8],
 * [3,4,8], [3,4,9], [3,5,7], [3,5,9]
 * The falling path with the smallest sum is [1,5,7], so the answer is 13.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: grid = [[7]]
 * Output: 7
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == grid.length == grid[i].length
 * 1 <= n <= 200
 * -99 <= grid[i][j] <= 99
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Prefix Min and Suffix Min
    //  */
    // public int minFallingPathSum(int[][] grid) {
    //     int N = grid.length, minSum = Integer.MAX_VALUE;
    //     for (int row = 0; row < N; ++row) {
    //         int[] prefixMin = null, suffixMin = null;
    //         if (row > 0) {
    //             prefixMin = prefixMin(grid, row - 1);
    //             suffixMin = suffixMin(grid, row - 1);
    //         }

    //         for (int col = 0; col < N; ++col) {
    //             if (row > 0) {
    //                 grid[row][col] += Math.min(prefixMin[col], suffixMin[col]);
    //             }

    //             if (row == N - 1) {
    //                 minSum = Math.min(minSum, grid[row][col]);
    //             }
    //         }
    //     }
    //     return minSum;
    // }

    // private int[] prefixMin(int[][] grid, int row) {
    //     int N = grid.length;
    //     int[] res = new int[N];
    //     res[0] = Integer.MAX_VALUE;
    //     for (int col = 1; col < N; ++col) {
    //         res[col] = Math.min(res[col - 1], grid[row][col - 1]);
    //     }
    //     return res;
    // }

    // private int[] suffixMin(int[][] grid, int row) {
    //     int N = grid.length;
    //     int[] res = new int[N];
    //     res[N - 1] = Integer.MAX_VALUE;
    //     for (int col = N - 2; col >= 0; --col) {
    //         res[col] = Math.min(res[col + 1], grid[row][col + 1]);
    //     }
    //     return res;
    // }

    /**
     * Solution 2: Two Mins
     * 
     * Can also use priority queue to poll two times to get the two mins.
     */
    public int minFallingPathSum(int[][] grid) {
        int N = grid.length, minSum = Integer.MAX_VALUE;
        for (int row = 0; row < N; ++row) {
            int[] mins = null;
            if (row > 0) {
                mins = twoMins(grid, row - 1);
            }

            for (int col = 0; col < N; ++col) {
                if (row > 0) {
                    if (grid[row - 1][col] == mins[0]) {
                        grid[row][col] += mins[1];
                    } else {
                        grid[row][col] += mins[0];
                    }
                }

                if (row == N - 1) {
                    minSum = Math.min(minSum, grid[row][col]);
                }
            }
        }
        return minSum;
    }

    private int[] twoMins(int[][] grid, int row) {
        int N = grid.length, first = Integer.MAX_VALUE, second = 0;
        for (int col = 0; col < N; ++col) {
            if (grid[row][col] < first) {
                second = first;
                first = grid[row][col];
            } else if (grid[row][col] < second) {
                second = grid[row][col];
            }
        }
        return new int[] {first, second};
    }
}
// @lc code=end

