/*
 * @lc app=leetcode id=342 lang=java
 *
 * [342] Power of Four
 *
 * https://leetcode.com/problems/power-of-four/description/
 *
 * algorithms
 * Easy (45.99%)
 * Likes:    2905
 * Dislikes: 333
 * Total Accepted:    438K
 * Total Submissions: 952.3K
 * Testcase Example:  '16'
 *
 * Given an integer n, return true if it is a power of four. Otherwise, return
 * false.
 * 
 * An integer n is a power of four, if there exists an integer x such that n ==
 * 4^x.
 * 
 * 
 * Example 1:
 * Input: n = 16
 * Output: true
 * Example 2:
 * Input: n = 5
 * Output: false
 * Example 3:
 * Input: n = 1
 * Output: true
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
    public boolean isPowerOfFour(int n) {
        // isPowerOfTwo makes sure there is only one 1 in (binary) n.
        // e.g., n = 0b10000000, n - 1 = 0b01111111
        boolean isPowerOfTwo = (n & (n - 1)) == 0;
        // isOneAtOddBit makes sure the single 1 is at an odd bit.
        int oddOnes = 0b01010101_01010101_01010101_01010101;
        boolean isOneAtOddBit = (n & oddOnes) != 0;
        return isPowerOfTwo && isOneAtOddBit;
    }
}
// @lc code=end

