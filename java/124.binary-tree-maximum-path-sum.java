/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
 *
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 *
 * algorithms
 * Hard (39.15%)
 * Likes:    13597
 * Dislikes: 632
 * Total Accepted:    944.7K
 * Total Submissions: 2.4M
 * Testcase Example:  '[1,2,3]'
 *
 * A path in a binary tree is a sequence of nodes where each pair of adjacent
 * nodes in the sequence has an edge connecting them. A node can only appear in
 * the sequence at most once. Note that the path does not need to pass through
 * the root.
 * 
 * The path sum of a path is the sum of the node's values in the path.
 * 
 * Given the root of a binary tree, return the maximum path sum of any
 * non-empty path.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3]
 * Output: 6
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 =
 * 6.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 +
 * 7 = 42.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [1, 3 * 10^4].
 * -1000 <= Node.val <= 1000
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int maxSum;

    /**
     * Similar to LeetCode 543.
     */
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxPathSumHalf(root);
        return maxSum;
    }

    /**
     * Returns the max sum of a path including root and one of its branches.
     */
    private int maxPathSumHalf(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Do not consider branch with negative path sum.
        int leftSum = Math.max(maxPathSumHalf(root.left), 0);
        int rightSum = Math.max(maxPathSumHalf(root.right), 0);
        int rootSum = root.val + leftSum + rightSum;
        maxSum = Math.max(maxSum, rootSum);
        // For a valid subpath, only root and one of its branches will be included.
        return root.val + Math.max(leftSum, rightSum);
    }
}
// @lc code=end

