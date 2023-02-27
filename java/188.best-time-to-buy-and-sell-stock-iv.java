/*
 * @lc app=leetcode id=188 lang=java
 *
 * [188] Best Time to Buy and Sell Stock IV
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
 *
 * algorithms
 * Hard (38.62%)
 * Likes:    6156
 * Dislikes: 195
 * Total Accepted:    346.2K
 * Total Submissions: 894.5K
 * Testcase Example:  '2\n[2,4,1]'
 *
 * You are given an integer array prices where prices[i] is the price of a
 * given stock on the i^th day, and an integer k.
 * 
 * Find the maximum profit you can achieve. You may complete at most k
 * transactions.
 * 
 * Note: You may not engage in multiple transactions simultaneously (i.e., you
 * must sell the stock before you buy again).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: k = 2, prices = [2,4,1]
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit
 * = 4-2 = 2.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: k = 2, prices = [3,2,6,5,0,3]
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit
 * = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3),
 * profit = 3-0 = 3.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= k <= 100
 * 1 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 * 
 * 
 */

// @lc code=start
class Solution {
    public int maxProfit(int k, int[] prices) {
        // profit[t][0]: the minimum cost using <= t transactions.
        // profit[t][1]: the maximum profit using <= t transactions.
        int[][] profit = new int[k + 1][2];
        for (int t = 0; t <= k; ++t) {
            profit[t][0] = Integer.MAX_VALUE;
        }

        for (int price : prices) {
            for (int t = 1; t <= k; ++t) {
                // Minimum cost = current price - previous profit.
                profit[t][0] = Math.min(profit[t][0], price - profit[t - 1][1]);
                // Maximum profit = current price - minimum cost.
                profit[t][1] = Math.max(profit[t][1], price - profit[t][0]);
            }
        }
        return profit[k][1];
    }
}
// @lc code=end

