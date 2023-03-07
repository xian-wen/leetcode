import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 *
 * https://leetcode.com/problems/subsets-ii/description/
 *
 * algorithms
 * Medium (55.71%)
 * Likes:    7669
 * Dislikes: 218
 * Total Accepted:    671.9K
 * Total Submissions: 1.2M
 * Testcase Example:  '[1,2,2]'
 *
 * Given an integer array nums that may contain duplicates, return all possible
 * subsets (the power set).
 * 
 * The solution set must not contain duplicate subsets. Return the solution in
 * any order.
 * 
 * 
 * Example 1:
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * Example 2:
 * Input: nums = [0]
 * Output: [[],[0]]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Iteration
    //  */
    // public List<List<Integer>> subsetsWithDup(int[] nums) {
    //     Set<List<Integer>> res = new HashSet<>();
    //     res.add(new ArrayList<>());
    //     Arrays.sort(nums);
    //     for (int i = 0; i < nums.length; ++i) {
    //         List<List<Integer>> temp = new ArrayList<>();
    //         for (List<Integer> subset : res) {
    //             List<Integer> list = new ArrayList<>(subset);
    //             list.add(nums[i]);
    //             if (!res.contains(list)) {
    //                 temp.add(list);
    //             }
    //         }

    //         res.addAll(temp);
    //     }
    //     return new ArrayList<>(res);
    // }

    // /**
    //  * Solution 2: Recursion
    //  */
    // public List<List<Integer>> subsetsWithDup(int[] nums) {
    //     Arrays.sort(nums);
    //     Set<List<Integer>> res = subsetsWithDupHelper(nums);
    //     return new ArrayList<>(res);
    // }

    // private Set<List<Integer>> subsetsWithDupHelper(int[] nums) {
    //     Set<List<Integer>> res = new HashSet<>();
    //     if (nums.length == 1) {
    //         res.add(new ArrayList<>());
    //         List<Integer> list = new ArrayList<>();
    //         list.add(nums[0]);
    //         res.add(list);
    //         return res;
    //     }

    //     int[] next = Arrays.copyOfRange(nums, 1, nums.length);
    //     Set<List<Integer>> nextSubsets = subsetsWithDupHelper(next);
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
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int index, List<Integer> temp, 
                           List<List<Integer>> res) {
        res.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; ++i) {
            // Skip duplicates.
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            temp.add(nums[i]);
            backtrack(nums, i + 1, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}
// @lc code=end

