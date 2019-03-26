/*
 * @lc app=leetcode id=14 lang=cpp
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
public:
    string longestCommonPrefix(vector<string>& strs) {
        if (strs.size() == 0) return ""; // 空数组

        // 求所有字符串中最短串长
        int minLen = strs[0].length();
        for (int i = 0; i < strs.size(); i++) {
            if (strs[i].length() < minLen) {
                minLen = strs[i].length();
            }
        }

        int i, j;        
        for (i = 0; i < strs.size(); i++) {
            for (j = 0; j < minLen; j++) {
                if (strs[i][j] != strs[0][j]) {
                    minLen = j; // 更新minLen
                    break; // 发现不匹配，跳出当前比较
                }
            }
            if (j == 0 || minLen == 0) return ""; // 首字符不匹配或者minLen变成0
        }

        return strs[0].substr(0, j);
    }
};

