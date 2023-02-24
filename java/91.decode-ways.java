/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 *
 * https://leetcode.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (32.57%)
 * Likes:    9580
 * Dislikes: 4200
 * Total Accepted:    983K
 * Total Submissions: 3M
 * Testcase Example:  '"12"'
 *
 * A message containing letters from A-Z can be encoded into numbers using the
 * following mapping:
 * 
 * 
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * 
 * 
 * To decode an encoded message, all the digits must be grouped then mapped
 * back into letters using the reverse of the mapping above (there may be
 * multiple ways). For example, "11106" can be mapped into:
 * 
 * 
 * "AAJF" with the grouping (1 1 10 6)
 * "KJF" with the grouping (11 10 6)
 * 
 * 
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped
 * into 'F' since "6" is different from "06".
 * 
 * Given a string s containing only digits, return the number of ways to decode
 * it.
 * 
 * The test cases are generated so that the answer fits in a 32-bit integer.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "12"
 * Output: 2
 * Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "226"
 * Output: 3
 * Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2
 * 2 6).
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "06"
 * Output: 0
 * Explanation: "06" cannot be mapped to "F" because of the leading zero ("6"
 * is different from "06").
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 100
 * s contains only digits and may contain leading zero(s).
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * Subproblem:
     * count[i] = the number of ways to decode s[0..(i-1)].
     * 
     * Recursive relation:
     * count[i] = count1 + count2
     * count1 = count[i-1] if count12(s[i-1]) = 1
     *        = 0          if count12(s[i-1]) = 0
     * count2 = count[i-2] if count12(s[(i-2)..(i-1)]) = 1
     *        = 0          if count12(s[(i-2)..(i-1)]) = 0
     * count[0] = 1  // e.g., "12" decoded as "" and "12"
     * count[1] = count12(s[i-1])
     * 
     * Time complexity:
     * O(N)
     * 
     */
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }

        int N = s.length();
        int[] count = new int[N + 1];
        count[0] = 1;
        count[1] = count12(s.substring(0, 1));
        for (int i = 2; i <= N; ++i) {
            int count1 = count[i - 1];
            String s1 = s.substring(i - 1, i);
            if (count12(s1) == 0) {
                count1 = 0;
            }

            int count2 = count[i - 2];
            String s2 = s.substring(i - 2, i);
            if (count12(s2) == 0) {
                count2 = 0;
            }

            count[i] = count1 + count2;
        }
        return count[N];
    }

    /**
     * The length of s is either 1 or 2.
     */
    public int count12(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }

        int value = Integer.parseInt(s);
        if (value < 1 || value > 26) {
            return 0;
        }
        return 1;
    }
}
// @lc code=end

