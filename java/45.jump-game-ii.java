/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int N = nums.length, reachable = 0, prev = 0, jumps = 0;
        for (int i = 0; i < N - 1; ++i) {
            reachable = Math.max(reachable, i + nums[i]);
            if (i == prev) {
                ++jumps;
                prev = reachable;
            }
        }
        return jumps;
    }
}
// @lc code=end

