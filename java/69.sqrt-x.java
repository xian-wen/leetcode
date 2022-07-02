/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 *
 * https://leetcode.com/problems/sqrtx/description/
 *
 * algorithms
 * Easy (36.14%)
 * Likes:    4165
 * Dislikes: 3320
 * Total Accepted:    1.1M
 * Total Submissions: 3M
 * Testcase Example:  '4'
 *
 * Given a non-negative integer x, compute and return the square root of x.
 * 
 * Since the return type is an integer, the decimal digits are truncated, and
 * only the integer part of the result is returned.
 * 
 * Note: You are not allowed to use any built-in exponent function or operator,
 * such as pow(x, 0.5) or x ** 0.5.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: x = 4
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part
 * is truncated, 2 is returned.
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= x <= 2^31 - 1
 * 
 * 
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        // Solution 1: Newton's Method
        // Find the point where tangent line passing (x_0, f(x_0)) intersects x-axis.
        // Tangent line: f(x) = f'(x_0)(x - x_0) + f(x_0).
        // Let f(x) = 0, we get x = x_0 - f(x_0) / f'(x_0).
        // More general, x_{n+1} = x_n - f(x_n) / f'(x_n).
        // In order to get the sqrt of a, let f(x) = x^2 - a,
        // so x_{n+1} = x_n - (x_n^2 - a) / 2x_n = (x_n + a / x_n) / 2.
        // long sqrt = x;
        // while (sqrt * sqrt > x) {
        //     sqrt = (sqrt + x / sqrt) / 2; 
        // }
        // return (int) sqrt;

        // Solution 2: Binary Search
        if (x == 0) {
            return 0;
        }

        // Binary search [1, x] to avoid dividing zero error.
        int l = 1, r = x;
        while (l <= r) {
            // Note: 1 + x >> 1 is equivalent to (1 + x) >> 1.
            int mid = l + ((r - l) >> 1);
            int sqrt = x / mid;
            if (sqrt == mid) {
                return mid;
            } else if (sqrt < mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
}
// @lc code=end

