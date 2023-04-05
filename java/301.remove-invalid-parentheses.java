import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode id=301 lang=java
 *
 * [301] Remove Invalid Parentheses
 *
 * https://leetcode.com/problems/remove-invalid-parentheses/description/
 *
 * algorithms
 * Hard (47.20%)
 * Likes:    5332
 * Dislikes: 263
 * Total Accepted:    378.3K
 * Total Submissions: 801.6K
 * Testcase Example:  '"()())()"'
 *
 * Given a string s that contains parentheses and letters, remove the minimum
 * number of invalid parentheses to make the input string valid.
 * 
 * Return a list of unique strings that are valid with the minimum number of
 * removals. You may return the answer in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "()())()"
 * Output: ["(())()","()()()"]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "(a)())()"
 * Output: ["(a())()","(a)()()"]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = ")("
 * Output: [""]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 25
 * s consists of lowercase English letters and parentheses '(' and ')'.
 * There will be at most 20 parentheses in s.
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: BFS
    //  */
    // public List<String> removeInvalidParentheses(String s) {
    //     List<String> res = new ArrayList<>();
    //     Set<String> visited = new HashSet<>();
    //     Queue<String> queue = new ArrayDeque<>();
    //     queue.offer(s);
    //     visited.add(s);
    //     boolean found = false;
    //     while (!queue.isEmpty()) {
    //         String str = queue.poll();
    //         if (isValid(str)) {
    //             res.add(str);
    //             found = true;
    //         }

    //         // Once found, no need to remove.
    //         if (found) {
    //             continue;
    //         }

    //         int N = str.length();
    //         for (int i = 0; i < N; ++i) {
    //             char c = str.charAt(i);
    //             if (c != '(' && c != ')') {  // c is letter.
    //                 continue;
    //             }

    //             String removed = str.substring(0, i) + str.substring(i + 1);
    //             if (!visited.contains(removed)) {
    //                 queue.offer(removed);
    //                 visited.add(removed);
    //             }
    //         }
    //     }
    //     return res;
    // }

    // private boolean isValid(String s) {
    //     int count = 0;
    //     for (char c : s.toCharArray()) {
    //         if (c == '(') {
    //             ++count;
    //         } else if (c == ')') {
    //             if (count == 0) {
    //                 return false;
    //             }

    //             --count;
    //         }
    //     }
    //     return count == 0;
    // }

    /**
     * Solution 2: DFS
     */
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        char[] par = new char[] {'(', ')'};
        remove(s, par, 0, 0, res);
        return res;
    }

    private void remove(String s, char[] par, int left, int right, 
                        List<String> res) {
        // If # par[1] > # par[0], then count < 0, need to remove.
        int count = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (c == par[0]) {
                ++count;
            }

            if (c == par[1]) {
                --count;
            }

            if (count >= 0) {
                ++right;
                continue;
            }

            // Invalid parenthesis found, remove it.
            // There might be multiple different left could be removed, each of
            // which corresponding to a valid result.
            while (left <= right) {
                // For cases like "())()", only remove the first invalid ')',
                // to avoid duplicates of "()()".
                if (s.charAt(left) != par[1] 
                        || left > 0 && s.charAt(left - 1) == par[1]) {
                    ++left;
                    continue;
                }

                String removed = s.substring(0, left) + s.substring(left + 1);
                // This will remove all invalid parentheses in `removed` and 
                // store all the valid results in `res`.
                remove(removed, par, left, right, res);
                ++left;
            }
            // After all invalid parentheses have been removed, return.
            return;
        }

        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') {  // Finished remove ')'.
            par = new char[] {')', '('};
            remove(reversed, par, 0, 0, res);
        } else {  // Finished remove '('.
            // Reverse two times to make valid parentheses the same as orginal.
            res.add(reversed);
        }
    }
}
// @lc code=end

