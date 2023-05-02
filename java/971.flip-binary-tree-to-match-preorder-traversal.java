import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode id=971 lang=java
 *
 * [971] Flip Binary Tree To Match Preorder Traversal
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
    // public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
    //     List<Integer> res = new ArrayList<>();
    //     if (root == null) {
    //         return res;
    //     }

    //     // `null` is not allowed!!!
    //     // Ref: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Deque.html#push(E)
    //     Deque<TreeNode> stack = new ArrayDeque<>();
    //     stack.push(root);
    //     int index = 0;
    //     while (!stack.isEmpty()) {
    //         TreeNode node = stack.pop();
    //         if (node.val != voyage[index++]) {
    //             return List.of(-1);
    //         }

    //         if (node.left != null && node.left.val != voyage[index]) {
    //             res.add(node.val);
    //             TreeNode temp = node.left;
    //             node.left = node.right;
    //             node.right = temp;
    //         }

    //         if (node.right != null) {
    //             stack.push(node.right);
    //         }

    //         if (node.left != null) {
    //             stack.push(node.left);
    //         }
    //     }
    //     return res;
    // }

    private int index;

    /**
     * Solution 2: Recursion
     */
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> res = new ArrayList<>();
        return flipMatchVoyage(root, voyage, res) ? res : List.of(-1);
    }

    private boolean flipMatchVoyage(TreeNode root, int[] voyage, 
                                    List<Integer> res) {
        if (root == null) {
            return true;
        }

        if (root.val != voyage[index++]) {
            return false;
        }

        if (root.left != null && root.left.val != voyage[index]) {
            res.add(root.val);
            return flipMatchVoyage(root.right, voyage, res) 
                    && flipMatchVoyage(root.left, voyage, res);
        }
        return flipMatchVoyage(root.left, voyage, res) 
                && flipMatchVoyage(root.right, voyage, res);
    }
}
// @lc code=end

