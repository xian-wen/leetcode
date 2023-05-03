/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
 *
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
 *
 * algorithms
 * Medium (61.59%)
 * Likes:    10094
 * Dislikes: 504
 * Total Accepted:    755K
 * Total Submissions: 1.2M
 * Testcase Example:  '[1,2,5,3,4,null,6]'
 *
 * Given the root of a binary tree, flatten the tree into a "linked
 * list":
 * 
 * 
 * The "linked list" should use the same TreeNode class where the right child
 * pointer points to the next node in the list and the left child pointer is
 * always null.
 * The "linked list" should be in the same order as a pre-order traversal of
 * the binary tree.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,5,3,4,null,6]
 * Output: [1,null,2,null,3,null,4,null,5,null,6]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = []
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = [0]
 * Output: [0]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 2000].
 * -100 <= Node.val <= 100
 * 
 * 
 * 
 * Follow up: Can you flatten the tree in-place (with O(1) extra space)?
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
    //  * Solution 1: Iteration
    //  */
    // public void flatten(TreeNode root) {
    //     while (root != null) {
    //         if (root.left != null) {
    //             TreeNode leftRight = root.left;
    //             while (leftRight.right != null) {
    //                 leftRight = leftRight.right;
    //             }
    
    //             leftRight.right = root.right;
    //             root.right = root.left;
    //             root.left = null;
    //         }

    //         root = root.right;
    //     }
    // }

    // private TreeNode prev = null;

    // /**
    //  * Solution 2: Recursion
    //  * 
    //  * Reversed preorder (right, left, root).
    //  */
    // public void flatten(TreeNode root) {
    //     if (root == null) {
    //         return;
    //     }

    //     flatten(root.right);
    //     flatten(root.left);

    //     root.right = prev;
    //     root.left = null;
    //     prev = root;
    // }

    /**
     * Solution 3: Recursion without global variable
     * 
     * Reversed preorder (right, left, root).
     */
    public void flatten(TreeNode root) {
        root = flatten(root, null);
    }

    private TreeNode flatten(TreeNode root, TreeNode prev) {
        if (root == null) {
            return prev;
        }

        TreeNode right = flatten(root.right, prev);
        TreeNode left = flatten(root.left, right);

        root.right = left;
        root.left = null;
        return root;
    }
}
// @lc code=end

