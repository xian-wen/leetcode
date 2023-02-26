/*
 * @lc app=leetcode id=1143 lang=java
 *
 * [1143] Longest Common Subsequence
 *
 * https://leetcode.com/problems/longest-common-subsequence/description/
 *
 * algorithms
 * Medium (58.51%)
 * Likes:    10267
 * Dislikes: 121
 * Total Accepted:    653.1K
 * Total Submissions: 1.1M
 * Testcase Example:  '"abcde"\n"ace"'
 *
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence. If there is no common subsequence, return 0.
 * 
 * A subsequence of a string is a new string generated from the original string
 * with some characters (can be none) deleted without changing the relative
 * order of the remaining characters.
 * 
 * 
 * For example, "ace" is a subsequence of "abcde".
 * 
 * 
 * A common subsequence of two strings is a subsequence that is common to both
 * strings.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: text1 = "abcde", text2 = "ace" 
 * Output: 3  
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= text1.length, text2.length <= 1000
 * text1 and text2 consist of only lowercase English characters.
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Subproblem:
    //  * len[i][j] = the length of the LCS of text1[0..(i-1)] and text2[0..(j-1)].
    //  * 
    //  * Recursive relation:
    //  * len[i][j] = max{len[i-1][j], len[i][j-1]} if text1[i-1] = text2[j-1]
    //  *           = 1 + len[i-1][j-1]             otherwise
    //  * len[i][0] = 0
    //  * len[0][j] = 0
    //  * 
    //  * Time complexity:
    //  * O(MN)
    //  */
    // public int longestCommonSubsequence(String text1, String text2) {
    //     int M = text1.length(), N = text2.length();
    //     int[][] len = new int[M + 1][N + 1];
    //     for (int i = 1; i <= M; ++i) {
    //         for (int j = 1; j <= N; ++j) {
    //             if (text1.charAt(i - 1) != text2.charAt(j - 1)) {
    //                 len[i][j] = Math.max(len[i - 1][j], len[i][j - 1]);
    //             } else {
    //                 len[i][j] = 1 + len[i - 1][j - 1];
    //             }
    //         }
    //     }
    //     return len[M][N];
    // }

    /**
     * Space optimization.
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int M = text1.length(), N = text2.length();
        if (M < N) {
            return longestCommonSubsequence(text2, text1);
        }

        int[] len = new int[N + 1];
        for (int i = 1; i <= M; ++i) {
            for (int j = 1, up = 0, upLeft; j <= N; ++j) {
                upLeft = up;
                up = len[j];
                if (text1.charAt(i - 1) != text2.charAt(j - 1)) {
                    len[j] = Math.max(len[j - 1], up);
                } else {
                    len[j] = 1 + upLeft;
                }
            }
        }
        return len[N];
    }
}
// @lc code=end

