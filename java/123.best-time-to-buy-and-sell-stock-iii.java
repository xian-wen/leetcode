import java.util.Arrays;

/*
 * @lc app=leetcode id=123 lang=java
 *
 * [123] Best Time to Buy and Sell Stock III
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 *
 * algorithms
 * Hard (45.28%)
 * Likes:    7811
 * Dislikes: 151
 * Total Accepted:    463.2K
 * Total Submissions: 1M
 * Testcase Example:  '[3,3,5,0,0,3,1,4]'
 *
 * You are given an array prices where prices[i] is the price of a given stock
 * on the i^th day.
 * 
 * Find the maximum profit you can achieve. You may complete at most two
 * transactions.
 * 
 * Note: You may not engage in multiple transactions simultaneously (i.e., you
 * must sell the stock before you buy again).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: prices = [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit
 * = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 =
 * 3.
 * 
 * Example 2:
 * 
 * 
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit
 * = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you
 * are engaging multiple transactions at the same time. You must sell before
 * buying again.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= prices.length <= 10^5
 * 0 <= prices[i] <= 10^5
 * 
 * 
 */

// @lc code=start
class Solution {
    // public int maxProfit(int[] prices) {
    //     return maxProfit(2, prices);
    // }

    // /**
    //  * Ref: LeetCode 188.
    //  */
    // private int maxProfit(int k, int[] prices) {
    //     // buy[t]: the minimum cost achievable using <= t transactions.
    //     // sell[t]: the maximum profit achievable using <= t transactions.
    //     int[] buy = new int[k + 1], sell = new int[k + 1];
    //     Arrays.fill(buy, Integer.MAX_VALUE);
    //     for (int price : prices) {
    //         for (int t = 1; t <= k; ++t) {
    //             // Minimum cost.
    //             buy[t] = Math.min(buy[t], price - sell[t - 1]);
    //             // Maximum profit.
    //             sell[t] = Math.max(sell[t], price - buy[t]);
    //         }
    //     }
    //     return sell[k];
    // }

    /**
     * Space optimization.
     */
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MAX_VALUE, sell1 = 0;
        int buy2 = Integer.MAX_VALUE, sell2 = 0;
        for (int price : prices) {
            // Minimum cost1.
            buy1 = Math.min(buy1, price);
            // Maximum profit1.
            sell1 = Math.max(sell1, price - buy1);
            // Minimum cost2.
            buy2 = Math.min(buy2, price - sell1);
            // Maximum profit2.
            sell2 = Math.max(sell2, price - buy2);
        }
        return sell2;
    }
}
// @lc code=end

