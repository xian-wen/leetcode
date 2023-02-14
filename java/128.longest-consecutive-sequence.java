import java.util.HashSet;
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
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            set.add(nums[i]);
        }

        int max = 0;
        for (int num : nums) {
            set.remove(num);

            // Remove all the next consecutives.
            int next = num + 1;
            while (set.contains(next)) {
                set.remove(next);
                ++next;
            }

            // Remove all the previous consecutives.
            int prev = num - 1;
            while (set.contains(prev)) {
                set.remove(prev);
                --prev;
            }

            // curMax = (next - 1) - (prev + 1) + 1
            max = Math.max(max, next - prev - 1);
        }
        return max;
    }
}
// @lc code=end

