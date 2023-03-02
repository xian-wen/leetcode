/*
 * @lc app=leetcode id=647 lang=java
 *
 * [647] Palindromic Substrings
 *
 * https://leetcode.com/problems/palindromic-substrings/description/
 *
 * algorithms
 * Medium (66.10%)
 * Likes:    7945
 * Dislikes: 171
 * Total Accepted:    498.2K
 * Total Submissions: 753.5K
 * Testcase Example:  '"abc"'
 *
 * Given a string s, return the number of palindromic substrings in it.
 * 
 * A string is a palindrome when it reads the same backward as forward.
 * 
 * A substring is a contiguous sequence of characters within the string.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 1000
 * s consists of lowercase English letters.
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Brute Force
    //  */
    // public int countSubstrings(String s) {
    //     if (s == null || s.isEmpty()) {
    //         return 0;
    //     }

    //     StringBuilder sb = new StringBuilder(s);
    //     int count = 0;
    //     for (int i = 0; i < s.length(); ++i) {
    //         for (int j = i + 1; j <= s.length(); ++j) {
    //             String sub = sb.substring(i, j);
    //             count += isPalindrome(sub) ? 1 : 0;
    //         }
    //     }
    //     return count;
    // }

    // private boolean isPalindrome(String s) {
    //     StringBuilder sb = new StringBuilder(s);
    //     String reversed = sb.reverse().toString();
    //     return s.equals(reversed);
    // }

    /**
     * Solution 2: Extend Palindrome
     */
    public int countSubstrings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
    
        char[] charArr = s.toCharArray();
        int count = 0;
        for (int i = 0; i < charArr.length; ++i) {
            // Count palindromic substrings with odd or even length.
            count += countPalindromes(charArr, i, i);
            count += countPalindromes(charArr, i, i + 1);
        }
        return count;
    }
    
    private int countPalindromes(char[] arr, int l, int r) {
        int count = 0;
        // Note: if checking equality in the while loop,
        // must adding "else break;"! 
        while (l >= 0 && r < arr.length && arr[l--] == arr[r++]) {
            ++count;
        }
        return count;
    }
}
// @lc code=end

