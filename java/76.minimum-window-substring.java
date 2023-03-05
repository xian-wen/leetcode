/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 *
 * https://leetcode.com/problems/minimum-window-substring/description/
 *
 * algorithms
 * Hard (38.27%)
 * Likes:    10925
 * Dislikes: 545
 * Total Accepted:    788.3K
 * Total Submissions: 2M
 * Testcase Example:  '"ADOBECODEBANC"\n"ABC"'
 *
 * Given two strings s and t of lengths m and n respectively, return the
 * minimum window substring of s such that every character in t (including
 * duplicates) is included in the window. If there is no such substring, return
 * the empty string "".
 * 
 * The testcases will be generated such that the answer is unique.
 * 
 * A substring is a contiguous sequence of characters within the string.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C'
 * from string t.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 10^5
 * s and t consist of uppercase and lowercase English letters.
 * 
 * 
 * 
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if (sLen < tLen) {
            return "";
        }

        int[] map = new int[128];
        // All other chars by default are 0 need.
        for (int i = 0; i < tLen; ++i) {
            ++map[t.charAt(i)];
        }

        // # chars we need.
        int count = tLen;
        // Update to get a valid window.
        int right = 0;
        // Update to shrink a window.
        int left = 0;
        // Start index of the min window.
        int start = -1;
        // The length of the min window, at most sLen.
        int minLen = sLen + 1;
        while (right < sLen) {
            // If right is what we need.
            if (map[s.charAt(right)] > 0) {
                // After include right, we will need one less share of right.
                --count;
            }

            // Decrease what we need, causing # chars not in t < 0, 
            // # chars in t >= 0.
            --map[s.charAt(right)];

            // Once a valid window is found, try to shrink it.
            // Valid window: we have found all chars exist in t and have nothing 
            // needed, i.e., count = 0, # chars in map will be <= 0.
            while (count == 0) {
                int len = right - left + 1;
                if (len < minLen) {
                    minLen = len;
                    start = left;
                }

                // If left is what we need (what we do not need will be < 0).
                if (map[s.charAt(left)] == 0) {
                    // After shrink, we will need one more share of left.
                    ++count;
                }

                // Increase what we need.
                ++map[s.charAt(left)];

                ++left;
            }

            ++right;
        }
        return start == -1 ? "" : s.substring(start, start + minLen);  
    }
}
// @lc code=end

