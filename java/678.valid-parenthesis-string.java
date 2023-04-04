/*
 * @lc app=leetcode id=678 lang=java
 *
 * [678] Valid Parenthesis String
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1
    //  * 
    //  * countMin: # '(' must be paired
    //  * countMax: # '(' could be paired
    //  * 
    //  * countMin: count '*' as ')'
    //  * countMax: count '*' as '('
    //  * 
    //  * countMin must not < 0:
    //  * ')' should not match '(' after it,
    //  * i.e., )( or *(
    //  */
    // public boolean checkValidString(String s) {
    //     int countMin = 0, countMax = 0;
    //     for (char c : s.toCharArray()) {
    //         if (c == '(') {
    //             ++countMin;
    //             ++countMax;
    //         } else if (c == ')') {
    //             --countMax;
    //             countMin = Math.max(countMin - 1, 0);
    //         } else {  // c = *
    //             ++countMax;
    //             countMin = Math.max(countMin - 1, 0);
    //         }

    //         if (countMax < 0) {
    //             return false;
    //         }
    //     }
    //     return countMin == 0;
    // }

    /**
     * Solution 2: Simplified
     */
    public boolean checkValidString(String s) {
        int countMin = 0, countMax = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                ++countMin;
            } else {  // ')' or '*'
                countMin = Math.max(countMin - 1, 0);
            }

            if (c == ')') {
                --countMax;
            } else {  // '(' or '*'
                ++countMax;
            }

            if (countMax < 0) {
                return false;
            }
        }
        return countMin == 0;
    }
}
// @lc code=end

