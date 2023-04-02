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
    // /**
    //  * Solution 1: With Map
    //  */
    // public TreeNode buildTree(int[] inorder, int[] postorder) {
    //     Map<Integer, Integer> inMap = new HashMap<>();
    //     int N = inorder.length;
    //     for (int i = 0; i < N; ++i) {
    //         inMap.put(inorder[i], i);
    //     }
    //     return buildTree(inMap, postorder, 0, N - 1, 0, N - 1);
    // }

    // private TreeNode buildTree(Map<Integer, Integer> inMap, int[] postorder, 
    //                            int inLeft, int inRight, 
    //                            int postLeft, int postRight) {
    //     if (inLeft > inRight) {
    //         return null;
    //     }
        
    //     int root = postorder[postRight];
    //     int rootIndex = inMap.get(root);
    //     int rightLen = inRight - rootIndex;
    //     TreeNode left = buildTree(inMap, postorder, inLeft, rootIndex - 1, 
    //                               postLeft, postRight - rightLen - 1);
    //     TreeNode right = buildTree(inMap, postorder, rootIndex + 1, inRight, 
    //                                postRight - rightLen, postRight - 1);
    //     return new TreeNode(root, left, right);
    // }

    private int in, post;

    /**
     * Solution 2: No Map
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        in = inorder.length - 1;
        post = postorder.length - 1;
        return buildTree(inorder, postorder, Integer.MAX_VALUE);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int stop) {
        if (post < 0) {
            return null;
        }

        if (inorder[in] == stop) {
            --in;
            return null;
        }

        TreeNode node = new TreeNode(postorder[post--]);
        node.right = buildTree(inorder, postorder, node.val);
        node.left = buildTree(inorder, postorder, stop);
        return node;
    }
}
// @lc code=end

