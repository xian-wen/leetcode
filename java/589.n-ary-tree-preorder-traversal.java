import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode id=589 lang=java
 *
 * [589] N-ary Tree Preorder Traversal
 *
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/
 *
 * algorithms
 * Easy (76.03%)
 * Likes:    2845
 * Dislikes: 152
 * Total Accepted:    380.9K
 * Total Submissions: 502.1K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * Given the root of an n-ary tree, return the preorder traversal of its nodes'
 * values.
 * 
 * Nary-Tree input serialization is represented in their level order traversal.
 * Each group of children is separated by the null value (See examples)
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [1,3,5,6,2,4]
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: root =
 * [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 10^4].
 * 0 <= Node.val <= 10^4
 * The height of the n-ary tree is less than or equal to 1000.
 * 
 * 
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
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
    // public List<Integer> preorder(Node root) {
    //     List<Integer> res = new ArrayList<>();
    //     if (root == null) {
    //         return res;
    //     }
        
    //     Deque<Node> stack = new ArrayDeque<>();
    //     stack.push(root);
    //     while (!stack.isEmpty()) {
    //         Node node = stack.pop();
    //         res.add(node.val);
    //         int N = node.children.size();
    //         for (int i = N - 1; i >= 0; --i) {
    //             stack.push(node.children.get(i));
    //         }
    //     }
    //     return res;
    // }

    /**
     * Solution 2: Recursion
     */
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        preorder(root, res);
        return res;
    }

    private void preorder(Node node, List<Integer> res) {
        res.add(node.val);
        for (Node child : node.children) {
            preorder(child, res);
        }
    }
}
// @lc code=end

