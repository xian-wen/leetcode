import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=1008 lang=java
 *
 * [1008] Construct Binary Search Tree from Preorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/
 *
 * algorithms
 * Medium (81.06%)
 * Likes:    5075
 * Dislikes: 68
 * Total Accepted:    288.2K
 * Total Submissions: 355.2K
 * Testcase Example:  '[8,5,1,7,10,12]'
 *
 * Given an array of integers preorder, which represents the preorder traversal
 * of a BST (i.e., binary search tree), construct the tree and return its
 * root.
 * 
 * It is guaranteed that there is always possible to find a binary search tree
 * with the given requirements for the given test cases.
 * 
 * A binary search tree is a binary tree where for every node, any descendant
 * of Node.left has a value strictly less than Node.val, and any descendant of
 * Node.right has a value strictly greater than Node.val.
 * 
 * A preorder traversal of a binary tree displays the value of the node first,
 * then traverses Node.left, then traverses Node.right.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: preorder = [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: preorder = [1,3]
 * Output: [1,null,3]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= preorder.length <= 100
 * 1 <= preorder[i] <= 1000
 * All the values of preorder are unique.
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
    // private int pre, in;

    // /**
    //  * Solution 1: Sort to Get Inorder
    //  */
    // public TreeNode bstFromPreorder(int[] preorder) {
    //     int[] inorder = preorder.clone();
    //     Arrays.sort(inorder);
    //     return buildTree(preorder, inorder, Integer.MAX_VALUE);
    // }

    // /**
    //  * Ref: LeetCode 105
    //  */
    // private TreeNode buildTree(int[] preorder, int[] inorder, int stop) {
    //     if (pre >= preorder.length) {
    //         return null;
    //     }

    //     if (inorder[in] == stop) {
    //         ++in;
    //         return null;
    //     }

    //     TreeNode node = new TreeNode(preorder[pre++]);
    //     node.left = buildTree(preorder, inorder, node.val);
    //     node.right = buildTree(preorder, inorder, stop);
    //     return node;
    // }

    // /**
    //  * Solution 2: No Sort
    //  */
    // public TreeNode bstFromPreorder(int[] preorder) {
    //     return bstFromPreorder(preorder, 0, preorder.length - 1);
    // }

    // private TreeNode bstFromPreorder(int[] preorder, int start, int end) {
    //     if (start > end) {
    //         return null;
    //     }

    //     int root = preorder[start];
    //     int rightIndex = start + 1;
    //     // Find the index of the right child.
    //     while (rightIndex <= end && preorder[rightIndex] < root) {
    //         ++rightIndex;
    //     }

    //     TreeNode left = bstFromPreorder(preorder, start + 1, rightIndex - 1);
    //     TreeNode right = bstFromPreorder(preorder, rightIndex, end);
    //     return new TreeNode(root, left, right);
    // }

    // private int pre;

    // /**
    //  * Solution 3: MIN and MAX
    //  */
    // public TreeNode bstFromPreorder(int[] preorder) {
    //     return bstFromPreorder(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    // }

    // private TreeNode bstFromPreorder(int[] preorder, int min, int max) {
    //     if (pre == preorder.length || preorder[pre] < min 
    //             || preorder[pre] > max) {
    //         return null;
    //     }

    //     TreeNode node = new TreeNode(preorder[pre++]);
    //     node.left = bstFromPreorder(preorder, min, node.val);
    //     node.right = bstFromPreorder(preorder, node.val, max);
    //     return node;
    // }

    private int pre;

    /**
     * Solution 4: MAX Only
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE);
    }

    private TreeNode bstFromPreorder(int[] preorder, int max) {
        if (pre == preorder.length || preorder[pre] > max) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[pre++]);
        node.left = bstFromPreorder(preorder, node.val);
        node.right = bstFromPreorder(preorder, max);
        return node;
    }
}
// @lc code=end

