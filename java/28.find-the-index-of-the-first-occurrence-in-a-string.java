/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Find the Index of the First Occurrence in a String
 *
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 *
 * algorithms
 * Medium (38.01%)
 * Likes:    1516
 * Dislikes: 105
 * Total Accepted:    1.5M
 * Total Submissions: 4M
 * Testcase Example:  '"sadbutsad"\n"sad"'
 *
 * Given two strings needle and haystack, return the index of the first
 * occurrence of needle in haystack, or -1 if needle is not part of
 * haystack.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= haystack.length, needle.length <= 10^4
 * haystack and needle consist of only lowercase English characters.
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Brute Force
    //  */
    // public int strStr(String haystack, String needle) {
    //     int N = haystack.length(), M = needle.length(), i, j;
    //     for (i = 0, j = 0; i < N && j < M; ++i) {
    //         if (haystack.charAt(i) == needle.charAt(j)) {
    //             ++j;
    //         } else {
    //             i -= j;
    //             j = 0;
    //         }
    //     }

    //     if (j == M) {
    //         return i - M;
    //     }
    //     return -1;
    // }

    /**
     * Solution 2: KMP
     * 
     * Ref: https://en.wikipedia.org/wiki/Knuth-Morris-Pratt_algorithm
     */
    public int strStr(String haystack, String needle) {
        int[] lps = longestPrefixSuffix(needle);
        int N = haystack.length(), M = needle.length(), i = 0, j = 0;
        while (i < N) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                ++i;
                ++j;
                if (j == M) {
                    return i - j;
                }
            } else {
                j = lps[j];
                if (j < 0) {
                    ++i;
                    ++j;
                }
            }
        }
        return -1;
    }

    private int[] longestPrefixSuffix(String needle) {
        int M = needle.length();
        int[] lps = new int[M];
        lps[0] = -1;
        int j = 1, cnd = 0;
        while (j < M) {
            if (needle.charAt(j) == needle.charAt(cnd)) {
                lps[j] = lps[cnd];
            } else {
                lps[j] = cnd;
                while (cnd >= 0 && needle.charAt(j) != needle.charAt(cnd)) {
                    cnd = lps[cnd];
                }
            }

            ++j;
            ++cnd;
        }
        return lps;
    }
}
// @lc code=end

