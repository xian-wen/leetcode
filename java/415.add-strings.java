/*
 * @lc app=leetcode id=415 lang=java
 *
 * [415] Add Strings
 *
 * https://leetcode.com/problems/add-strings/description/
 *
 * algorithms
 * Easy (52.51%)
 * Likes:    4224
 * Dislikes: 633
 * Total Accepted:    549.2K
 * Total Submissions: 1M
 * Testcase Example:  '"11"\n"123"'
 *
 * Given two non-negative integers, num1 and num2 represented as string, return
 * the sum of num1 and num2 as a string.
 * 
 * You must solve the problem without using any built-in library for handling
 * large integers (such as BigInteger). You must also not convert the inputs to
 * integers directly.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: num1 = "11", num2 = "123"
 * Output: "134"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: num1 = "456", num2 = "77"
 * Output: "533"
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: num1 = "0", num2 = "0"
 * Output: "0"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= num1.length, num2.length <= 10^4
 * num1 and num2 consist of only digits.
 * num1 and num2 don't have any leading zeros except for the zero itself.
 * 
 * 
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        int i1 = num1.length() - 1;
        int i2 = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i1 >= 0 || i2 >= 0 || carry == 1) {
            int last1 = 0;
            int last2 = 0;

            if (i1 >= 0) {
                last1 = num1.charAt(i1) - '0';
                --i1;
            }

            if (i2 >= 0) {
                last2 = num2.charAt(i2) - '0';
                --i2;
            }

            int sum = (last1 + last2 + carry) % 10;
            carry = (last1 + last2 + carry) / 10;
            sb.append(sum);
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

