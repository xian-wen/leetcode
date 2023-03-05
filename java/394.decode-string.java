import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 *
 * https://leetcode.com/problems/decode-string/description/
 *
 * algorithms
 * Medium (57.94%)
 * Likes:    10424
 * Dislikes: 469
 * Total Accepted:    621.7K
 * Total Submissions: 1.1M
 * Testcase Example:  '"3[a]2[bc]"'
 *
 * Given an encoded string, return its decoded string.
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 * 
 * You may assume that the input string is always valid; there are no extra
 * white spaces, square brackets are well-formed, etc. Furthermore, you may
 * assume that the original data does not contain any digits and that digits
 * are only for those repeat numbers, k. For example, there will not be input
 * like 3a or 2[4].
 * 
 * The test cases are generated so that the length of the output will never
 * exceed 10^5.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 30
 * s consists of lowercase English letters, digits, and square brackets
 * '[]'.
 * s is guaranteed to be a valid input.
 * All the integers in s are in the range [1, 300].
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Stack
    //  */
    // public String decodeString(String s) {
    //     Deque<String> stack = new ArrayDeque<>();
    //     String cur = "", repeat = "";
    //     for (int i = 0; i < s.length(); ++i) {
    //         char c = s.charAt(i);
    //         if (c >= '0' && c <= '9') {
    //             if (!cur.isEmpty()) {
    //                 stack.push(cur);
    //                 cur = "";
    //             }

    //             repeat += String.valueOf(c);
    //         } else if (c == '[') {
    //             stack.push(repeat);
    //             stack.push(s.substring(i, i + 1));
    //             repeat = "";
    //         } else if (c == ']') {
    //             while (!"[".equals(stack.peek())) {
    //                 cur = stack.pop() + cur;
    //             }

    //             // "["
    //             stack.pop();
    //             repeat = stack.pop();
    //             cur = cur.repeat(Integer.parseInt(repeat));
    //             stack.push(cur);
    //             cur = "";
    //             repeat = "";
    //         } else {  // [a-z]
    //             cur += s.substring(i, i + 1);
    //         }
    //     }

    //     while (!stack.isEmpty()) {
    //         cur = stack.pop() + cur;
    //     }
    //     return cur;
    // }

    /**
     * Solution 2: Recursion
     */
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        decodeString(s, 0, res);
        return res.toString();
    }

    private int decodeString(String s, int index, StringBuilder res) {
        int len = s.length(), repeat = 0;
        while (index < len) {
            char c = s.charAt(index++);
            if (c >= '0' && c <= '9') {
                repeat = repeat * 10 + (c - '0');
            } else if (c == '[') {
                StringBuilder sb = new StringBuilder();
                index = decodeString(s, index, sb);
                res.append(sb.toString().repeat(repeat));
                repeat = 0;
            } else if (c == ']') {
                break;
            } else {
                res.append(c);
            }
        }
        return index;
    }
}
// @lc code=end

