/*
 * @lc app=leetcode id=2293 lang=java
 *
 * [2293] Min Max Game
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Recursion
    //  */
    // public int minMaxGame(int[] nums) {
    //     int N = nums.length;
    //     if (N == 1) {
    //         return nums[0];
    //     }

    //     int[] newNums = new int[N / 2];
    //     for (int i = 0; i < N / 2; ++i) {
    //         if (i % 2 == 0) {
    //             newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
    //         } else {
    //             newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
    //         }
    //     }
    //     return minMaxGame(newNums);
    // }

    /**
     * Solution 2: Divide and Conquer
     */
    public int minMaxGame(int[] nums) {
        int N = nums.length;
        return minMaxGame(nums, 0, N - 1, N);
    }

    private int minMaxGame(int[] nums, int lo, int hi, int len) {
        if (lo == hi) {
            return nums[lo];
        }

        int mid = lo + (hi - lo) / 2;
        int left = minMaxGame(nums, lo, mid, len / 2);
        int right = minMaxGame(nums, mid + 1, hi, len / 2);

        if ((lo / len) % 2 == 0) {
            return Math.min(left, right);
        }
        return Math.max(left, right);
    }
}
// @lc code=end

