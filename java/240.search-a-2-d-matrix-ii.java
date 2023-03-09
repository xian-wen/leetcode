/*
 * @lc app=leetcode id=240 lang=java
 *
 * [240] Search a 2D Matrix II
 *
 * https://leetcode.com/problems/search-a-2d-matrix-ii/description/
 *
 * algorithms
 * Medium (50.88%)
 * Likes:    9948
 * Dislikes: 167
 * Total Accepted:    761.7K
 * Total Submissions: 1.5M
 * Testcase Example:  '[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]\n' +
  '5'
 *
 * Write an efficient algorithm that searches for a value target in an m x n
 * integer matrix matrix. This matrix has the following properties:
 * 
 * 
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix =
 * [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]],
 * target = 5
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: matrix =
 * [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]],
 * target = 20
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -10^9 <= matrix[i][j] <= 10^9
 * All the integers in each row are sorted in ascending order.
 * All the integers in each column are sorted in ascending order.
 * -10^9 <= target <= 10^9
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Recursion.
    //  */
    // public boolean searchMatrix(int[][] matrix, int target) {
    //     return searchMatrix(matrix, target, 0, matrix[0].length - 1);
    // }

    // private boolean searchMatrix(int[][] matrix, int target, int row, int col) {
    //     if (!isValid(matrix, row, col)) {
    //         return false;
    //     }

    //     if (target == matrix[row][col]) {
    //         return true;
    //     }

    //     if (target > matrix[row][col]) {
    //         return searchMatrix(matrix, target, row + 1, col);
    //     }
    //     return searchMatrix(matrix, target, row, col - 1);
    // }

    // private boolean isValid(int[][] matrix, int row, int col) {
    //     int M = matrix.length, N = matrix[0].length;
    //     return row >= 0 && row < M && col >= 0 && col < N;
    // }

    /**
     * Solution 2: Iteration.
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int M = matrix.length, N = matrix[0].length;
        int row = 0, col = N - 1;
        while (row < M && col >= 0) {
            if (target == matrix[row][col]) {
                return true;
            }

            if (target > matrix[row][col]) {
                ++row;
            } else {
                --col;
            }
        }
        return false;
    }
}
// @lc code=end

