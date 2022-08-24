import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=437 lang=java
 *
 * [437] Path Sum III
 *
 * https://leetcode.com/problems/path-sum-iii/description/
 *
 * algorithms
 * Medium (49.86%)
 * Likes:    8305
 * Dislikes: 401
 * Total Accepted:    397.2K
 * Total Submissions: 805.2K
 * Testcase Example:  '[10,5,-3,3,2,null,11,3,-2,null,1]\n8'
 *
 * Given the root of a binary tree and an integer targetSum, return the number
 * of paths where the sum of the values along the path equals targetSum.
 * 
 * The path does not need to start or end at the root or a leaf, but it must go
 * downwards (i.e., traveling only from parent nodes to child nodes).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * Output: 3
 * Explanation: The paths that sum to 8 are shown.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: 3
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 1000].
 * -10^9 <= Node.val <= 10^9
 * -1000 <= targetSum <= 1000
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
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int pathIncludeRoot = pathSumIncludeRoot(root, targetSum);
        int leftPathExcludeRoot = pathSum(root.left, targetSum);
        int rightPathExcludeRoot = pathSum(root.right, targetSum);
        return pathIncludeRoot + leftPathExcludeRoot + rightPathExcludeRoot;
    }

    // Path including root must be continuous.
    private int pathSumIncludeRoot(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }

        // Once not equal, invalid.
        int count = root.val == targetSum ? 1 : 0;
        count += pathSumIncludeRoot(root.left, targetSum - root.val);
        count += pathSumIncludeRoot(root.right, targetSum - root.val);
        return count;
    }
}
// @lc code=end

