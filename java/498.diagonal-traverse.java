import java.util.Arrays;

/*
 * @lc app=leetcode id=498 lang=java
 *
 * [498] Diagonal Traverse
 *
 * https://leetcode.com/problems/diagonal-traverse/description/
 *
 * algorithms
 * Medium (45.10%)
 * Total Accepted:    39.5K
 * Total Submissions: 87.4K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given a matrix of M x N elements (M rows, N columns), return all elements of
 * the matrix in diagonal order as shown in the below image.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * 
 * Output:  [1,2,4,7,5,3,6,8,9]
 * 
 * Explanation:
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * The total number of elements of the given matrix will not exceed 10,000.
 * 
 */
class Solution {
    // /**
    //  * Solution 1
    //  */
    // public int[] findDiagonalOrder(int[][] mat) {
    //     int M = mat.length, N = mat[0].length, i = 0;
    //     int[] res = new int[M * N];
    //     for (int diagSum = 0; diagSum < M + N - 1; ++diagSum) {
    //         for (int r = 0; r <= diagSum; ++r) {
    //             int row = r;
    //             int col = diagSum - r;
    //             if (diagSum % 2 == 0) {
    //                 int temp = row;
    //                 row = col;
    //                 col = temp;
    //             }

    //             if (row >= M || col >= N) {
    //                 continue;
    //             }

    //             res[i++] = mat[row][col];
    //         }
    //     }
    //     return res;
    // }

    /**
     * Solution 2
     */
    public int[] findDiagonalOrder(int[][] mat) {
        int M = mat.length, N = mat[0].length, row = 0, col = 0;
        int[] res = new int[M * N];
        for (int i = 0; i < res.length; ++i) {
            res[i] = mat[row][col];
            if ((row + col) % 2 == 0) {  // Move up
                // The order matters!!!
                // When row = 0 and col = N - 1, move to the next row.
                if (col == N - 1) {
                    ++row;
                } else if (row == 0) {
                    ++col;
                } else {
                    --row;
                    ++col;
                }
            } else {  // Move down
                // The order matters!!!
                // When row = M - 1 and col = 0, move to the next col.
                if (row == M - 1) {
                    ++col;
                } else if (col == 0) {
                    ++row;
                } else {
                    ++row;
                    --col;
                }
            }
        }
        return res;
    }
}
