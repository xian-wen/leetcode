import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=1028 lang=java
 *
 * [1028] Recover a Tree From Preorder Traversal
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
    //  * Solution 1: Regular Expression
    //  */
    // public TreeNode recoverFromPreorder(String traversal) {
    //     return recoverFromPreorder(traversal, 1);
    // }

    // /**
    //  * (?<=foo)bar: lookbehind, match bar preceded by foo.
    //  * bar(?=foo): lookahead, match bar followed by foo.
    //  * Ref: https://stackoverflow.com/questions/2973436/regex-lookahead-lookbehind-and-atomic-groups
    //  */
    // private TreeNode recoverFromPreorder(String traversal, int level) {
    //     String regex = "(?<=\\d)[-]{" + level + "}(?=\\d)";
    //     String[] strs = traversal.split(regex);

    //     TreeNode node = new TreeNode(Integer.parseInt(strs[0]));
    //     if (strs.length > 1) {
    //         node.left = recoverFromPreorder(strs[1], level + 1);
    //     }

    //     if (strs.length > 2) {
    //         node.right = recoverFromPreorder(strs[2], level + 1);
    //     }
    //     return node;
    // }

    // /**
    //  * Solution 2: Iteration
    //  */
    // public TreeNode recoverFromPreorder(String traversal) {
    //     // level -> TreeNode
    //     Map<Integer, TreeNode> map = new HashMap<>();
    //     int N = traversal.length(), index = 0;
    //     while (index < N) {
    //         int level = 0;
    //         while (index < N && traversal.charAt(index) == '-') {
    //             ++level;
    //             ++index;
    //         }

    //         int val = 0;
    //         while (index < N && traversal.charAt(index) != '-') {
    //             val = val * 10 + (traversal.charAt(index) - '0');
    //             ++index;
    //         }

    //         TreeNode node = new TreeNode(val);
    //         map.put(level, node);
    //         if (level > 0) {
    //             TreeNode parent = map.get(level - 1);
    //             if (parent.left == null) {
    //                 parent.left = node;
    //             } else {
    //                 parent.right = node;
    //             }
    //         }
    //     }
    //     // root is at level 0.
    //     return map.get(0);
    // }

    private int index;

    /**
     * Solution 3: Recursion
     */
    public TreeNode recoverFromPreorder(String traversal) {
        return recoverFromPreorder(traversal, 0);
    }

    private TreeNode recoverFromPreorder(String traversal, int level) {
        int dashs = getDashs(traversal);
        if (dashs != level) {
            index -= dashs;
            return null;
        }

        int val = getValue(traversal);
        TreeNode node = new TreeNode(val);
        node.left = recoverFromPreorder(traversal, level + 1);
        node.right = recoverFromPreorder(traversal, level + 1);
        return node;
    }

    private int getDashs(String traversal) {
        int N = traversal.length(), count = 0;
        while (index < N && traversal.charAt(index) == '-') {
            ++count;
            ++index;
        }
        return count;
    }

    private int getValue(String traversal) {
        int N = traversal.length(), num = 0;
        while (index < N && traversal.charAt(index) != '-') {
            num = num * 10 + (traversal.charAt(index) - '0');
            ++index;
        }
        return num;
    }
}
// @lc code=end

