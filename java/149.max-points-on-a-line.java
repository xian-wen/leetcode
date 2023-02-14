import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=149 lang=java
 *
 * [149] Max Points on a Line
 *
 * https://leetcode.com/problems/max-points-on-a-line/description/
 *
 * algorithms
 * Hard (24.96%)
 * Likes:    3480
 * Dislikes: 405
 * Total Accepted:    329.9K
 * Total Submissions: 1.3M
 * Testcase Example:  '[[1,1],[2,2],[3,3]]'
 *
 * Given an array of points where points[i] = [xi, yi] represents a point on
 * the X-Y plane, return the maximum number of points that lie on the same
 * straight line.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: points = [[1,1],[2,2],[3,3]]
 * Output: 3
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= points.length <= 300
 * points[i].length == 2
 * -10^4 <= xi, yi <= 10^4
 * All the points are unique.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int maxPoints(int[][] points) {
        int N = points.length;
        if (N < 3) {
            return N;
        }

        int max = 0;
        // slope -> count
        Map<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < N; ++i) {
            for (int j = i + 1; j < N; ++j) {
                double slope = slope(points[i], points[j]);
                int count = map.getOrDefault(slope, 0) + 1;
                map.put(slope, count);
                max = Math.max(max, count);
            }
            
            map.clear();
        }

        // # points = # slopes + 1
        return max + 1;
    }

    private double slope(int[] p1, int[] p2) {
        // Infinite slope.
        if (p1[0] == p2[0]) {
            return Double.MAX_VALUE;
        }

        // Zero slope.
        if (p1[1] == p2[1]) {
            return 0;
        }

        return 1.0 * (p2[1] - p1[1]) / (p2[0] - p1[0]);    
    }
}
// @lc code=end

