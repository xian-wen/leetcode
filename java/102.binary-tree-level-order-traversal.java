import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (63.97%)
 * Likes:    12471
 * Dislikes: 246
 * Total Accepted:    1.7M
 * Total Submissions: 2.7M
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given the root of a binary tree, return the level order traversal of its
 * nodes' values. (i.e., from left to right, level by level).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1]
 * Output: [[1]]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = []
 * Output: []
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 2000].
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
    // /**
    //  * Solution 1: Iteration
    //  */
    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     List<List<Integer>> res = new ArrayList<>();
    //     if (root == null) {
    //         return res;
    //     }

    //     Queue<TreeNode> queue = new ArrayDeque<>();
    //     queue.offer(root);
    //     while (!queue.isEmpty()) {
    //         int size = queue.size();
    //         List<Integer> temp = new ArrayList<>();
    //         for (int i = 0; i < size; ++i) {
    //             TreeNode node = queue.poll();
    //             temp.add(node.val);
    //             if (node.left != null) {
    //                 queue.offer(node.left);
    //             }

    //             if (node.right != null) {
    //                 queue.offer(node.right);
    //             }
    //         }

    //         res.add(temp);
    //     }
    //     return res;
    // }

    /**
     * Solution 2: Recursion
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrder(root, 0, res);
        return res;
    }

    private void levelOrder(TreeNode node, int level, List<List<Integer>> res) {
        if (node == null) {
            return;
        }

        if (level >= res.size()) {
            res.add(new ArrayList<>());
        }

        res.get(level).add(node.val);
        levelOrder(node.left, level + 1, res);
        levelOrder(node.right, level + 1, res);
    }
}
// @lc code=end

