/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
 *
 * https://leetcode.com/problems/recover-binary-search-tree/description/
 *
 * algorithms
 * Medium (45.37%)
 * Likes:    5966
 * Dislikes: 193
 * Total Accepted:    353.7K
 * Total Submissions: 710.1K
 * Testcase Example:  '[1,3,null,null,2]'
 *
 * You are given the root of a binary search tree (BST), where the values of
 * exactly two nodes of the tree were swapped by mistake. Recover the tree
 * without changing its structure.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,3,null,null,2]
 * Output: [3,1,null,null,2]
 * Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3
 * makes the BST valid.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [3,1,4,null,null,2]
 * Output: [2,1,4,null,null,3]
 * Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2
 * and 3 makes the BST valid.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [2, 1000].
 * -2^31 <= Node.val <= 2^31 - 1
 * 
 * 
 * 
 * Follow up: A solution using O(n) space is pretty straight-forward. Could you
 * devise a constant O(1) space solution?
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
    // Must not pass as parameters prev, swap1, and swap2 to preorder!
    // Java is copy-by-value, the 64-bit address is also directly copied!
    private TreeNode prev = null, swap1 = null, swap2 = null;

    public void recoverTree(TreeNode root) {
        preorder(root);

        if (swap1 != null && swap2 != null) {
            int temp = swap1.val;
            swap1.val = swap2.val;
            swap2.val = temp;
        }
    }

    private void preorder(TreeNode root) {
        if (root == null) {
            return;
        }

        preorder(root.left);

        if (prev != null && root.val < prev.val) {
            if (swap1 == null) {
                swap1 = prev;
                swap2 = root;
            } else {
                swap2 = root;
            }
        }
        prev = root;

        preorder(root.right);
    }
}
// @lc code=end

