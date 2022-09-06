import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 *
 * https://leetcode.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (62.55%)
 * Likes:    6840
 * Dislikes: 238
 * Total Accepted:    1.6M
 * Total Submissions: 2.6M
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * Given two strings s and t, return true if t is an anagram of s, and false
 * otherwise.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * 
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length, t.length <= 5 * 10^4
 * s and t consist of lowercase English letters.
 * 
 * 
 * 
 * Follow up: What if the inputs contain Unicode characters? How would you
 * adapt your solution to such a case?
 * 
 */

// @lc code=start
// Solution 1:
// class Solution {
//     public boolean isAnagram(String s, String t) {
//         if (s == null || t == null) {
//             return s == t;
//         }

//         if (s.length() != t.length()) {
//             return false;
//         }

//         Map<Character, Integer> mapS = count(s);
//         Map<Character, Integer> mapT = count(t);
//         for (char c : mapS.keySet()) {
//             if (!mapT.containsKey(c) 
//                     || mapS.get(c).intValue() != mapT.get(c).intValue()) {
//                 return false;
//             }
//         }
//         return true;
//     }

//     private Map<Character, Integer> count(String s) {
//         Map<Character, Integer> map = new HashMap<>();
//         if (s == null || s.isEmpty()) {
//             return map;
//         }

//         for (int i = 0; i < s.length(); ++i) {
//             char c = s.charAt(i);
//             map.put(c, map.getOrDefault(c, 0) + 1);
//         }
//         return map;
//     }
// }

// Solution 2:
class Solution {
    private static final int R = 26;

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return s == t;
        }

        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[R];
        for (char c : s.toCharArray()) {
            ++count[c - 'a'];
        }

        for (char c : t.toCharArray()) {
            --count[c - 'a'];
        }
        
        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

