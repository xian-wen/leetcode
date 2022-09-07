import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 *
 * https://leetcode.com/problems/isomorphic-strings/description/
 *
 * algorithms
 * Easy (42.44%)
 * Likes:    4706
 * Dislikes: 853
 * Total Accepted:    623.2K
 * Total Submissions: 1.5M
 * Testcase Example:  '"egg"\n"add"'
 *
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings s and t are isomorphic if the characters in s can be replaced to
 * get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character, but a character may map to itself.
 * 
 * 
 * Example 1:
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 * Input: s = "paper", t = "title"
 * Output: true
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 5 * 10^4
 * t.length == s.length
 * s and t consist of any valid ascii character.
 * 
 * 
 */

// @lc code=start
// Solution 1:
// class Solution {
//     public boolean isIsomorphic(String s, String t) {
//         if (s == null || t == null) {
//             return s == t;
//         }

//         if (s.length() != t.length()) {
//             return false;
//         }

//         Map<Character, Character> mapS = new HashMap<>();
//         Map<Character, Character> mapT = new HashMap<>();
//         for (int i = 0; i < s.length(); ++i) {
//             char sc = s.charAt(i);
//             char tc = t.charAt(i);
//             if (!check(mapS, sc, tc) || !check(mapT, tc, sc)) {
//                 return false;
//             }
//         }
//         return true;
//     }

//     private boolean check(Map<Character, Character> map, char sc, char tc) {
//         if (!map.containsKey(sc)) {
//             map.put(sc, tc);
//         } else if (map.get(sc) != tc) {
//             return false;
//         }
//         return true;
//     }
// }

// Solution 2:
class Solution {
    private static final int R = 128;

    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return s == t;
        }

        if (s.length() != t.length()) {
            return false;
        }

        int[] firstIndexS = new int[R];
        int[] firstIndexT = new int[R];
        for (int i = 0; i < s.length(); ++i) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (firstIndexS[sc] != firstIndexT[tc]) {
                return false;
            }

            firstIndexS[sc] = i + 1;
            firstIndexT[tc] = i + 1;
        }
        return true;
    }
}
// @lc code=end

