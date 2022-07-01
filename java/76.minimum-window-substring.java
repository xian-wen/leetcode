import java.util.HashMap;
import java.util.Map;

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
        if (s == null || t == null || s.isEmpty() || t.isEmpty()) {
            return "";
        }

        // Count the frequency of each character in t.
        Map<Character, Integer> tCount = new HashMap<>();
        for (int i = 0; i < t.length(); ++i) {
            char c = t.charAt(i);
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }
        
        // Number of unique characters.
        int have = 0, need = tCount.size();
        Map<Character, Integer> sCount = new HashMap<>();
        int minL = 0, minR = 0, minLen = Integer.MAX_VALUE;
        for (int l = 0, r = 0; r < s.length(); ++r) {
            char rChar = s.charAt(r);
            if (tCount.containsKey(rChar)) {
                sCount.put(rChar, sCount.getOrDefault(rChar, 0) + 1);

                // Only increase have if the frequency is the same.
                if (sCount.get(rChar).intValue() == tCount.get(rChar).intValue()) {
                    ++have;
                }

                // If sCount have all of items in tCount, shrink the window.
                while (l <= r && have == need) {
                    char lChar = s.charAt(l);
                    
                    // Record current minimum window.
                    int size = r - l + 1;
                    if (size < minLen) {
                        minLen = size;
                        minL = l;
                        minR = r;
                    }

                    if (sCount.containsKey(lChar)) {
                        sCount.put(lChar, sCount.get(lChar) - 1);

                        // Only decrease have if the frequency in sCount is less than tCount. 
                        if (sCount.get(lChar).intValue() < tCount.get(lChar).intValue()) {
                            --have;
                        }
                    }

                    ++l;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minL, minR + 1);
    }
}
// @lc code=end

