import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (57.95%)
 * Likes:    5760
 * Dislikes: 86
 * Total Accepted:    463K
 * Total Submissions: 797.6K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * Given two integer arrays inorder and postorder where inorder is the inorder
 * traversal of a binary tree and postorder is the postorder traversal of the
 * same tree, construct and return the binary tree.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * Output: [3,9,20,null,null,15,7]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: inorder = [-1], postorder = [-1]
 * Output: [-1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder and postorder consist of unique values.
 * Each value of postorder also appears in inorder.
 * inorder is guaranteed to be the inorder traversal of the tree.
 * postorder is guaranteed to be the postorder traversal of the tree.
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
    private int[] postorder;
    private Map<Integer, Integer> inMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            inMap.put(inorder[i], i);
        }
        return buildTree(0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int leftIn, int rightIn, int leftPost, int rightPost) {
        if (leftIn > rightIn || leftPost > rightPost) {
            return null;
        }

        int rootVal = postorder[rightPost];
        int rootIn = inMap.get(rootVal);
        int leftSize = rootIn - leftIn;
        TreeNode left = buildTree(leftIn, rootIn - 1, leftPost, leftPost + leftSize - 1);
        TreeNode right = buildTree(rootIn + 1, rightIn, leftPost + leftSize, rightPost - 1);
        return new TreeNode(rootVal, left, right);
    }
}
// @lc code=end

