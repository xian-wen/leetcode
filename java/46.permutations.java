import java.util.ArrayList;
import java.util.Arrays;
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
    // /**
    //  * Solution 1: Iteration
    //  */
    // public List<List<Integer>> permute(int[] nums) {
    //     List<List<Integer>> res = new ArrayList<>();
    //     res.add(new ArrayList<>());
    //     for (int i = 0; i < nums.length; ++i) {
    //         // To avoid ConcurrentModificationException.
    //         List<List<Integer>> temp = new ArrayList<>();
    //         for (List<Integer> perm : res) {
    //             for (int j = 0; j <= perm.size(); ++j) {
    //                 List<Integer> list = new ArrayList<>(perm);
    //                 list.add(j, nums[i]);
    //                 temp.add(list);
    //             }
    //         }

    //         res = temp;
    //     }
    //     return res;
    // }

    // /**
    //  * Solution 2: Recursion
    //  */
    // public List<List<Integer>> permute(int[] nums) {
    //     List<List<Integer>> res = new ArrayList<>();
    //     if (nums.length == 1) {
    //         List<Integer> list = new ArrayList<>();
    //         list.add(nums[0]);
    //         res.add(list);
    //         return res;
    //     }

    //     int[] next = Arrays.copyOfRange(nums, 1, nums.length);
    //     List<List<Integer>> nextPermute = permute(next);
    //     for (List<Integer> perm : nextPermute) {
    //         for (int i = 0; i <= perm.size(); ++i) {
    //             List<Integer> list = new ArrayList<>(perm);
    //             list.add(i, nums[0]);
    //             res.add(list);
    //         }
    //     }
    //     return res;
    // }

    // /**
    //  * Solution 3: Backtracking + swap
    //  */
    // public List<List<Integer>> permute(int[] nums) {
    //     List<List<Integer>> res = new ArrayList<>();
    //     backtrack(nums, 0, res);
    //     return res;
    // }

    // private void backtrack(int[] nums, int index, List<List<Integer>> res) {
    //     if (index == nums.length) {
    //         List<Integer> list = new ArrayList<>();
    //         for (int num : nums) {
    //             list.add(num);
    //         }

    //         res.add(list);
    //         return;
    //     }
        
    //     for (int i = index; i < nums.length; ++i) {
    //         swap(nums, index, i);
    //         backtrack(nums, index + 1, res);
    //         swap(nums, index, i);
    //     }
    // }

    // private void swap(int[] nums, int i, int j) {
    //     int temp = nums[i];
    //     nums[i] = nums[j];
    //     nums[j] = temp;
    // }

    /**
     * Solution 4: Backtracking + visited
     */
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
            if (visited[i]) {  // Bounding function.
                continue;
            }

            visited[i] = true;
            temp.add(nums[i]);
            backtrack(nums, visited, temp, res);
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}
// @lc code=end

