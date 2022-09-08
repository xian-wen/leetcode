import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 *
 * https://leetcode.com/problems/basic-calculator-ii/description/
 *
 * algorithms
 * Medium (42.02%)
 * Likes:    4826
 * Dislikes: 617
 * Total Accepted:    467.5K
 * Total Submissions: 1.1M
 * Testcase Example:  '"3+2*2"'
 *
 * Given a string s which represents an expression, evaluate this expression
 * and return its value. 
 * 
 * The integer division should truncate toward zero.
 * 
 * You may assume that the given expression is always valid. All intermediate
 * results will be in the range of [-2^31, 2^31 - 1].
 * 
 * Note: You are not allowed to use any built-in function which evaluates
 * strings as mathematical expressions, such as eval().
 * 
 * 
 * Example 1:
 * Input: s = "3+2*2"
 * Output: 7
 * Example 2:
 * Input: s = " 3/2 "
 * Output: 1
 * Example 3:
 * Input: s = " 3+5 / 2 "
 * Output: 5
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 3 * 10^5
 * s consists of integers and operators ('+', '-', '*', '/') separated by some
 * number of spaces.
 * s represents a valid expression.
 * All the integers in the expression are non-negative integers in the range
 * [0, 2^31 - 1].
 * The answer is guaranteed to fit in a 32-bit integer.
 * 
 * 
 */

// @lc code=start
// Solution 1:
// class Solution {
//     public int calculate(String s) {
//         if (s == null || s.isEmpty()) {
//             return 0;
//         }

//         List<String> tokens = parse(s);
//         return evaluate(tokens);
//     }

//     private List<String> parse(String s) {
//         s = s.replaceAll("\s+", "");
//         List<String> tokens = new ArrayList<>();
//         int num = 0;
//         for (char c : s.toCharArray()) {
//             if (Character.isDigit(c)) {
//                 num = num * 10 + (c - '0');
//             } else {
//                 tokens.add(String.valueOf(num));
//                 tokens.add(String.valueOf(c));
//                 num = 0;
//             }
//         }
//         tokens.add(String.valueOf(num));
//         return tokens;
//     }

//     private int evaluate(List<String> tokens) {
//         int pre = 0, res = 0, num = 0, n = tokens.size();
//         String op = "+"; 
//         for (int i = 0; i < n; ++i) {
//             String s = tokens.get(i);
//             if (s.matches("\\d+")) {
//                 num = Integer.parseInt(s);
//             }
            
//             if (!s.matches("\\d+") || i == n - 1) {
//                 switch (op) {
//                     case "+":
//                         res += pre;
//                         pre = num;
//                         break;
//                     case "-":
//                         res += pre;
//                         pre = -num;
//                         break;
//                     case "*":
//                         pre *= num;
//                         break;
//                     case "/":
//                         pre /= num;
//                         break;
//                     default:
//                         break;
//                 }
//                 op = s;
//                 num = 0;
//             }
//         }

//         return res + pre;
//     }
// }

// Solution 2:
class Solution {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        char[] charArr = s.toCharArray();
        int pre = 0, res = 0, num = 0;
        char op = '+';
        for (int i = 0; i < charArr.length; ++i) {
            boolean isDigit = Character.isDigit(charArr[i]);
            if (isDigit) {
                num = num * 10 + (charArr[i] - '0');
            }

            if (charArr[i] == '+' || charArr[i] == '-' 
                    || charArr[i] == '*' || charArr[i] == '/' 
                    || i == charArr.length - 1) {
                switch (op) {
                    case '+':
                        res += pre;
                        pre = num;
                        break;
                    case '-':
                        res += pre;
                        pre = -num;
                        break;
                    case '*':
                        pre *= num;
                        break;
                    case '/':
                        pre /= num;
                        break;
                    default:
                        break;
                }

                op = charArr[i];
                num = 0; 
            }
        }
        return res + pre;
    }
}
// @lc code=end

