/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 *
 * algorithms
 * Medium (56.06%)
 * Likes:    8031
 * Dislikes: 276
 * Total Accepted:    390.5K
 * Total Submissions: 695.8K
 * Testcase Example:  '[1,2,3,0,2]'
 *
 * You are given an array prices where prices[i] is the price of a given stock
 * on the i^th day.
 * 
 * Find the maximum profit you can achieve. You may complete as many
 * transactions as you like (i.e., buy one and sell one share of the stock
 * multiple times) with the following restrictions:
 * 
 * 
 * After you sell your stock, you cannot buy stock on the next day (i.e.,
 * cooldown one day).
 * 
 * 
 * Note: You may not engage in multiple transactions simultaneously (i.e., you
 * must sell the stock before you buy again).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: prices = [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: prices = [1]
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * Subproblem:
     * buy[d] = the minimum cost achievable by buying at day d.
     * sell[d] = the maximum profit achievable by selling at day d.
     * 
     * Recursive relation:
     * buy[d] = min{buy[d-1], prices[d] - sell[d-2]}
     * sell[d] = max{sell[d-1], prices[d] - buy[d]}
     * 
     * Time complexity:
     * O(N)
     */
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int preSell = 0, sell = 0;
        for (int price : prices) {
            buy = Math.min(buy, price - preSell);
            // The only difference between this and LeetCode 122.
            preSell = sell;
            sell = Math.max(preSell, price - buy);
        }
        return sell;
    }
}
// @lc code=end

