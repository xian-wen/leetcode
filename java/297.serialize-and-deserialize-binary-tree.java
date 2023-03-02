import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
 *
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 *
 * algorithms
 * Hard (55.27%)
 * Likes:    8511
 * Dislikes: 310
 * Total Accepted:    724.8K
 * Total Submissions: 1.3M
 * Testcase Example:  '[1,2,3,null,null,4,5]'
 *
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in
 * the same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and
 * this string can be deserialized to the original tree structure.
 * 
 * Clarification: The input/output format is the same as how LeetCode
 * serializes a binary tree. You do not necessarily need to follow this format,
 * so please be creative and come up with different approaches yourself.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3,null,null,4,5]
 * Output: [1,2,3,null,null,4,5]
 * 
 * 
 * Example 2:
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
 * The number of nodes in the tree is in the range [0, 10^4].
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
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // // Solution 1: Iteration
    // // Encodes a tree to a single string.
    // public String serialize(TreeNode root) {
    //     if (root == null) {
    //         return null;
    //     }

    //     // Using List<String> will be extremely slow.
    //     StringBuilder sb = new StringBuilder();
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.offer(root);
    //     while (!queue.isEmpty()) {
    //         TreeNode node = queue.poll();
    //         if (node == null) {
    //             sb.append("null ");
    //             continue;
    //         }
            
    //         sb.append(node.val).append(" ");
    //         queue.add(node.left);
    //         queue.add(node.right);
    //     }
    //     return sb.toString();
    // }

    // // Decodes your encoded data to tree.
    // public TreeNode deserialize(String data) {
    //     if (data == null) {
    //         return null;
    //     }

    //     String[] values = data.split(" ");
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     TreeNode root = new TreeNode(Integer.parseInt(values[0]));
    //     queue.offer(root);
    //     for (int i = 1; i < values.length; ++i) {
    //         TreeNode node = queue.poll();
    //         if (!"null".equals(values[i])) {
    //             node.left = new TreeNode(Integer.parseInt(values[i]));
    //             queue.add(node.left);
    //         }

    //         if (!"null".equals(values[++i])) {
    //             node.right = new TreeNode(Integer.parseInt(values[i]));
    //             queue.add(node.right);
    //         }
    //     }
    //     return root;
    // }

    private int index;

    // Solution 2: Recursion
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null ");
            return;
        }

        // Avoid sb.append(root.val + " ") since it makes the solution slow.
        sb.append(root.val).append(" ");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(" ");
        index = 0;
        return deserialize(values);
    }

    private TreeNode deserialize(String[] data) {
        if ("null".equals(data[index])) {
            ++index;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(data[index++]));
        node.left = deserialize(data);
        node.right = deserialize(data);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end

