import java.util.Deque;

/*
 * @lc app=leetcode id=538 lang=java
 *
 * [538] Convert BST to Greater Tree
 *
 * https://leetcode.com/problems/convert-bst-to-greater-tree/description/
 *
 * algorithms
 * Medium (67.65%)
 * Likes:    4724
 * Dislikes: 168
 * Total Accepted:    263.4K
 * Total Submissions: 389K
 * Testcase Example:  '[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]'
 *
 * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree
 * such that every key of the original BST is changed to the original key plus
 * the sum of all keys greater than the original key in BST.
 * 
 * As a reminder, a binary search tree is a tree that satisfies these
 * constraints:
 * 
 * 
 * The left subtree of a node contains only nodes with keys less than the
 * node's key.
 * The right subtree of a node contains only nodes with keys greater than the
 * node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [0,null,1]
 * Output: [1,null,1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 10^4].
 * -10^4 <= Node.val <= 10^4
 * All the values in the tree are unique.
 * root is guaranteed to be a valid binary search tree.
 * 
 * 
 * 
 * Note: This question is the same as 1038:
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
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
    //  * Solution 1: Iteration
    //  * 
    //  * Reversed inorder traversal (right, root, left).
    //  */
    // public TreeNode convertBST(TreeNode root) {
    //     Deque<TreeNode> stack = new ArrayDeque<>();
    //     TreeNode node = root, prev = null;
    //     while (node != null || !stack.isEmpty()) {
    //         while (node != null) {
    //             stack.push(node);
    //             node = node.right;
    //         }

    //         node = stack.pop();
    //         if (prev != null) {
    //             node.val += prev.val;
    //         }

    //         prev = node;
    //         node = node.left;
    //     }
    //     return root;
    // }

    // private int prev;

    // /**
    //  * Solution 2: Recursion
    //  * 
    //  * Reversed inorder traversal (right, root, left).
    //  */
    // public TreeNode convertBST(TreeNode root) {
    //     convertBSTHelper(root);
    //     return root;
    // }

    // public void convertBSTHelper(TreeNode root) {
    //     if (root == null) {
    //         return;
    //     }

    //     convertBSTHelper(root.right);
    //     root.val += prev;
    //     prev = root.val;
    //     convertBSTHelper(root.left);
    // }

    // /**
    //  * Solution 3: Recursion without Global Variable I
    //  * 
    //  * Reversed inorder traversal (right, root, left).
    //  */
    // public TreeNode convertBST(TreeNode root) {
    //     convertBST(root, 0);
    //     return root;
    // }

    // private int convertBST(TreeNode root, int prev) {
    //     if (root == null) {
    //         return prev;
    //     }

    //     int right = convertBST(root.right, prev);
    //     root.val += right;
    //     return convertBST(root.left, root.val);
    // }

    /**
     * Solution 4: Recursion without Global Variable II
     * 
     * Reversed inorder traversal (right, root, left).
     */
    public TreeNode convertBST(TreeNode root) {
        convertBST(root, null);
        return root;
    }

    private TreeNode convertBST(TreeNode root, TreeNode prev) {
        if (root == null) {
            return prev;
        }

        TreeNode right = convertBST(root.right, prev);
        if (right != null) {
            root.val += right.val;
        }
        return convertBST(root.left, root);
    }
}
// @lc code=end

