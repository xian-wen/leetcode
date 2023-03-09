import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (33.82%)
 * Likes:    32472
 * Dislikes: 1416
 * Total Accepted:    4.3M
 * Total Submissions: 12.7M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string s, find the length of the longest substring without repeating
 * characters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not
 * a substring.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: i - lastIndexOf(s[i])
    //  */
    // public int lengthOfLongestSubstring(String s) {
    //     if (s.length() <= 1) {
    //         return s.length();
    //     }

    //     int N = s.length(), prev = -1, maxLen = 0;
    //     for (int i = 1; i < N; ++i) {
    //         String sub = s.substring(prev + 1, i);
    //         int last = sub.lastIndexOf(s.charAt(i));
    //         prev = last + prev + 1;
    //         maxLen = Math.max(maxLen, i - prev);
    //     }
    //     return maxLen;
    // }

    // /**
    //  * Solution 2: HashSet
    //  */
    // public int lengthOfLongestSubstring(String s) {
    //     int N = s.length(), right = 0, left = 0, maxLen = 0;
    //     Set<Character> win = new HashSet<>();
    //     while (left < N) {
    //         if (!win.contains(s.charAt(left))) {
    //             win.add(s.charAt(left++));
    //             maxLen = Math.max(maxLen, win.size());
    //         } else {
    //             win.remove(s.charAt(right++));
    //         }
    //     }
    //     return maxLen;
    // }

    /**
     * Solution 3: Sliding Window
     */
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        // count: # duplicates, where duplicate means map[c] > 1
        int count = 0, maxLen = 0, left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            ++map[c];
            if (map[c] > 1) {
                ++count;
            }
            
            while (count > 0) {
                c = s.charAt(left);
                --map[c];
                if (map[c] == 1) {
                    --count;
                }
                
                ++left;
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
            ++right;
        }
        return maxLen;
    }
}
// @lc code=end

