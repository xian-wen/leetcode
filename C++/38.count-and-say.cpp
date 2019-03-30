/*
 * @lc app=leetcode id=38 lang=cpp
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
public:
    string countAndSay(int n) {
        string str = "1"; // n=1

        for (int i = 0; i < n - 1; i++) { // 第n个字符串通过第n-1个求得
            string tem_str = ""; // 每次初始化为空

            for (int j = 0; j < str.size(); j++) {
                int count = 1; // 每个数字至少出现一次

                // 相同的数字直接跳过并计数
                while (j + 1 < str.size() && str[j + 1] == str[j]) {
                    count++;
                    j++;
                }

                // tem_str尾部添加字符个数及字符
                tem_str += count + '0';
                tem_str += str[j];
            }

            str = tem_str; // 更新str
        }

        return str;
    }
};

