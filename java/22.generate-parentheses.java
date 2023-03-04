import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 *
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (72.32%)
 * Likes:    17131
 * Dislikes: 689
 * Total Accepted:    1.3M
 * Total Submissions: 1.9M
 * Testcase Example:  '3'
 *
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * 
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 * Input: n = 1
 * Output: ["()"]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 8
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1
    //  */
    // public List<String> generateParenthesis(int n) {
    //     Set<String> set = generateParenthesisHelper(n);
    //     return new ArrayList<>(set);
    // }

    // private Set<String> generateParenthesisHelper(int n) {
    //     Set<String> res = new HashSet<>();
    //     if (n == 1) {
    //         res.add("()");
    //         return res; 
    //     }

    //     Set<String> set = generateParenthesisHelper(n - 1);
    //     Deque<Integer> stack = new ArrayDeque<>();
    //     for (String s : set) {
    //         int N = s.length();
    //         for (int i = 0; i < N; ++i) {
    //             if (s.charAt(i) == '(') {
    //                 stack.push(i);
    //             } else {
    //                 String left = s.substring(0, i);
    //                 String right = s.substring(i);
    //                 res.add(left + "()" + right);
    //                 stack.pop();
    //             }
    //         }

    //         res.add(s + "()");
    //     }
    //     return res;
    // }

    /**
     * Solution 2: Backtracking
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        char[] arr = new char[2 * n];
        backtrack(res, arr, 0, 0, 0, n);
        return res;
    }

    private void backtrack(List<String> list, char[] arr, int i, 
                           int open, int close, int n) {
        if (i == 2 * n) {
            list.add(new String(arr));
            return;
        }

        if (open < n) {
            arr[i] = '(';
            backtrack(list, arr, i + 1, open + 1, close, n);
        }

        if (close < open) {
            arr[i] = ')';
            backtrack(list, arr, i + 1, open, close + 1, n);
        }
    }
}
// @lc code=end

