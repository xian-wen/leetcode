/*
 * @lc app=leetcode id=190 lang=java
 *
 * [190] Reverse Bits
 *
 * https://leetcode.com/problems/reverse-bits/description/
 *
 * algorithms
 * Easy (53.45%)
 * Likes:    4124
 * Dislikes: 1076
 * Total Accepted:    596.6K
 * Total Submissions: 1.1M
 * Testcase Example:  '00000010100101000001111010011100'
 *
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * Note:
 * 
 * 
 * Note that in some languages, such as Java, there is no unsigned integer
 * type. In this case, both input and output will be given as a signed integer
 * type. They should not affect your implementation, as the integer's internal
 * binary representation is the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement
 * notation. Therefore, in Example 2 above, the input represents the signed
 * integer -3 and the output represents the signed integer -1073741825.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 00000010100101000001111010011100
 * Output:    964176192 (00111001011110000010100101000000)
 * Explanation: The input binary string 00000010100101000001111010011100
 * represents the unsigned integer 43261596, so return 964176192 which its
 * binary representation is 00111001011110000010100101000000.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 11111111111111111111111111111101
 * Output:   3221225471 (10111111111111111111111111111111)
 * Explanation: The input binary string 11111111111111111111111111111101
 * represents the unsigned integer 4294967293, so return 3221225471 which its
 * binary representation is 10111111111111111111111111111111.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The input must be a binary string of length 32
 * 
 * 
 * 
 * Follow up: If this function is called many times, how would you optimize it?
 * 
 */

// @lc code=start
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        return reverseBits(n, 0, 0);
    }

    /**
     * Tail recursion.
     */
    private int reverseBits(int n, int count, int res) {
        if (count == 32) {
            return res;
        }
        
        int last = n & 1;
        int next = n >> 1;
        res = (res << 1) + last;
        return reverseBits(next, count + 1, res);
    }
}
// @lc code=end

