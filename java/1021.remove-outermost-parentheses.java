/*
 * @lc app=leetcode id=1021 lang=java
 *
 * [1021] Remove Outermost Parentheses
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Recursion
    //  */
    // public String removeOuterParentheses(String s) {
    //     return removeOuterParentheses(s, 0);
    // }

    // private String removeOuterParentheses(String s, int start) {
    //     int N = s.length();
    //     if (start == N) {
    //         return "";
    //     }

    //     int count = 0, end = start;
    //     while (end < N) {
    //         char c = s.charAt(end++);
    //         if (c == '(') {
    //             ++count;
    //         } else {
    //             --count;
    //         }

    //         if (count == 0) {
    //             break;
    //         }
    //     }

    //     String next = removeOuterParentheses(s, end);
    //     return s.substring(start + 1, end - 1) + next;
    // }

    // /**
    //  * Solution 2: Iteration
    //  */
    // public String removeOuterParentheses(String s) {
    //     String res = "";
    //     int N = s.length(), start = 0, count = 0;
    //     for (int i = 0; i < N; ++i) {
    //         char c = s.charAt(i);
    //         if (c == '(') {
    //             ++count;
    //         } else {
    //             --count;
    //         }

    //         if (count == 0) {
    //             res += s.substring(start + 1, i);
    //             start = i + 1;
    //         }
    //     }
    //     return res;
    // }

    /**
     * Solution 3
     */
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(' && count++ > 0) {
                sb.append(c);
            }

            if (c == ')' && count-- > 1) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
// @lc code=end

