import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 *
 * https://leetcode.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (29.76%)
 * Total Accepted:    219.7K
 * Total Submissions: 733.2K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * 
 * 
 * Example 2:
 * 
 * Input:
 * [
 * ⁠ [1, 2, 3, 4],
 * ⁠ [5, 6, 7, 8],
 * ⁠ [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 */
class Solution {
    // /**
    //  * Solution 1: Iteration
    //  */
    // public List<Integer> spiralOrder(int[][] matrix) {
    //     if (matrix.length == 0) return new ArrayList<>();
        
    //     List<Integer> res = new ArrayList<>();
    //     int m = matrix.length, n = matrix[0].length;
    //     int l = 0, r = n - 1, u = 0, d = m - 1; // left, right, up, down
        
    //     while (true) {
    //         // up
    //         for (int col = l; col <= r; ++col)
    //             res.add(matrix[u][col]);
    //         if (++u > d) break;

    //         // right
    //         for (int row = u; row <= d; ++row)
    //             res.add(matrix[row][r]);
    //         if (--r < l) break;

    //         // down
    //         for (int col = r; col >= l; --col)
    //             res.add(matrix[d][col]);
    //         if (--d < u) break;

    //         // left
    //         for (int row = d; row >= u; --row)
    //             res.add(matrix[row][l]);
    //         if (++l > r) break;
    //     }

    //     return res;
    // }

    /**
     * Solution 2: Recursion
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int M = matrix.length, N = matrix[0].length;
        spiralOrder(matrix, 0, M - 1, 0, N - 1, res);
        return res;
    }

    private void spiralOrder(int[][] matrix, int minRow, int maxRow,
                             int minCol, int maxCol, List<Integer> res) {
        if (minRow > maxRow || minCol > maxCol) {
            return;
        }

        for (int c = minCol; c < maxCol; ++c) {
            res.add(matrix[minRow][c]);
        }

        for (int r = minRow; r < maxRow; ++r) {
            res.add(matrix[r][maxCol]);
        }

        if (minRow == maxRow) {
            res.add(matrix[minRow][maxCol]);
            return;
        }

        for (int c = maxCol; c > minCol; --c) {
            res.add(matrix[maxRow][c]);
        }

        if (minCol == maxCol) {
            res.add(matrix[maxRow][minCol]);
            return;
        }

        for (int r = maxRow; r > minRow; --r) {
            res.add(matrix[r][minCol]);
        }

        spiralOrder(matrix, minRow + 1, maxRow - 1, minCol + 1, maxCol - 1, res);
    }
}
