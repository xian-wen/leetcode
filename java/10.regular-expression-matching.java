import java.util.Arrays;

/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 *
 * https://leetcode.com/problems/regular-expression-matching/description/
 *
 * algorithms
 * Hard (28.07%)
 * Likes:    10146
 * Dislikes: 1658
 * Total Accepted:    789.2K
 * Total Submissions: 2.8M
 * Testcase Example:  '"aa"\n"a"'
 *
 * Given an input string s and a pattern p, implement regular expression
 * matching with support for '.' and '*' where:
 * 
 * 
 * '.' Matches any single character.​​​​
 * '*' Matches zero or more of the preceding element.
 * 
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "aa", p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'.
 * Therefore, by repeating 'a' once, it becomes "aa".
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "ab", p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 20
 * 1 <= p.length <= 20
 * s contains only lowercase English letters.
 * p contains only lowercase English letters, '.', and '*'.
 * It is guaranteed for each appearance of the character '*', there will be a
 * previous valid character to match.
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: built-in
    //  */
    // public boolean isMatch(String s, String p) {
    //     return s.matches(p);
    // }

    /**
     * Subproblem:
     * match[i][j] = whether s[0..(i-1)] matches p[0..(j-1)].
     * 
     * Recursive relation:
     * match[i][j] = match[i-1][j-1]                                 if p[j-1] = '.'
     *             = s[i-1] == p[j-1] && match[i-1][j-1]             if p[j-1] = [a-z]
     *             = match[i][j-2]                                   if p[j-1] = '*' && p[j-2] != '.' && s[i-1] != p[j-2]
     *             = match[i-1][j] || match[i][j-1] || match[i][j-2] if p[j-1] = '*' && (p[j-2] = '.' || s[i-1] == p[j-2])
     * match[i][0] = false
     * match[0][0] = true
     * match[0][j] = match[0][j-2] if p[j-1] == '*'
     *             = false         otherwise
     * 
     * Time complexity:
     * O(MN)
     */
    public boolean isMatch(String s, String p) {
        int M = s.length(), N = p.length();
        boolean[][] match = new boolean[M + 1][N + 1];
        match[0][0] = true;
        for (int j = 1; j <= N; ++j) {
            if (p.charAt(j - 1) == '*') {
                match[0][j] = match[0][j - 2];
            }
        }

        for (int i = 1; i <= M; ++i) {
            for (int j = 1; j <= N; ++j) {
                if (p.charAt(j - 1) == '.') {
                    match[i][j] = match[i - 1][j - 1];
                } else if (p.charAt(j - 1) != '*') {
                    match[i][j] = s.charAt(i - 1) == p.charAt(j - 1) && match[i - 1][j - 1];
                } else if (p.charAt(j - 2) != '.' && s.charAt(i - 1) != p.charAt(j - 2)) {
                    match[i][j] = match[i][j - 2];
                } else {
                    match[i][j] = match[i - 1][j] || match[i][j - 1] || match[i][j - 2];
                }
            }
        }
        return match[M][N];
    }
}
// @lc code=end

