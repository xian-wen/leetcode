/*
 * @lc app=leetcode id=344 lang=java
 *
 * [344] Reverse String
 *
 * https://leetcode.com/problems/reverse-string/description/
 *
 * algorithms
 * Easy (62.86%)
 * Total Accepted:    398.2K
 * Total Submissions: 631.9K
 * Testcase Example:  '["h","e","l","l","o"]'
 *
 * Write a function that reverses a string. The input string is given as an
 * array of characters char[].
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * You may assume all the characters consist of printable ascii
 * characters.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 * 
 * 
 * 
 * 
 */

/* 
class Solution {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            // swap s[i] and s[j]
            char tmp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = tmp;
        }
    }
}
 */

/* 
class Solution {
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            // swap s[i] and s[j]
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;

            i++;
            j--;
        }
    }
}
 */

/* 
class Solution {
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            // swap s[i] and s[j]
            s[i] = (char)(s[i] ^ s[j]);
            s[j] = (char)(s[i] ^ s[j]);
            s[i] = (char)(s[i] ^ s[j]);

            i++;
            j--;
        }
    }
}
 */

class Solution {
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            // swap s[i] and s[j]
            s[i] ^= s[j];
            s[j] ^= s[i];
            s[i++] ^= s[j--];
        }
    }
}

