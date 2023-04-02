import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=429 lang=java
 *
 * [429] N-ary Tree Level Order Traversal
 *
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (70.65%)
 * Likes:    3335
 * Dislikes: 126
 * Total Accepted:    275.4K
 * Total Submissions: 389.8K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * Given an n-ary tree, return the level order traversal of its nodes' values.
 * 
 * Nary-Tree input serialization is represented in their level order traversal,
 * each group of children is separated by the null value (See examples).
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [[1],[3,2,4],[5,6]]
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: root =
 * [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The height of the n-ary tree is less than or equal to 1000
 * The total number of nodes is between [0, 10^4]
 * 
 * 
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    // /**
    //  * Solution 1: Iteration
    //  */
    // public List<List<Integer>> levelOrder(Node root) {
    //     List<List<Integer>> res = new ArrayList<>();
    //     if (root == null) {
    //         return res;
    //     }

    //     Queue<Node> queue = new ArrayDeque<>();
    //     queue.offer(root);
    //     while (!queue.isEmpty()) {
    //         int size = queue.size();
    //         List<Integer> temp = new ArrayList<>();
    //         for (int i = 0; i < size; ++i) {
    //             Node node = queue.poll();
    //             temp.add(node.val);
    //             for (Node child : node.children) {
    //                 queue.offer(child);
    //             }
    //         }

    //         res.add(temp);
    //     }
    //     return res;
    // }

    /**
     * Solution 2: Recursion
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        levelOrder(root, 0, res);
        return res;
    }

    private void levelOrder(Node node, int level, List<List<Integer>> res) {
        if (level >= res.size()) {
            res.add(new ArrayList<>());
        }

        res.get(level).add(node.val);
        for (Node child : node.children) {
            levelOrder(child, level + 1, res);
        }
    }
}
// @lc code=end

