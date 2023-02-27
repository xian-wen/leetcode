/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (32.40%)
 * Likes:    24059
 * Dislikes: 1403
 * Total Accepted:    2.3M
 * Total Submissions: 7.1M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, return the longest palindromic substring in s.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "cbbd"
 * Output: "bb"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 * 
 * 
 */

// @lc code=start
class Solution {
    private String s;
    private int N;
    private int maxLen;
    private int startIndex;

    public String longestPalindrome(String s) {
        this.s = s;
        N = s.length();
        for (int i = 0; i < N; ++i) {
            // Odd length.
            extendPalindrome(i, i);
            // Even length.
            extendPalindrome(i, i + 1);
        }
        return s.substring(startIndex, startIndex + maxLen);
    }

    /**
     * Palindrome string s[start..end] inclusive.
     */
    private void extendPalindrome(int start, int end) {
        while (start >= 0 && end < N && s.charAt(start) == s.charAt(end)) {
            --start;
            ++end;
        }

        int curLen = end - start - 1;
        if (curLen > maxLen) {
            maxLen = curLen;
            startIndex = start + 1;
        }
    }
}
// @lc code=end

