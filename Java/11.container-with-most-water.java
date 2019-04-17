/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 *
 * https://leetcode.com/problems/container-with-most-water/description/
 *
 * algorithms
 * Medium (42.97%)
 * Total Accepted:    347.8K
 * Total Submissions: 795.8K
 * Testcase Example:  '[1,8,6,2,5,4,8,3,7]'
 *
 * Given n non-negative integers a1, a2, ..., an , where each represents a
 * point at coordinate (i, ai). n vertical lines are drawn such that the two
 * endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together
 * with x-axis forms a container, such that the container contains the most
 * water.
 * 
 * Note: You may not slant the container and n is at least 2.
 * 
 * 
 * 
 * 
 * 
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In
 * this case, the max area of water (blue section) the container can contain is
 * 49. 
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * 
 */

/* 
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 1; i < height.length; ++i) {
            for (int j = 0; j < i; ++j) {
                int area = Math.min(height[i], height[j]) * (i - j);
                if (area > maxArea)
                    maxArea = area;
            }
        }
        return maxArea;
    }
}
 */

class Solution {
    public int maxArea(int[] height) {
        int low = 0, high = height.length - 1, maxArea = 0;

        while(low <= high) {
            maxArea = Math.max(maxArea, Math.min(height[low], height[high]) * (high - low));
            // move the higher
            if (height[low] < height[high]) ++low;
            else --high;
        }

        return maxArea;
    }
}
