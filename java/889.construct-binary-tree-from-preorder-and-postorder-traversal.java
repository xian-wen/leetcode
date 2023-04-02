import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=889 lang=java
 *
 * [889] Construct Binary Tree from Preorder and Postorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (70.96%)
 * Likes:    2444
 * Dislikes: 98
 * Total Accepted:    87.6K
 * Total Submissions: 123.4K
 * Testcase Example:  '[1,2,4,5,3,6,7]\n[4,5,2,6,7,3,1]'
 *
 * Given two integer arrays, preorder and postorder where preorder is the
 * preorder traversal of a binary tree of distinct values and postorder is the
 * postorder traversal of the same tree, reconstruct and return the binary
 * tree.
 * 
 * If there exist multiple answers, you can return any of them.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
 * Output: [1,2,3,4,5,6,7]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: preorder = [1], postorder = [1]
 * Output: [1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= preorder.length <= 30
 * 1 <= preorder[i] <= preorder.length
 * All the values of preorder are unique.
 * postorder.length == preorder.length
 * 1 <= postorder[i] <= postorder.length
 * All the values of postorder are unique.
 * It is guaranteed that preorder and postorder are the preorder traversal and
 * postorder traversal of the same binary tree.
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
    // public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
    //     Map<Integer, Integer> postMap = new HashMap<>();
    //     int N = preorder.length;
    //     for (int i = 0; i < N; ++i) {
    //         postMap.put(postorder[i], i);
    //     }
    //     return buildTree(preorder, postMap, 0, N - 1, 0, N - 1);
    // }

    // private TreeNode buildTree(int[] preorder, Map<Integer, Integer> postMap,
    //                            int preLeft, int preRight, 
    //                            int postLeft, int postRight) {
    //     if (preLeft > preRight) {
    //         return null;
    //     }
        
    //     if (preLeft == preRight) {
    //         return new TreeNode(preorder[preLeft]);
    //     }

    //     int root = preorder[preLeft];
    //     int leftIndex = postMap.get(preorder[preLeft + 1]);
    //     int leftLen = leftIndex - postLeft + 1;
    //     TreeNode left = buildTree(preorder, postMap, preLeft + 1, 
    //                               preLeft + leftLen, postLeft, leftIndex);
    //     TreeNode right = buildTree(preorder, postMap, preLeft + leftLen + 1, 
    //                                preRight, leftIndex + 1, postRight - 1);
    //     return new TreeNode(root, left, right);
    // }

    private int pre, post;

    /**
     * Solution 2: No Map
     * 
     * Use preorder[i] to construct the tree, and postorder[i] to check whether 
     * it still has children to be constructed.
     * postorder[i] means the tree postorder[i] has been constructed already.
     */
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode node = new TreeNode(preorder[pre++]);
        if (node.val != postorder[post]) {
            node.left = constructFromPrePost(preorder, postorder);
        }

        if (node.val != postorder[post]) {
            node.right = constructFromPrePost(preorder, postorder);
        }

        ++post;
        return node;
    }

    private String treeToString(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<String> children = new ArrayList<>();
        String left = treeToString(root.left);
        if (left != null) {
            children.add(left);
        }

        String right = treeToString(root.right);
        if (right != null) {
            children.add(right);
        }

        if (children.isEmpty()) {
            return String.format("Tree(%d)", root.val);
        }
        return String.format("Tree(%d, %s)", root.val, children);
    }
}
// @lc code=end

