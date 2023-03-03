/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 *
 * algorithms
 * Medium (63.71%)
 * Likes:    10481
 * Dislikes: 2504
 * Total Accepted:    1.4M
 * Total Submissions: 2.2M
 * Testcase Example:  '[7,1,5,3,6,4]'
 *
 * You are given an integer array prices where prices[i] is the price of a
 * given stock on the i^th day.
 * 
 * On each day, you may decide to buy and/or sell the stock. You can only hold
 * at most one share of the stock at any time. However, you can buy it then
 * immediately sell it on the same day.
 * 
 * Find and return the maximum profit you can achieve.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit
 * = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 =
 * 3.
 * Total profit is 4 + 3 = 7.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit
 * = 5-1 = 4.
 * Total profit is 4.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: There is no way to make a positive profit, so we never buy the
 * stock to achieve the maximum profit of 0.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= prices.length <= 3 * 10^4
 * 0 <= prices[i] <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Subproblem:
    //  * buy[d] = the minimum cost achievable by buying at day d.
    //  * sell[d] = the maximum profit achievable by selling at day d.
    //  * 
    //  * Recurrence relation:
    //  * buy[d] = min{buy[d - 1], prices[d] - sell[d-1]}
    //  * sell[d] = max{sell[d - 1], prices[d] - buy[d]}
    //  * buy[0] = Integer.MAX_VALUE
    //  * sell[0] = 0
    //  * 
    //  * Time complexity:
    //  * O(N)
    //  */
    // public int maxProfit(int[] prices) {
    //     int N = prices.length;
    //     int[] buy = new int[N];
    //     int[] sell = new int[N];
    //     buy[0] = prices[0];
    //     for (int d = 1; d < N; ++d) {
    //         buy[d] = Math.min(buy[d - 1], prices[d] - sell[d - 1]);
    //         sell[d] = Math.max(sell[d - 1], prices[d] - buy[d]);
    //     }
    //     return sell[N - 1];
    // }

    // /**
    //  * Space optimization.
    //  */
    // public int maxProfit(int[] prices) {
    //     int buy = Integer.MAX_VALUE;
    //     int sell = 0;
    //     for (int price : prices) {
    //         // Minimum cost.
    //         buy = Math.min(buy, price - sell);
    //         // Maximum profit
    //         sell = Math.max(sell, price - buy);
    //     }
    //     return sell;
    // }

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int d = 1; d < prices.length; ++d) {
            if (prices[d] > prices[d - 1]) {
                profit += prices[d] - prices[d - 1];
            }
        }
        return profit;
    }
}
// @lc code=end

