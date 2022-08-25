/*
 * @lc app=leetcode id=1110 lang=java
 *
 * [1110] Delete Nodes And Return Forest
 *
 * https://leetcode.com/problems/delete-nodes-and-return-forest/description/
 *
 * algorithms
 * Medium (69.04%)
 * Likes:    3058
 * Dislikes: 92
 * Total Accepted:    168.2K
 * Total Submissions: 242.6K
 * Testcase Example:  '[1,2,3,4,5,6,7]\n[3,5]'
 *
 * Given the root of a binary tree, each node in the tree has a distinct
 * value.
 * 
 * After deleting all nodes with a value in to_delete, we are left with a
 * forest (a disjoint union of trees).
 * 
 * Return the roots of the trees in the remaining forest. You may return the
 * result in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * Output: [[1,2,null,4],[6],[7]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1,2,4,null,3], to_delete = [3]
 * Output: [[1,2,4]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the given tree is at most 1000.
 * Each node has a distinct value between 1 and 1000.
 * to_delete.length <= 1000
 * to_delete contains distinct values between 1 and 1000.
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> deleted = new LinkedList<>();
        if (root == null) {
            return deleted;
        }
        
        Set<Integer> toDeleteSet = new HashSet<>();
        for (int d : to_delete) {
            toDeleteSet.add(d);
        }
        
        root = delNodes(root, toDeleteSet, deleted);
        if (root != null) {
            deleted.add(root);
        }
        return deleted;
    }

    private TreeNode delNodes(TreeNode root, Set<Integer> toDeleteSet, 
            List<TreeNode> deleted) {
        if (root == null) {
            return null;
        }

        root.left = delNodes(root.left, toDeleteSet, deleted);
        root.right = delNodes(root.right, toDeleteSet, deleted);
        
        if (toDeleteSet.contains(root.val)) {
            if (root.left != null) {
                deleted.add(root.left);
            }

            if (root.right != null) {
                deleted.add(root.right);
            }
            root = null;
        }
        return root;
    }
}
// @lc code=end

