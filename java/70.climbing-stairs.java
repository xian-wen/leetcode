/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 *
 * https://leetcode.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (52.16%)
 * Likes:    17134
 * Dislikes: 530
 * Total Accepted:    2.2M
 * Total Submissions: 4.2M
 * Testcase Example:  '2'
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 45
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Subproblem:
    //  * ways[i] = the distinct ways to climb to the top using i steps.
    //  * 
    //  * Recurrence relation:
    //  * ways[i] = ways[i - 1] + ways[i - 2]
    //  * ways[0] = 1
    //  * ways[1] = 1
    //  * 
    //  * Time complexity:
    //  * O(n)
    //  */
    // public int climbStairs(int n) {
    //     int[] ways = new int[n + 1];
    //     ways[0] = 1;
    //     ways[1] = 1;
    //     for (int i = 2; i <= n; ++i) {
    //         ways[i] = ways[i - 1] + ways[i - 2];
    //     }
    //     return ways[n];
    // }

    /**
     * Space optimization.
     */
    public int climbStairs(int n) {
        int a = 1, b = 1;
        for (int i = 2; i <= n; ++i) {
            int temp = a;
            a = b;
            b = temp + b;
        }
        return b;
    }
}
// @lc code=end

