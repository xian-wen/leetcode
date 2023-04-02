import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (55.61%)
 * Likes:    8948
 * Dislikes: 238
 * Total Accepted:    935.5K
 * Total Submissions: 1.6M
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given the root of a binary tree, return the zigzag level order traversal of
 * its nodes' values. (i.e., from left to right, then right to left for the
 * next level and alternate between).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
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
 * -100 <= Node.val <= 100
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
    // public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    //     List<List<Integer>> res = new ArrayList<>();
    //     if (root == null) {
    //         return res;
    //     }

    //     Queue<TreeNode> queue = new ArrayDeque<>();
    //     queue.offer(root);
    //     int level = 0;
    //     while (!queue.isEmpty()) {
    //         int size = queue.size();
    //         List<Integer> temp = new LinkedList<>();
    //         for (int i = 0; i < size; ++i) {
    //             TreeNode node = queue.poll();
    //             if (level % 2 == 0) {
    //                 temp.add(node.val);
    //             } else {
    //                 temp.add(0, node.val);
    //             }

    //             if (node.left != null) {
    //                 queue.offer(node.left);
    //             }

    //             if (node.right != null) {
    //                 queue.offer(node.right);
    //             }
    //         }

    //         ++level;
    //         res.add(temp);
    //     }
    //     return res;
    // }

    /**
     * Solution 2: Recursion
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        zigzagLevelOrder(root, 0, res);
        return res;
    }

    private void zigzagLevelOrder(TreeNode node, int level, 
                                  List<List<Integer>> res) {
        if (node == null) {
            return;
        }

        if (level >= res.size()) {
            res.add(new LinkedList<>());
        }

        if (level % 2 == 0) {
            res.get(level).add(node.val);
        } else {
            res.get(level).add(0, node.val);
        }

        zigzagLevelOrder(node.left, level + 1, res);
        zigzagLevelOrder(node.right, level + 1, res);
    }
}
// @lc code=end

