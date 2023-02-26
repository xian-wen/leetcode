/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 *
 * https://leetcode.com/problems/coin-change/description/
 *
 * algorithms
 * Medium (41.88%)
 * Likes:    15420
 * Dislikes: 357
 * Total Accepted:    1.3M
 * Total Submissions: 3.2M
 * Testcase Example:  '[1,2,5]\n11'
 *
 * You are given an integer array coins representing coins of different
 * denominations and an integer amount representing a total amount of money.
 * 
 * Return the fewest number of coins that you need to make up that amount. If
 * that amount of money cannot be made up by any combination of the coins,
 * return -1.
 * 
 * You may assume that you have an infinite number of each kind of coin.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: coins = [2], amount = 3
 * Output: -1
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: coins = [1], amount = 0
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 2^31 - 1
 * 0 <= amount <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * Similar to Knapsack with repetition (space optimization).
     * 
     * Subproblem:
     * count[i] = the fewest number of coins to make up amount i.
     * 
     * Recursive relation:
     * count[i] = min{1 + count[i - coins[j]]} if coins[j] <= i
     * count[i] = amount + 1 if i > 0
     *          = 0          if i = 0
     * 
     * Time complexity:
     * O(N*amount)
     */
    public int coinChange(int[] coins, int amount) {
        int[] count = new int[amount + 1];
        for (int i = 1; i <= amount; ++i) {
            count[i] = amount + 1;
            for (int coin : coins) {
                if (coin <= i) {
                    count[i] = Math.min(count[i], 1 + count[i - coin]);
                }
            }
        }
        return count[amount] == amount + 1 ? -1 : count[amount];
    }
}
// @lc code=end

