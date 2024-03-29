import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 *
 * https://leetcode.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (57.16%)
 * Likes:    7185
 * Dislikes: 127
 * Total Accepted:    764.5K
 * Total Submissions: 1.3M
 * Testcase Example:  '[1,1,2]'
 *
 * Given a collection of numbers, nums, that might contain duplicates, return
 * all possible unique permutations in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 * ⁠[1,2,1],
 * ⁠[2,1,1]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Iteration
    //  */
    // public List<List<Integer>> permuteUnique(int[] nums) {
    //     List<List<Integer>> res = new ArrayList<>();
    //     res.add(new ArrayList<>());
    //     for (int i = 0; i < nums.length; ++i) {
    //         List<List<Integer>> temp = new ArrayList<>();
    //         for (List<Integer> perm : res) {
    //             for (int j = 0; j <= perm.size(); ++j) {
    //                 // Duplicates should only be put in the front.
    //                 // e.g., [1 2 1']
    //                 // [1]
    //                 // [2 1] [1 2]
    //                 // [1' 2 1] [2 1' 1] [1' 1 2]
    //                 if (j > 0 && perm.get(j - 1) == nums[i]) {
    //                     break;
    //                 }

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
    // public List<List<Integer>> permuteUnique(int[] nums) {
    //     List<List<Integer>> res = new ArrayList<>();
    //     if (nums.length == 1) {
    //         List<Integer> list = new ArrayList<>();
    //         list.add(nums[0]);
    //         res.add(list);
    //         return res;
    //     }

    //     int[] next = Arrays.copyOfRange(nums, 1, nums.length);
    //     List<List<Integer>> nextPermute = permuteUnique(next);
    //     for (List<Integer> perm : nextPermute) {
    //         for (int i = 0; i <= perm.size(); ++i) {
    //             // Duplicates should only be put in the back.
    //             // e.g., [1 2 1']
    //             // [1']
    //             // [2 1'] [1' 2]
    //             // [1 2 1'] [2 1 1'] [1 1' 2]
    //             if (i > 0 && perm.get(i - 1) == nums[0]) {
    //                 break;
    //             }

    //             List<Integer> list = new ArrayList<>(perm);
    //             list.add(i, nums[0]);
    //             res.add(list);
    //         }
    //     }
    //     return res;
    // }

    /**
     * Solution 3: Backtracking
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
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
            // Make sure duplicate is visited in behind.
            // [1 1' 2]: valid, [1' 1 2]: invalid.
            if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
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

