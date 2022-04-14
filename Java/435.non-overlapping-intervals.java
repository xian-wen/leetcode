import java.util.Arrays;

/*
 * @lc app=leetcode id=435 lang=java
 *
 * [435] Non-overlapping Intervals
 *
 * https://leetcode.com/problems/non-overlapping-intervals/description/
 *
 * algorithms
 * Medium (48.09%)
 * Likes:    3803
 * Dislikes: 110
 * Total Accepted:    237.3K
 * Total Submissions: 493.3K
 * Testcase Example:  '[[1,2],[2,3],[3,4],[1,3]]'
 *
 * Given an array of intervals intervals where intervals[i] = [starti, endi],
 * return the minimum number of intervals you need to remove to make the rest
 * of the intervals non-overlapping.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of the intervals are
 * non-overlapping.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: intervals = [[1,2],[1,2],[1,2]]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of the intervals
 * non-overlapping.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: intervals = [[1,2],[2,3]]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're
 * already non-overlapping.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= intervals.length <= 10^5
 * intervals[i].length == 2
 * -5 * 10^4 <= starti < endi <= 5 * 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // https://stackoverflow.com/questions/5208133/collections-vs-arrays-regarding-sort
        // https://stackoverflow.com/questions/15452429/java-arrays-sort-2d-array
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[1], i2[1]));

        int res = 0;
        int prev = 0;
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] < intervals[prev][1]) {
                ++res;
            } else {
                prev = i;
            }
        }
        return res;
    }
}
// @lc code=end
