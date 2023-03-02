/*
 * @lc app=leetcode id=312 lang=java
 *
 * [312] Burst Balloons
 *
 * https://leetcode.com/problems/burst-balloons/description/
 *
 * algorithms
 * Hard (56.91%)
 * Likes:    7448
 * Dislikes: 189
 * Total Accepted:    221.3K
 * Total Submissions: 388.6K
 * Testcase Example:  '[3,1,5,8]'
 *
 * You are given n balloons, indexed from 0 to n - 1. Each balloon is painted
 * with a number on it represented by an array nums. You are asked to burst all
 * the balloons.
 * 
 * If you burst the i^th balloon, you will get nums[i - 1] * nums[i] * nums[i +
 * 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it
 * as if there is a balloon with a 1 painted on it.
 * 
 * Return the maximum coins you can collect by bursting the balloons wisely.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [3,1,5,8]
 * Output: 167
 * Explanation:
 * nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
 * coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,5]
 * Output: 10
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == nums.length
 * 1 <= n <= 300
 * 0 <= nums[i] <= 100
 * 
 * 
 */

// @lc code=start
class Solution {
    private int[] balloons;
    private int[][] memo;

    /**
     * Solution 1: Divide and Conquer + Memoization
     */
    public int maxCoins(int[] nums) {
        balloons = new int[nums.length + 2];
        int n = 0;
        balloons[n++] = 1;
        for (int num : nums) {
            if (num > 0) {
                balloons[n++] = num;
            }
        }
        balloons[n++] = 1;

        memo = new int[n][n];
        return burstBalloons(0, n - 1);
    }

    private int burstBalloons(int left, int right) {
        if (left + 1 == right) {
            return 0;
        }

        if (memo[left][right] > 0) {
            return memo[left][right];
        }

        int maxCoins = 0;
        for (int k = left + 1; k < right; ++k) {
            int leftCoins = burstBalloons(left, k);
            int rightCoins = burstBalloons(k, right);
            // i: the last balloon to be burst.
            int coins = balloons[left] * balloons[k] * balloons[right];
            maxCoins = Math.max(maxCoins, leftCoins + rightCoins + coins);
        }

        memo[left][right] = maxCoins;
        return maxCoins;
    }

    // /**
    //  * Solution 2: Dynamic programming
    //  * 
    //  * Similar to Chain Matrix Multiply.
    //  * 
    //  * Subproblem:
    //  * coins[i][j] = the maximum number of coins achievable by bursting 
    //  * balloons[(i+1)..(j+1)].
    //  * 
    //  * Recursive relation:
    //  * coins[i][j] = max{balloons[i] * balloons[k] * balloons[j] 
    //  *             + coins[i][k] + coins[k][j]} 
    //  * where i < k < j and k is the last balloon to be burst
    //  * coins[i][i+1] = 0
    //  * 
    //  * Time complexity:
    //  * O(N^3)
    //  */
    // public int maxCoins(int[] nums) {
    //     int[] balloons = new int[nums.length + 2];
    //     int n = 0;
    //     balloons[n++] = 1;
    //     for (int num : nums) {
    //         if (num > 0) {
    //             balloons[n++] = num;
    //         }
    //     }
    //     balloons[n++] = 1;

    //     int[][] coins = new int[n][n];
    //     // s: the size of the window.
    //     for (int s = 2; s < n; ++s) {
    //         for (int i = 0; i < n - s; ++i) {
    //             int j = i + s;
    //             coins[i][j] = 0;
    //             for (int k = i + 1; k < j; ++k) {
    //                 // k: the last balloon to be burst.
    //                 int curCoins = balloons[i] * balloons[k] * balloons[j]; 
    //                 coins[i][j] = Math.max(coins[i][j], 
    //                         coins[i][k] + coins[k][j] + curCoins);
    //             }
    //         }
    //     }
    //     return coins[0][n - 1];
    // }
}
// @lc code=end

