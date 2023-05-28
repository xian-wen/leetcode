import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 *
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 *
 * algorithms
 * Hard (42.43%)
 * Likes:    13561
 * Dislikes: 192
 * Total Accepted:    641.5K
 * Total Submissions: 1.5M
 * Testcase Example:  '[2,1,5,6,2,3]'
 *
 * Given an array of integers heights representing the histogram's bar height
 * where the width of each bar is 1, return the area of the largest rectangle
 * in the histogram.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The above is a histogram where width of each bar is 1.
 * The largest rectangle is shown in the red area, which has an area = 10
 * units.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: heights = [2,4]
 * Output: 4
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= heights.length <= 10^5
 * 0 <= heights[i] <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Stack
    //  */
    // public int largestRectangleArea(int[] heights) {
    //     Deque<Integer> stack = new ArrayDeque<>();
    //     int N = heights.length, maxArea = 0;
    //     for (int i = 0; i <= N; ++i) {
    //         int curHeight = i < N ? heights[i] : 0;
    //         while (!stack.isEmpty() && curHeight < heights[stack.peek()]) {
    //             int height = heights[stack.pop()];
    //             int width = stack.isEmpty() ? i : i - stack.peek() - 1;
    //             maxArea = Math.max(maxArea, width * height);
    //         }
         
    //         stack.push(i);
    //     }
    //     return maxArea;
    // }

    /**
     * Solution 2: Double Pointers
     */
    public int largestRectangleArea(int[] heights) {
        int N = heights.length;
        // left[i]: index of the first bar (from left) whose height < height 
        // of the current bar.
        int[] left = new int[N];
        left[0] = -1;
        for (int i = 1; i < N; ++i) {
            int j = i - 1;
            while (j >= 0 && heights[j] >= heights[i]) {
                j = left[j];
            }
            
            left[i] = j;
        }
        
        // right[i]: index of the first bar (from right) whose height < height 
        // of the current bar.
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

