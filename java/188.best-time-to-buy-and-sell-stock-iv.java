import java.util.Arrays;

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
        // buy[t]: the minimum cost achievable using <= t transactions.
        // sell[t]: the maximum profit achievable using <= t transactions.
        int[] buy = new int[k + 1], sell = new int[k + 1];
        Arrays.fill(buy, Integer.MAX_VALUE);
        for (int price : prices) {
            for (int t = 1; t <= k; ++t) {
                // Minimum cost = current price - previous profit.
                buy[t] = Math.min(buy[t], price - sell[t - 1]);
                // Maximum profit = current price - minimum cost.
                sell[t] = Math.max(sell[t], price - buy[t]);
            }
        }
        return sell[k];
    }
}
// @lc code=end

