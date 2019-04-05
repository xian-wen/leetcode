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
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0]; // empty array

        final int M = matrix.length;
        final int N = matrix[0].length;

        int[] res = new int[M * N];
        int index = 0;
        for (int s = 0; s <= M + N - 2; ++s) { // s: diagonal
            for (int x = 0; x <= s; ++x) {
                // for all i + j = s
                int i = x;
                int j = s - x;

                // when s is an even, swap(i, j)               
                if (s % 2 == 0) { // i == i ^ j ^ j
                    i = i ^ j;
                    j = i ^ j;
                    i = i ^ j;
                }

                // pass the overflow
                if (i >= M || j >= N) continue;

                res[index++] = matrix[i][j];
            }
        }
    
        return res;
    }
}

