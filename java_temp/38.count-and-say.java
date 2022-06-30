/*
 * @lc app=leetcode id=38 lang=java
 *
 * [38] Count and Say
 *
 * https://leetcode.com/problems/count-and-say/description/
 *
 * algorithms
 * Easy (39.69%)
 * Total Accepted:    266.4K
 * Total Submissions: 669.1K
 * Testcase Example:  '1'
 *
 * The count-and-say sequence is the sequence of integers with the first five
 * terms as following:
 * 
 * 
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * 
 * Given an integer n where 1 ≤ n ≤ 30, generate the n^th term of the
 * count-and-say sequence.
 * 
 * Note: Each term of the sequence of integers will be represented as a
 * string.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: 1
 * Output: "1"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 4
 * Output: "1211"
 * 
 */
class Solution {
    public String countAndSay(int n) {
        String s = "1"; // n = 1

        for (int i = 0; i < n - 1; i++) { // use n-1 to get n
            String tmp = ""; // init tmp

            for (int j = 0; j < s.length(); j++) {
                int count = 1; // at least 1 char
                
                // pass and count the same char
                while (j + 1 < s.length() && s.charAt(j + 1) == s.charAt(j)) {
                    count++;
                    j++;
                }

                // add count and char at the back
                tmp += count + "";
                tmp += s.charAt(j);
            }

            s = tmp; // update s
        }

        return s;
    }
}

