import java.util.ArrayList;

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
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new ArrayList<>();
        
        List<Integer> res = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = n - 1, u = 0, d = m - 1; // left, right, up, down
        
        while (true) {
            // up
            for (int col = l; col <= r; ++col)
                res.add(matrix[u][col]);
            if (++u > d) break;

            // right
            for (int row = u; row <= d; ++row)
                res.add(matrix[row][r]);
            if (--r < l) break;

            // down
            for (int col = r; col >= l; --col)
                res.add(matrix[d][col]);
            if (--d < u) break;

            // left
            for (int row = d; row >= u; --row)
                res.add(matrix[row][l]);
            if (++l > r) break;
        }

        return res;
    }
}

