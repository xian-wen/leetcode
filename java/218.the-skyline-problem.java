import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=218 lang=java
 *
 * [218] The Skyline Problem
 *
 * https://leetcode.com/problems/the-skyline-problem/description/
 *
 * algorithms
 * Hard (41.75%)
 * Likes:    5319
 * Dislikes: 243
 * Total Accepted:    259.1K
 * Total Submissions: 620.6K
 * Testcase Example:  '[[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]'
 *
 * A city's skyline is the outer contour of the silhouette formed by all the
 * buildings in that city when viewed from a distance. Given the locations and
 * heights of all the buildings, return the skyline formed by these buildings
 * collectively.
 * 
 * The geometric information of each building is given in the array buildings
 * where buildings[i] = [lefti, righti, heighti]:
 * 
 * 
 * lefti is the x coordinate of the left edge of the i^th building.
 * righti is the x coordinate of the right edge of the i^th building.
 * heighti is the height of the i^th building.
 * 
 * 
 * You may assume all buildings are perfect rectangles grounded on an
 * absolutely flat surface at height 0.
 * 
 * The skyline should be represented as a list of "key points" sorted by their
 * x-coordinate in the form [[x1,y1],[x2,y2],...]. Each key point is the left
 * endpoint of some horizontal segment in the skyline except the last point in
 * the list, which always has a y-coordinate 0 and is used to mark the
 * skyline's termination where the rightmost building ends. Any ground between
 * the leftmost and rightmost buildings should be part of the skyline's
 * contour.
 * 
 * Note: There must be no consecutive horizontal lines of equal height in the
 * output skyline. For instance, [...,[2 3],[4 5],[7 5],[11 5],[12 7],...] is
 * not acceptable; the three lines of height 5 should be merged into one in the
 * final output as such: [...,[2 3],[4 5],[12 7],...]
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
 * Output: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
 * Explanation:
 * Figure A shows the buildings of the input.
 * Figure B shows the skyline formed by those buildings. The red points in
 * figure B represent the key points in the output list.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: buildings = [[0,2,3],[2,5,3]]
 * Output: [[0,3],[5,0]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= buildings.length <= 10^4
 * 0 <= lefti < righti <= 2^31 - 1
 * 1 <= heighti <= 2^31 - 1
 * buildings is sorted by lefti in non-decreasing order.
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> height = new ArrayList<>();
        for (int[] b : buildings) {
            // Start of the building.
            height.add(new int[]{b[0], -b[2]});
            // End of the building.
            height.add(new int[]{b[1], b[2]});
        }

        // Sort by location first, height second, in descending order.
        Collections.sort(height, (a, b) -> 
                a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        // Sort heights in descending order. Use TreeMap instead of TreeSet for 
        // duplicate heights, and instead of priority queue for removal costs.
        TreeMap<Integer, Integer> map = new TreeMap<>((h1, h2) -> h2 - h1);
        List<List<Integer>> res = new ArrayList<>();
        
        // Zero height for ground, should always be in the map.
        map.put(0, 1);
        int preMax = 0;
        for (int[] h : height) {
            if (h[1] < 0) {
                // Start of the building.
                map.put(-h[1], map.getOrDefault(-h[1], 0) + 1);
            } else {
                // End of the building.
                map.put(h[1], map.get(h[1]) - 1);
                if (map.get(h[1]) == 0) {
                    map.remove(h[1]);
                }
            }

            int curMax = map.firstKey();
            // Current max not equals to previous max, a key point found!
            if (curMax != preMax) {
                res.add(List.of(h[0], curMax));
                preMax = curMax;
            }
        }
        return res;
    }
}
// @lc code=end

