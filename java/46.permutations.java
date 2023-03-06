import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 *
 * https://leetcode.com/problems/permutations/description/
 *
 * algorithms
 * Medium (70.73%)
 * Likes:    11473
 * Dislikes: 204
 * Total Accepted:    1.2M
 * Total Submissions: 1.7M
 * Testcase Example:  '[1,2,3]'
 *
 * Given an array nums of distinct integers, return all the possible
 * permutations. You can return the answer in any order.
 * 
 * 
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 * Input: nums = [1]
 * Output: [[1]]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, visited, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, boolean[] visited, List<Integer> temp, 
                           List<List<Integer>> res) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = 0; i < nums.length; ++i) {
            if (!visited[i]) {  // bound function
                visited[i] = true;
                temp.add(nums[i]);
                backtrack(nums, visited, temp, res);
                visited[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}
// @lc code=end

