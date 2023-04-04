/*
 * @lc app=leetcode id=921 lang=java
 *
 * [921] Minimum Add to Make Parentheses Valid
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1
    //  */
    // public int minAddToMakeValid(String s) {
    //     while (s.contains("()")) {
    //         s = s.replace("()", "");
    //     }
    //     return s.length();
    // }

    // /**
    //  * Solution 2
    //  */
    // public int minAddToMakeValid(String s) {
    //     int res = 0, count = 0;
    //     for (char c : s.toCharArray()) {
    //         if (c == '(') {
    //             ++count;
    //         } else {
    //             --count;
    //         }

    //         if (count < 0) {
    //             res += -count;
    //             count = 0;
    //         }
    //     }
    //     return res + count;
    // }

    /**
     * Solution 3
     * 
     * open: # '(' we need to add to the left of s.
     * close: # ')' we need to add to the right of s.
     */
    public int minAddToMakeValid(String s) {
        int open = 0, close = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                ++close;
            } else if (close > 0) {
                --close;
            } else {
                ++open;
            }
        }
        return open + close;
    }
}
// @lc code=end

