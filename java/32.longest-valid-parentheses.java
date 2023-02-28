import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 *
 * https://leetcode.com/problems/longest-valid-parentheses/description/
 *
 * algorithms
 * Hard (32.77%)
 * Likes:    10522
 * Dislikes: 333
 * Total Accepted:    599.7K
 * Total Submissions: 1.8M
 * Testcase Example:  '"(()"'
 *
 * Given a string containing just the characters '(' and ')', return the length
 * of the longest valid (well-formed) parentheses substring.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = ""
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= s.length <= 3 * 10^4
 * s[i] is '(', or ')'.
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Dynamic Programming
    //  * 
    //  * Subproblem:
    //  * len[i] = the length of the longest valid parentheses substring in 
    //  * s[0..i] including s[i].
    //  * 
    //  * Recursive relation:
    //  * len[i] = 2 + len[i-1] + len[i-len[i-1]-2] if s[i] = ')' && s[i-len[i-1]-1] = '('
    //  *        = 0                                otherwise
    //  * len[0] = 0
    //  * 
    //  * Time complexity:
    //  * O(N)
    //  */
    // public int longestValidParentheses(String s) {
    //     s = ")" + s;
    //     int N = s.length();
    //     int[] len = new int[N];
    //     int maxLen = 0;
    //     for (int i = 1; i < N; ++i) {
    //         if (s.charAt(i) == ')' && s.charAt(i - len[i - 1] - 1) == '(') {
    //             len[i] = 2 + len[i - 1] + len[i - len[i - 1] - 2];
    //             maxLen = Math.max(maxLen, len[i]);
    //         }
    //     }
    //     return maxLen;
    // }

    /**
     * Solution 2: Stack
     */
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int N = s.length(), maxLen = 0;
        for (int i = 0; i < N; ++i) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    // Using the index of ')' as the start index.
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
}
// @lc code=end

