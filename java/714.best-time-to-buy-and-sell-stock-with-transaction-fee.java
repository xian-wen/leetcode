/*
 * @lc app=leetcode id=714 lang=java
 *
 * [714] Best Time to Buy and Sell Stock with Transaction Fee
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
 *
 * algorithms
 * Medium (64.87%)
 * Likes:    5080
 * Dislikes: 127
 * Total Accepted:    217.7K
 * Total Submissions: 335.1K
 * Testcase Example:  '[1,3,2,8,4,9]\n2'
 *
 * You are given an array prices where prices[i] is the price of a given stock
 * on the i^th day, and an integer fee representing a transaction fee.
 * 
 * Find the maximum profit you can achieve. You may complete as many
 * transactions as you like, but you need to pay the transaction fee for each
 * transaction.
 * 
 * Note: You may not engage in multiple transactions simultaneously (i.e., you
 * must sell the stock before you buy again).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: prices = [1,3,2,8,4,9], fee = 2
 * Output: 8
 * Explanation: The maximum profit can be achieved by:
 * - Buying at prices[0] = 1
 * - Selling at prices[3] = 8
 * - Buying at prices[4] = 4
 * - Selling at prices[5] = 9
 * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: prices = [1,3,7,5,10,3], fee = 3
 * Output: 6
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= prices.length <= 5 * 10^4
 * 1 <= prices[i] < 5 * 10^4
 * 0 <= fee < 5 * 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int buy = Integer.MAX_VALUE;
        int sell = 0;
        for (int price : prices) {
            // Minimum cost.
            buy = Math.min(buy, price - sell);
            // Maximum profit.
            // The only difference between this and LeetCode 122.
            sell = Math.max(sell, price - buy - fee);
        }
        return sell;
    }
}
// @lc code=end

