import java.util.concurrent.ConcurrentHashMap;

/*
 * @lc app=leetcode id=504 lang=java
 *
 * [504] Base 7
 *
 * https://leetcode.com/problems/base-7/description/
 *
 * algorithms
 * Easy (48.27%)
 * Likes:    618
 * Dislikes: 206
 * Total Accepted:    102.2K
 * Total Submissions: 211.6K
 * Testcase Example:  '100'
 *
 * Given an integer num, return a string of its base 7 representation.
 * 
 * 
 * Example 1:
 * Input: num = 100
 * Output: "202"
 * Example 2:
 * Input: num = -7
 * Output: "-10"
 * 
 * 
 * Constraints:
 * 
 * 
 * -10^7 <= num <= 10^7
 * 
 * 
 */

// @lc code=start
class Solution {
    private static final int BASE = 7;
    
    // /**
    //  * Solution 1: java lib.
    //  */
    // public String convertToBase7(int num) {
    //     return Integer.toString(num, BASE);
    // }

    /**
     * Solution 2: recursion.
     */
    public String convertToBase7(int num) {
        if (num < 0) {
            return "-" + convertToBase7(-num);
        }

        if (num < 7) {
            return String.valueOf(num);
        }

        return convertToBase7(num / BASE) + convertToBase7(num % BASE);
    }
}
// @lc code=end

