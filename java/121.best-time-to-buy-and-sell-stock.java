/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 *
 * algorithms
 * Easy (54.22%)
 * Likes:    23888
 * Dislikes: 746
 * Total Accepted:    3.1M
 * Total Submissions: 5.8M
 * Testcase Example:  '[7,1,5,3,6,4]'
 *
 * You are given an array prices where prices[i] is the price of a given stock
 * on the i^th day.
 * 
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction. If you
 * cannot achieve any profit, return 0.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit
 * = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you
 * must buy before you sell.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit =
 * 0.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= prices.length <= 10^5
 * 0 <= prices[i] <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Subproblem:
    //  * profit[i] = the maximum profit achievable by selling the stock at day i-1.
    //  * 
    //  * Recursive relation:
    //  * profit[i] = max{prices[i-1] - prices[j]} if 0 <= j < i-1 && prices[j] <= prices[i-1]
    //  * profit[0] = 0
    //  * profit[1] = 0
    //  * 
    //  * Time complexity:
    //  * O(N^2)
    //  */
    // public int maxProfit(int[] prices) {
    //     int N = prices.length;
    //     int[] profit = new int[N + 1];
    //     int maxProfit = 0;
    //     for (int i = 1; i <= N; ++i) {
    //         for (int j = 0; j < i - 1; ++j) {
    //             profit[i] = Math.max(profit[i], prices[i - 1] - prices[j]);
    //         }

    //         maxProfit = Math.max(maxProfit, profit[i]);
    //     }
    //     return maxProfit;
    // }

    /**
     * Space optimization.
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for (int i = 1; i < prices.length; ++i) {
            minPrice = Math.min(minPrice, prices[i - 1]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }
}
// @lc code=end

