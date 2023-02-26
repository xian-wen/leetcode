/*
 * @lc app=leetcode id=474 lang=java
 *
 * [474] Ones and Zeroes
 *
 * https://leetcode.com/problems/ones-and-zeroes/description/
 *
 * algorithms
 * Medium (46.71%)
 * Likes:    4688
 * Dislikes: 419
 * Total Accepted:    165.8K
 * Total Submissions: 354.7K
 * Testcase Example:  '["10","0001","111001","1","0"]\n5\n3'
 *
 * You are given an array of binary strings strs and two integers m and n.
 * 
 * Return the size of the largest subset of strs such that there are at most m
 * 0's and n 1's in the subset.
 * 
 * A set x is a subset of a set y if all elements of x are also elements of
 * y.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
 * Output: 4
 * Explanation: The largest subset with at most 5 0's and 3 1's is {"10",
 * "0001", "1", "0"}, so the answer is 4.
 * Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
 * {"111001"} is an invalid subset because it contains 4 1's, greater than the
 * maximum of 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: strs = ["10","0","1"], m = 1, n = 1
 * Output: 2
 * Explanation: The largest subset is {"0", "1"}, so the answer is 2.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] consists only of digits '0' and '1'.
 * 1 <= m, n <= 100
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * Similar to Knapsack without repetition (space optimization).
     * 
     * Subproblem:
     * size[i][j] = the size of the largest subset of strs such that there are
     * at most i 0's and j 1's in the subset. 
     * 
     * Recursive relation:
     * size[i][j] = max{1 + size[i-zeros(strs[k])[j-ones(strs[k])]} if zeros(strs[k]) <= i && ones(strs[k]) <= j
     * size[0][j] = 0
     * size[i][0] = 0
     * 
     * Time complexity:
     * O(Nmn)
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] size = new int[m + 1][n + 1];
        for (String str : strs) {
            int zeros = count01(str)[0], ones = count01(str)[1];
            for (int i = m; i >= zeros; --i) {
                for (int j = n; j >= ones; --j) {
                    size[i][j] = Math.max(size[i][j], 1 + size[i - zeros][j - ones]);
                }
            }
        }
        return size[m][n];
    }

    private int[] count01(String s) {
        int N = s.length();
        int[] res = new int[2];
        for (int i = 0; i < N; ++i) {
            char c = s.charAt(i);
            if (c == '0') {
                ++res[0];
            } else {
                ++res[1];
            }
        }
        return res;
    }
}
// @lc code=end

