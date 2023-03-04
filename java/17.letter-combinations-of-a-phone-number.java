import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (56.23%)
 * Likes:    14264
 * Dislikes: 820
 * Total Accepted:    1.5M
 * Total Submissions: 2.7M
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent. Return the answer in
 * any order.
 * 
 * A mapping of digits to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: digits = ""
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: digits = "2"
 * Output: ["a","b","c"]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 * 
 * 
 */

// @lc code=start
class Solution {
    // private List<String>[] list;

    // /**
    //  * Solution 1: Recursion
    //  */
    // public List<String> letterCombinations(String digits) {
    //     if (digits.isEmpty()) {
    //         return new ArrayList<>();
    //     }

    //     list = new List[] {
    //         List.of(),
    //         List.of(),
    //         List.of("a", "b", "c"),
    //         List.of("d", "e", "f"),
    //         List.of("g", "h", "i"),
    //         List.of("j", "k", "l"),
    //         List.of("m", "n", "o"),
    //         List.of("p", "q", "r", "s"),
    //         List.of("t", "u", "v"),
    //         List.of("w", "x", "y", "z")
    //     };
    //     return letterCombinationsHelper(digits);
    // }

    // private List<String> letterCombinationsHelper(String digits) {
    //     List<String> first = list[digits.charAt(0) - '0'];
    //     if (digits.length() == 1) {
    //         return first;
    //     }
        
    //     List<String> next = letterCombinationsHelper(digits.substring(1));
    //     List<String> res = new ArrayList<>();
    //     for (String f : first) {
    //         for (String n : next) {
    //             res.add(f + n);
    //         }
    //     }
    //     return res;
    // }

    /**
     * Solution 2: Backtracking
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) {
            return res;
        }

        String[] dict = new String[] {
            "", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"
        };
        backtrack(digits, 0, dict, res, "");
        return res;
    }

    private void backtrack(String digits, int index, String[] dict, 
                           List<String> list, String prev) {
        if (index == digits.length()) {
            list.add(prev);
            return;
        }

        String cur = dict[digits.charAt(index) - '0'];
        int N = cur.length();
        for (int i = 0; i < N; ++i) {
            // Avoid `prev + cur.charAt(i)` since it is extremely slow!
            backtrack(digits, index + 1, dict, list, prev + cur.substring(i, i + 1));
        }
    }
}
// @lc code=end

