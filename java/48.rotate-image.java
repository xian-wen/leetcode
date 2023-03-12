import java.util.Arrays;

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
    // /**
    //  * Solution 1:
    //  * 
    //  * First transform the matrix, then reverse all its columns.
    //  */
    // public void rotate(int[][] matrix) {
    //     transform(matrix);
    //     reverseColumns(matrix);
    // }

    // private void transform(int[][] matrix) {
    //     int N = matrix.length;
    //     for (int row = 0; row < N; ++row) {
    //         for (int col = row + 1; col < N; ++col) {
    //             swap2D(matrix, row, col, col, row);
    //         }
    //     }
    // }

    // private void swap2D(int[][] matrix, int row1, int col1, int row2, int col2) {
    //     int temp = matrix[row1][col1];
    //     matrix[row1][col1] = matrix[row2][col2];
    //     matrix[row2][col2] = temp;
    // }

    // private void reverseColumns(int[][] matrix) {
    //     for (int[] row : matrix) {
    //         reverse(row);
    //     }
    // }

    // private void reverse(int[] nums) {
    //     int left = 0, right = nums.length - 1;
    //     while (left < right) {
    //         swap(nums, left++, right--);
    //     }
    // }

    // private void swap(int[] nums, int i, int j) {
    //     int temp = nums[i];
    //     nums[i] = nums[j];
    //     nums[j] = temp;
    // }

    /**
     * Solution 2:
     * 
     * Rotating the matrix 90 degrees is equivalent to swap four points:
     * matrix[r][c], matrix[c][N-1-r], matrix[N-1-r][N-1-c], matrix[N-1-c][r].
     */
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        for (int row = 0; row < N / 2; ++row) {
            for (int col = row; col < N - 1 - row; ++col) {
                int row2 = col, col2 = N - 1 - row;
                int row3 = N - 1 - row, col3 = N - 1 - col;
                int row4 = N - 1 - col, col4 = row;
                swap(matrix, row, col, row2, col2, row3, col3, row4, col4);
            }
        }
    }

    /**
     * Swap matrix[r1][c1], matrix[r2][c2], matrix[r3][c3], and matrix[r4][c4]
     * so that ABCD becomes DABC.
     */
    private void swap(int[][] matrix, int row1, int col1, int row2, int col2, 
                      int row3, int col3, int row4, int col4) {
        int temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row4][col4];
        matrix[row4][col4] = matrix[row3][col3];
        matrix[row3][col3] = matrix[row2][col2];
        matrix[row2][col2] = temp;
    }
}
// @lc code=end

