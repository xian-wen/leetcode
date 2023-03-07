import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 *
 * https://leetcode.com/problems/subsets/description/
 *
 * algorithms
 * Medium (74.59%)
 * Likes:    13766
 * Dislikes: 194
 * Total Accepted:    1.4M
 * Total Submissions: 1.9M
 * Testcase Example:  '[1,2,3]'
 *
 * Given an integer array nums of unique elements, return all possible subsets
 * (the power set).
 * 
 * The solution set must not contain duplicate subsets. Return the solution in
 * any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [0]
 * Output: [[],[0]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Iteration
    //  */
    // public List<List<Integer>> subsets(int[] nums) {
    //     List<List<Integer>> res = new ArrayList<>();
    //     res.add(new ArrayList<>());
    //     for (int i = 0; i < nums.length; ++i) {
    //         List<List<Integer>> temp = new ArrayList<>();
    //         for (List<Integer> subset : res) {
    //             List<Integer> list = new ArrayList<>(subset);
    //             list.add(nums[i]);
    //             temp.add(list);
    //         }

    //         res.addAll(temp);
    //     }
    //     return res;
    // }

    // /**
    //  * Solution 2: Recursion
    //  */
    // public List<List<Integer>> subsets(int[] nums) {
    //     List<List<Integer>> res = new ArrayList<>();
    //     if (nums.length == 1) {
    //         res.add(new ArrayList<>());
    //         List<Integer> list = new ArrayList<>();
    //         list.add(nums[0]);
    //         res.add(list);
    //         return res;
    //     }

    //     int[] next = Arrays.copyOfRange(nums, 1, nums.length);
    //     List<List<Integer>> nextSubsets = subsets(next);
    //     res.addAll(nextSubsets);
    //     for (List<Integer> subset : nextSubsets) {
    //         List<Integer> list = new ArrayList<>(subset);
    //         list.add(nums[0]);
    //         res.add(list);
    //     } 
    //     return res;
    // }

    /**
     * Solution 3: Backtracking
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int index, List<Integer> temp, 
                           List<List<Integer>> res) {
        res.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; ++i) {
            temp.add(nums[i]);
            backtrack(nums, i + 1, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}
// @lc code=end

