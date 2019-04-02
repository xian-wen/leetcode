/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 *
 * https://leetcode.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (33.09%)
 * Total Accepted:    427.2K
 * Total Submissions: 1.3M
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * Write a function to find the longest common prefix string amongst an array
 * of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * 
 * 
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 
 * 
 * Note:
 * 
 * All given inputs are in lowercase letters a-z.
 * 
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return ""; // empty array

        // find the shortest length
        int minLen = strs[0].length();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minLen)
                minLen = strs[i].length();
        }
        
        // find the shortest common prefix length
        for (int i = 0; i < strs.length; i++) {
            int j;
            for (j = 0; j < minLen; j++) {
                if (strs[i].charAt(j) != strs[0].charAt(j)) {
                    minLen = j; // update minLen
                    break; // once not equal, no need to compare
                }
            }

            // the first not match or minLen equal 0
            if (j == 0 || minLen == 0) return "";
        }

        // include only 1 string in strs
        return strs[0].substring(0, minLen); 
    }
}

