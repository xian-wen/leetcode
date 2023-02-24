/*
 * @lc app=leetcode id=542 lang=java
 *
 * [542] 01 Matrix
 *
 * https://leetcode.com/problems/01-matrix/description/
 *
 * algorithms
 * Medium (44.54%)
 * Likes:    6644
 * Dislikes: 316
 * Total Accepted:    359.1K
 * Total Submissions: 805.1K
 * Testcase Example:  '[[0,0,0],[0,1,0],[0,0,0]]'
 *
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for
 * each cell.
 * 
 * The distance between two adjacent cells is 1.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
 * Output: [[0,0,0],[0,1,0],[1,2,1]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 10^4
 * 1 <= m * n <= 10^4
 * mat[i][j] is either 0 or 1.
 * There is at least one 0 in mat.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int M = mat.length, N = mat[0].length;
        int[][] dist = new int[M][N];
        // All distances are <= M + N - 2, which is the distance between two 
        // cells at the diagonally corners, e.g., distance between top left 
        // and bottom right.
        int maxDistance = M + N;
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                if (mat[i][j] != 0) {
                    dist[i][j] = maxDistance;
                    if (i > 0) {
                        dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                    }
                    
                    if (j > 0) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                    }
                }
            }
        }

        for (int i = M - 1; i >= 0; --i) {
            for (int j = N - 1; j >= 0; --j) {
                if (mat[i][j] != 0) {
                    if (i < M - 1) {
                        dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                    }
                    
                    if (j < N - 1) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
                    }
                }
            }
        }
        return dist;
    }
}
// @lc code=end

