/*
 * @lc app=leetcode id=326 lang=java
 *
 * [326] Power of Three
 *
 * https://leetcode.com/problems/power-of-three/description/
 *
 * algorithms
 * Easy (45.40%)
 * Likes:    2438
 * Dislikes: 236
 * Total Accepted:    651.7K
 * Total Submissions: 1.4M
 * Testcase Example:  '27'
 *
 * Given an integer n, return true if it is a power of three. Otherwise, return
 * false.
 * 
 * An integer n is a power of three, if there exists an integer x such that n
 * == 3^x.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 27
 * Output: true
 * Explanation: 27 = 3^3
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 0
 * Output: false
 * Explanation: There is no x where 3^x = 0.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: n = -1
 * Output: false
 * Explanation: There is no x where 3^x = (-1).
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * -2^31 <= n <= 2^31 - 1
 * 
 * 
 * 
 * Follow up: Could you solve it without loops/recursion?
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: recursion.
    //  */
    // public boolean isPowerOfThree(int n) {
    //     return isPowerOfThree(1, n);
    // }

    // private boolean isPowerOfThree(int start, int n) {
    //     if (start == n) {
    //         return true;
    //     }

    //     // Note: when start > Integer.MAX_VALUE, overflow, it becomes 
    //     // a negative (2's complete).
    //     if (start > n || start < 0) {
    //         return false;
    //     }
    //     return isPowerOfThree(start * 3, n);
    // }

    // /**
    //  * Solution 2: 3^19 % n = 0, where 3^19 is the max power of 3 
    //  * that < Integer.MAX_VALUE.
    //  */
    // public boolean isPowerOfThree(int n) {
    //     return n > 0 && Math.pow(3, 19) % n == 0;
    // }

    /**
     * Solution 3: log3(n) = x, which should be an integer.
     */
    public boolean isPowerOfThree(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}
// @lc code=end

