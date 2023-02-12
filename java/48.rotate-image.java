/*
 * @lc app=leetcode id=48 lang=java
 *
 * [48] Rotate Image
 *
 * https://leetcode.com/problems/rotate-image/description/
 *
 * algorithms
 * Medium (70.67%)
 * Likes:    13677
 * Dislikes: 631
 * Total Accepted:    1.2M
 * Total Submissions: 1.7M
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * You are given an n x n 2D matrix representing an image, rotate the image by
 * 90 degrees (clockwise).
 * 
 * You have to rotate the image in-place, which means you have to modify the
 * input 2D matrix directly. DO NOT allocate another 2D matrix and do the
 * rotation.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 * 
 * 
 */

// @lc code=start
class Solution {
    private int[][] matrix;

    /**
     * Rotating the matrix 90 degrees is equivalent to swap fout points:
     * matrix[i][j], matrix[j][N-1-i], matrix[N-1-i][N-1-j], matrix[N-1-j][i].
     */
    public void rotate(int[][] matrix) {
        this.matrix = matrix;
        int N = matrix.length;
        for (int i = 0; i < N / 2; ++i) {
            for (int j = i; j < N - 1 - i; ++j) {
                int i2 = j, j2 = N - 1 - i;
                int i3 = N - 1 - i, j3 = N - 1 - j;
                int i4 = N - 1 - j, j4 = i;
                swap(i, j, i2, j2, i3, j3, i4, j4);
            }
        }
    }

    /**
     * Swap matrix[i1][j1], matrix[i2][j2], matrix[i3][j3], and matrix[i4][j4]
     * so that ABCD becomes DABC.
     */
    private void swap(int i1, int j1, int i2, int j2, 
                      int i3, int j3, int i4, int j4) {
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i4][j4];
        matrix[i4][j4] = matrix[i3][j3];
        matrix[i3][j3] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }
}
// @lc code=end

