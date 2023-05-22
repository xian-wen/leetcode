/*
 * @lc app=leetcode id=2091 lang=java
 *
 * [2091] Removing Minimum and Maximum From Array
 */

// @lc code=start
class Solution {
    /**
     * Delete from left, right, or both.
     */
    public int minimumDeletions(int[] nums) {
        int N = nums.length, minIndex = 0, maxIndex = 0;
        for (int i = 0; i < N; ++i) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }

            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        int min = Math.min(minIndex, maxIndex);
        int max = Math.max(minIndex, maxIndex);
        return Math.min(min + 1 + N - max, Math.min(max + 1, N - min));
    }
}
// @lc code=end

