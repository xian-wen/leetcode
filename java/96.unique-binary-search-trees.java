/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 *
 * https://leetcode.com/problems/unique-binary-search-trees/description/
 *
 * algorithms
 * Medium (59.53%)
 * Likes:    8827
 * Dislikes: 352
 * Total Accepted:    556.3K
 * Total Submissions: 934K
 * Testcase Example:  '3'
 *
 * Given an integer n, return the number of structurally unique BST's (binary
 * search trees) which has exactly n nodes of unique values from 1 to n.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 3
 * Output: 5
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 1
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 19
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * Subproblem:
     * bst[i] = the number of structurally unique BST's having exactly i nodes 
     * of unique value from 1 to i.
     * 
     * Recurrence relation:
     * bst[i] = sum(bst[tree[1..(j-1)]] * bst[tree[(j+1)..i]]) where j is the root
     *        = bst[0] * bst[i-1] + bst[1] * bst[i-2] + ... + bst[i-1] * bst[0] 
     *        = sum(bst[j-1] * bst[i-j]) where 1 <= j <= i
     * bst[0] = 1  // empty tree
     * 
     * Time complexity:
     * O(n^2)
     */
    public int numTrees(int n) {
        int[] bst = new int[n + 1];
        bst[0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                bst[i] += bst[j - 1] * bst[i - j];
            }
        }
        return bst[n];
    }
}
// @lc code=end

