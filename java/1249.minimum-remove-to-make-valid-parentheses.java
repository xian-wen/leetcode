import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=1249 lang=java
 *
 * [1249] Minimum Remove to Make Valid Parentheses
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Stack
    //  */
    // public String minRemoveToMakeValid(String s) {
    //     Deque<Integer> stack = new ArrayDeque<>();
    //     char[] chars = s.toCharArray();
    //     int N = chars.length;
    //     for (int i = 0; i < N; ++i) {
    //         char c = chars[i];
    //         if (c == '(') {
    //             stack.push(i);
    //         } else if (c == ')') {
    //             if (!stack.isEmpty()) {
    //                 stack.pop();
    //             } else {
    //                 // Invalid ')'.
    //                 chars[i] = '*';
    //             }
    //         }
    //     }

    //     // Invalid '('.
    //     while (!stack.isEmpty()) {
    //         chars[stack.pop()] = '*';
    //     }
        
    //     StringBuilder sb = new StringBuilder();
    //     for (char c : chars) {
    //         if (c != '*') {
    //             sb.append(c);
    //         }
    //     }
    //     return sb.toString();
    // }

    // /**
    //  * Solution 2: No Stack
    //  */
    // public String minRemoveToMakeValid(String s) {
    //     char[] chars = s.toCharArray();
    //     int N = chars.length, count = 0;
    //     for (int i = 0; i < N; ++i) {
    //         char c = chars[i];
    //         if (c == '(') {
    //             ++count;
    //         } 
            
    //         if (c == ')') {
    //             if (count == 0) {
    //                 chars[i] = '*';
    //             } else {
    //                 --count;
    //             }
    //         }
    //     }

    //     count = 0;
    //     for (int i = N - 1; i >= 0; --i) {
    //         char c = chars[i];
    //         if (c == ')') {
    //             ++count;
    //         } 
            
    //         if (c == '(') {
    //             if (count == 0) {
    //                 chars[i] = '*';
    //             } else {
    //                 --count;
    //             }
    //         }
    //     }

    //     StringBuilder sb = new StringBuilder();
    //     for (char c : chars) {
    //         if (c != '*') {
    //             sb.append(c);
    //         }
    //     }
    //     return sb.toString();
    // }

    /**
     * Solution 3
     */
    public String minRemoveToMakeValid(String s) {
        int close = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == ')') {
                ++close;
            }
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (char c : chars) {
            if (c == '(') {
                if (count == close) {
                    continue;
                }

                ++count;
            }
            
            if (c == ')') {
                --close;
                if (count == 0) {
                    continue;
                }
                
                --count;
            }

            sb.append(c);
        }
        return sb.toString();
    }
}
// @lc code=end

