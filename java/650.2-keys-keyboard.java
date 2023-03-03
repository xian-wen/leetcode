/*
 * @lc app=leetcode id=650 lang=java
 *
 * [650] 2 Keys Keyboard
 *
 * https://leetcode.com/problems/2-keys-keyboard/description/
 *
 * algorithms
 * Medium (53.34%)
 * Likes:    3045
 * Dislikes: 182
 * Total Accepted:    113.9K
 * Total Submissions: 213.4K
 * Testcase Example:  '3'
 *
 * There is only one character 'A' on the screen of a notepad. You can perform
 * one of two operations on this notepad for each step:
 * 
 * 
 * Copy All: You can copy all the characters present on the screen (a partial
 * copy is not allowed).
 * Paste: You can paste the characters which are copied last time.
 * 
 * 
 * Given an integer n, return the minimum number of operations to get the
 * character 'A' exactly n times on the screen.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 3
 * Output: 3
 * Explanation: Initially, we have one character 'A'.
 * In step 1, we use Copy All operation.
 * In step 2, we use Paste operation to get 'AA'.
 * In step 3, we use Paste operation to get 'AAA'.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 1
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 1000
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Subproblem:
    //  * count[i] = the minimum number of operations to get 'A' exactly i times.
    //  * 
    //  * Recurrence relation:
    //  * count[i] = count[j] + count[i/j]} if i%j = 0 and j*j <= i
    //  * count[0] = 0
    //  * count[1] = 0
    //  * 
    //  * Time complexity:
    //  * O(n^2)
    //  */
    // public int minSteps(int n) {
    //     int[] count = new int[n + 1];
    //     for (int i = 2; i <= n; ++i) {
    //         // count[i] <= i
    //         count[i] = i;
    //         for (int j = 2; j * j <= i; ++j) {
    //             if (i % j == 0) {
    //                 count[i] = count[j] + count[i / j];
    //             }
    //         }
    //     }
    //     return count[n];
    // }

    /**
     * Space optimization.
     */
    public int minSteps(int n) {
        int count = 0, factor = 2;
        while (n > 1) {
            if (n % factor == 0) {
                count += factor;
                n /= factor;
            } else {
                ++factor;
            }
        }
        return count;
    }
}
// @lc code=end

