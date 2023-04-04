import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (36.01%)
 * Total Accepted:    541.2K
 * Total Submissions: 1.5M
 * Testcase Example:  '"()"'
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * 
 * 
 * Note that an empty string is also considered valid.
 * 
 * Example 1:
 * 
 * 
 * Input: "()"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "()[]{}"
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "(]"
 * Output: false
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: "([)]"
 * Output: false
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: "{[]}"
 * Output: true
 * 
 * 
 */
class Solution {
    // /**
    //  * Solution 1
    //  */
    // public boolean isValid(String s) {
    //     Deque<Character> stack = new ArrayDeque<>();
    //     for (char c : s.toCharArray()) {
    //         if (stack.isEmpty()) {
    //             stack.push(c);
    //             continue;
    //         }
            
    //         if (isMatch(stack.peek(), c)) {
    //             stack.pop();
    //         } else {
    //             stack.push(c);
    //         }
    //     }
    //     return stack.isEmpty();
    // }

    // private boolean isMatch(char c1, char c2) {
    //     return (c1 == '(' && c2 == ')')
    //             || (c1 == '[' && c2 == ']')
    //             || (c1 == '{' && c2 == '}');
    // }

    /**
     * Solution 2
     */
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}

