import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=678 lang=java
 *
 * [678] Valid Parenthesis String
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Two Stacks
    //  */
    // public boolean checkValidString(String s) {
    //     Deque<Integer> openStack = new ArrayDeque<>();
    //     Deque<Integer> starStack = new ArrayDeque<>();
    //     int N = s.length();
    //     for (int i = 0; i < N; ++i) {
    //         char c = s.charAt(i);
    //         if (c == '(') {
    //             openStack.push(i);
    //         } else if (c == '*') {
    //             starStack.push(i);
    //         } else {  // )
    //             if (openStack.isEmpty() && starStack.isEmpty()) {
    //                 return false;
    //             }

    //             if (!openStack.isEmpty()) {
    //                 openStack.pop();
    //             } else {
    //                 starStack.pop();
    //             }
    //         }
    //     }

    //     while (!openStack.isEmpty() && !starStack.isEmpty()) {
    //         // '(' must be in front of '*',
    //         // i.e., *( is invalid.
    //         if (openStack.pop() > starStack.pop()) {
    //             return false;
    //         }
    //     }
    //     return openStack.isEmpty();
    // }

    /**
     * Solution 2: countMin + countMax
     * 
     * countMin: # '(' must be paired
     * countMax: # '(' could be paired
     * 
     * countMin: count '*' as ')'
     * countMax: count '*' as '('
     * 
     * countMin must not < 0:
     * ')' should not match '(' after it,
     * i.e., )( or *(
     */
    public boolean checkValidString(String s) {
        int countMin = 0, countMax = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                ++countMin;
                ++countMax;
            } else if (c == ')') {
                --countMax;
                countMin = Math.max(countMin - 1, 0);
            } else {  // c = *
                ++countMax;
                countMin = Math.max(countMin - 1, 0);
            }

            if (countMax < 0) {
                return false;
            }
        }
        return countMin == 0;
    }

    // /**
    //  * Solution 3: countMin + countMax (Simplified)
    //  */
    // public boolean checkValidString(String s) {
    //     int countMin = 0, countMax = 0;
    //     for (char c : s.toCharArray()) {
    //         if (c == '(') {
    //             ++countMin;
    //         } else {  // ')' or '*'
    //             countMin = Math.max(countMin - 1, 0);
    //         }

    //         if (c == ')') {
    //             --countMax;
    //         } else {  // '(' or '*'
    //             ++countMax;
    //         }

    //         if (countMax < 0) {
    //             return false;
    //         }
    //     }
    //     return countMin == 0;
    // }

    // /**
    //  * Solution 4: Count
    //  */
    // public boolean checkValidString(String s) {
    //     return checkValidString(s, '(');
    // }

    // private boolean checkValidString(String s, char par) {
    //     int N = s.length(), count = 0;
    //     for (int i = 0; i < N; ++i) {
    //         char c = s.charAt(i);
    //         // count '*' as par.
    //         if (c == par || c == '*') {
    //             ++count;
    //         } else {
    //             --count;
    //             if (count < 0) {
    //                 return false;
    //             }
    //         }
    //     }

    //     if (count == 0) {
    //         return true;
    //     }

    //     String reversed = new StringBuilder(s).reverse().toString();
    //     if (par == '(') {
    //         return checkValidString(reversed, ')');
    //     }
    //     return true;
    // }
}
// @lc code=end

