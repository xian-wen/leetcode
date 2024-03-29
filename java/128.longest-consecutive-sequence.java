import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 *
 * https://leetcode.com/problems/longest-consecutive-sequence/description/
 *
 * algorithms
 * Medium (48.67%)
 * Likes:    14917
 * Dislikes: 619
 * Total Accepted:    1M
 * Total Submissions: 2.1M
 * Testcase Example:  '[100,4,200,1,3,2]'
 *
 * Given an unsorted array of integers nums, return the length of the longest
 * consecutive elements sequence.
 * 
 * You must write an algorithm that runs in O(n) time.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
 * Therefore its length is 4.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Recursion
    //  */
    // public int longestConsecutive(int[] nums) {
    //     Map<Integer, Boolean> visited = new HashMap<>();
    //     for (int num : nums) {
    //         visited.put(num, false);
    //     }

    //     int N = nums.length, maxLen = 0;
    //     for (int num : nums) {
    //         if (!visited.get(num)) {
    //             int[] pair = new int[] {num, num};
    //             dfs(visited, num, pair);
    //             maxLen = Math.max(maxLen, pair[1] - pair[0] - 1);
    //         }
    //     }
    //     return maxLen;
    // }

    // private void dfs(Map<Integer, Boolean> visited, int num, int[] pair) {
    //     if (!visited.containsKey(num) || visited.get(num)) {
    //         return;
    //     }

    //     visited.put(num, true);
    //     pair[0] = Math.min(pair[0], num - 1);
    //     dfs(visited, num - 1, pair);
    //     pair[1] = Math.max(pair[1], num + 1);
    //     dfs(visited, num + 1, pair);
    // }

    // /**
    //  * Solution 2: Iteration 1
    //  */
    // public int longestConsecutive(int[] nums) {
    //     Map<Integer, Boolean> visited = new HashMap<>();
    //     for (int num : nums) {
    //         visited.put(num, false);
    //     }

    //     int N = nums.length, maxLen = 0;
    //     for (int i = 0; i < N; ++i) {
    //         if (!visited.get(nums[i])) {
    //             int len = extend(visited, nums[i]);
    //             maxLen = Math.max(maxLen, len);
    //         }
    //     }
    //     return maxLen;
    // }

    // private int extend(Map<Integer, Boolean> visited, int num) {
    //     visited.put(num, true);
    //     int left = num - 1;
    //     while (visited.containsKey(left) && !visited.get(left)) {
    //         visited.put(left, true);
    //         --left;
    //     }

    //     int right = num + 1;
    //     while (visited.containsKey(right) && !visited.get(right)) {
    //         visited.put(right, true);
    //         ++right;
    //     }
    //     return right - left - 1;
    // }

    // /**
    //  * Solution 3: Iteration 2
    //  */
    // public int longestConsecutive(int[] nums) {
    //     Set<Integer> set = new HashSet<>();
    //     for (int i = 0; i < nums.length; ++i) {
    //         set.add(nums[i]);
    //     }

    //     int max = 0;
    //     for (int num : nums) {
    //         set.remove(num);

    //         // Remove all the next consecutives.
    //         int next = num + 1;
    //         while (set.contains(next)) {
    //             set.remove(next);
    //             ++next;
    //         }

    //         // Remove all the previous consecutives.
    //         int prev = num - 1;
    //         while (set.contains(prev)) {
    //             set.remove(prev);
    //             --prev;
    //         }

    //         // curMax = (next - 1) - (prev + 1) + 1
    //         max = Math.max(max, next - prev - 1);
    //     }
    //     return max;
    // }

    /**
     * Solution 4: Iteration 3
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLen = 0;
        // Must use set here, otherwise the time would be extremely high. 
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int next = num + 1;
                while (set.contains(next)) {
                    ++next;
                }

                maxLen = Math.max(maxLen, next - num);
            }

        }
        return maxLen;
    }
}
// @lc code=end

