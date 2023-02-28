import java.util.Arrays;

/*
 * @lc app=leetcode id=85 lang=java
 *
 * [85] Maximal Rectangle
 *
 * https://leetcode.com/problems/maximal-rectangle/description/
 *
 * algorithms
 * Hard (44.54%)
 * Likes:    8282
 * Dislikes: 133
 * Total Accepted:    336.3K
 * Total Submissions: 754K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest
 * rectangle containing only 1's and return its area.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix =
 * [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 6
 * Explanation: The maximal rectangle is shown in the above picture.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: matrix = [["0"]]
 * Output: 0
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: matrix = [["1"]]
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * rows == matrix.length
 * cols == matrix[i].length
 * 1 <= row, cols <= 200
 * matrix[i][j] is '0' or '1'.
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Dynamic Programming
    //  * 
    //  * Subproblem:
    //  * height[i][j] = the largest height for column[j] at row[i].
    //  * left[i][j] = the index of the first column (from left) whose height < height[i][j].
    //  * right[i][j] = the index of the first column (from right) whose height < height[i][j].
    //  * 
    //  * Recursive relation:
    //  * height[i][j] = height[i - 1][j] + 1 if matrix[i][j] == '1'
    //  *              = 0
    //  * left[i][j] = left[i][k] where height[i][k] first < height[i][j]
    //  * right[i][j] = right[i][k] where height[i][j] first < height[i][j]
    //  * 
    //  * Time complexity:
    //  * O(MN)
    //  */
    // public int maximalRectangle(char[][] matrix) {
    //     int M = matrix.length, N = matrix[0].length;
    //     int[] height = new int[N], left = new int[N], right = new int[N];
    //     int maxArea = 0;
    //     for (int i = 0; i < M; ++i) {
    //         for (int j = 0; j < N; ++j) {
    //             if (matrix[i][j] == '1') {
    //                 ++height[j];
    //             } else {
    //                 height[j] = 0;
    //             }
    //         }

    //         left[0] = -1;
    //         for (int j = 1; j < N; ++j) {
    //             int k = j - 1;
    //             while (k >= 0 && height[k] >= height[j]) {
    //                 k = left[k];
    //             }
                
    //             left[j] = k;
    //         }

    //         right[N - 1] = N;
    //         for (int j = N - 2; j >= 0; --j) {
    //             int k = j + 1;
    //             while (k < N && height[k] >= height[j]) {
    //                 k = right[k];
    //             }
                
    //             right[j] = k;
    //         }
            
    //         for (int j = 0; j < N; ++j) {
    //             int h = height[j];
    //             int w = right[j] - left[j] - 1;
    //             maxArea = Math.max(maxArea, w * h);
    //         }
    //     }
    //     return maxArea;
    // }    

    /**
     * Solution 2: LeetCode 84
     */
    public int maximalRectangle(char[][] matrix) {
        int M = matrix.length, N = matrix[0].length;
        int[] heights = new int[N];
        int maxArea = 0;
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                if (matrix[i][j] == '1') {
                    ++heights[j];
                } else {
                    heights[j] = 0;
                }
            }

            maxArea = Math.max(maxArea, largestRectangleInHistogram(heights));
        }
        return maxArea;
    }

    /**
     * Ref: LeetCode 84.
     */
    private int largestRectangleInHistogram(int[] heights) {
        int N = heights.length;
        int[] left = new int[N];
        left[0] = -1;
        for (int i = 1; i < N; ++i) {
            int j = i - 1;
            while (j >= 0 && heights[j] >= heights[i]) {
                j = left[j];
            }

            left[i] = j;
        }

        int[] right = new int[N];
        right[N - 1] = N;
        for (int i = N - 2; i >= 0; --i) {
            int j = i + 1;
            while (j < N && heights[j] >= heights[i]) {
                j = right[j];
            }

            right[i] = j; 
        }

        int maxArea = 0;
        for (int i = 0; i < N; ++i) {
            int height = heights[i];
            int width = right[i] - left[i] - 1;
            maxArea = Math.max(maxArea, width * height);
        }
        return maxArea;
    }
}
// @lc code=end

