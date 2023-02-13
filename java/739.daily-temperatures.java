import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 *
 * https://leetcode.com/problems/daily-temperatures/description/
 *
 * algorithms
 * Medium (66.34%)
 * Likes:    10103
 * Dislikes: 233
 * Total Accepted:    575.3K
 * Total Submissions: 867.2K
 * Testcase Example:  '[73,74,75,71,69,72,76,73]'
 *
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to
 * wait after the i^th day to get a warmer temperature. If there is no future
 * day for which this is possible, keep answer[i] == 0 instead.
 * 
 * 
 * Example 1:
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * Example 2:
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * Example 3:
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= temperatures.length <= 10^5
 * 30 <= temperatures[i] <= 100
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * Store the indices not temperatures in the stack. The temperatures at each 
     * index should be in monotonically decreasing order, i.e., temperature at 
     * the top index should be the minimum in the stack.
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int N = temperatures.length;
        int[] res = new int[N];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < N; ++i) {
            while (!stack.isEmpty()) {
                int top = stack.peek();
                if (temperatures[i] <= temperatures[top]) {
                    break;
                }
                
                stack.pop();
                res[top] = i - top;
            }

            stack.push(i);
        }
        return res;
    }
}
// @lc code=end

