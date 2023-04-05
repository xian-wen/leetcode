import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=1541 lang=java
 *
 * [1541] Minimum Insertions to Balance a Parentheses String
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Stack
    //  */
    // public int minInsertions(String s) {
    //     Deque<Integer> stack = new ArrayDeque<>();
    //     int res = 0;
    //     for (char c : s.toCharArray()) {
    //         if (c == '(') {
    //             if (stack.isEmpty() || stack.peek() == 2) {
    //                 // For "(" or "((".
    //                 stack.push(2);
    //             } else {  // stack.peek() = 1
    //                 // For "()(" -> "())(" -> "())())".
    //                 stack.pop();
    //                 stack.push(2);
    //                 ++res;
    //             }
    //         } else {
    //             if (stack.isEmpty()) {
    //                 // For ")" -> "())".
    //                 stack.push(1);
    //                 ++res;
    //             } else if (stack.peek() == 1) {
    //                 // For "())".
    //                 stack.pop();
    //             } else {  // stack.peek() = 2
    //                 // For "()".
    //                 stack.pop();
    //                 stack.push(1);
    //             }
    //         }
    //     }

    //     while (!stack.isEmpty()) {
    //         res += stack.pop();
    //     }
    //     return res;
    // }

    /**
     * Solution 2: No Stack
     */
    public int minInsertions(String s) {
        int resNeed = 0, closeNeed = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                // For "()(", frist convert to "())(", then "())())". 
                // If no consecutive requirement, this if is not needed.
                if (closeNeed % 2 == 1) {
                    ++resNeed;
                    --closeNeed;
                }

                // For "(", needs "))".
                closeNeed += 2;
            } else if (closeNeed > 0) {
                // For "()", only one ")" is needed.
                --closeNeed;
            } else {
                // For ")", "())" is valid.
                ++resNeed;
                ++closeNeed;
            }
        }
        return resNeed + closeNeed;
    }
}
// @lc code=end

