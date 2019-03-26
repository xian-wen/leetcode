/*
 * @lc app=leetcode id=28 lang=cpp
 *
 * [28] Implement strStr()
 *
 * https://leetcode.com/problems/implement-strstr/description/
 *
 * algorithms
 * Easy (31.37%)
 * Total Accepted:    396.8K
 * Total Submissions: 1.3M
 * Testcase Example:  '"hello"\n"ll"'
 *
 * Implement strStr().
 * 
 * Return the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * Example 1:
 * 
 * 
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * 
 * 
 * Clarification:
 * 
 * What should we return when needle is an empty string? This is a great
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we will return 0 when needle is an empty
 * string. This is consistent to C's strstr() and Java's indexOf().
 * 
 */
class Solution {
public:
    int strStr(string haystack, string needle) {
        for (int i = 0; i < haystack.length(); i++) {
            int j = 0;
            for (; j < needle.length(); j++) {
                // [i + j]即表示每次第i个位置开始逐一比较
                if (haystack[i + j] != needle[j]) {
                    break;
                }
            }
            
            // 匹配成功，包含模式串为空的情况
            if (j == needle.length())
                return i;
        }

        return -1; // 匹配失败
    }
};

