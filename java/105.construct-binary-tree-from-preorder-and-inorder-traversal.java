import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (56.23%)
 * Likes:    10719
 * Dislikes: 289
 * Total Accepted:    832.8K
 * Total Submissions: 1.4M
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * Given two integer arrays preorder and inorder where preorder is the preorder
 * traversal of a binary tree and inorder is the inorder traversal of the same
 * tree, construct and return the binary tree.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder and inorder consist of unique values.
 * Each value of inorder also appears in preorder.
 * preorder is guaranteed to be the preorder traversal of the tree.
 * inorder is guaranteed to be the inorder traversal of the tree.
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        int N = inorder.length;
        for (int i = 0; i < N; ++i) {
            inMap.put(inorder[i], i);
        }
        return buildTree(preorder, inMap, 0, N - 1, 0, N - 1);
    }

    private TreeNode buildTree(int[] preorder, Map<Integer, Integer> inMap, 
                               int preLeft, int preRight, 
                               int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }

        int root = preorder[preLeft];
        int rootIndex = inMap.get(root);
        int leftLen = rootIndex - inLeft;
        TreeNode left = buildTree(preorder, inMap, preLeft + 1, 
                                  preLeft + leftLen, inLeft, rootIndex - 1);
        TreeNode right = buildTree(preorder, inMap, preLeft + leftLen + 1, 
                                   preRight, rootIndex + 1, inRight);
        return new TreeNode(root, left, right);
    }
}
// @lc code=end

