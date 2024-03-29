/*
 * @lc app=leetcode id=1752 lang=java
 *
 * [1752] Check if Array Is Sorted and Rotated
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1
    //  */
    // public boolean check(int[] nums) {
    //     int index = indexOfFirstDescending(nums);
    //     int N = nums.length;
    //     if (index == N) {
    //         return true;
    //     }

    //     if (!isSuffixSorted(nums, index)) {
    //         return false;
    //     }
    //     return nums[N - 1] <= nums[0]; 
    // }

    // private int indexOfFirstDescending(int[] nums) {
    //     int N = nums.length, i = 0;
    //     while (i < N - 1 && nums[i] <= nums[i + 1]) {
    //         ++i;
    //     }
    //     return i + 1;
    // }

    // private boolean isSuffixSorted(int[] nums, int start) {
    //     int N = nums.length;
    //     for (int i = start + 1; i < N; ++i) {
    //         if (nums[i - 1] > nums[i]) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    /**
     * Solution 2
     * 
     * For a valid rotated sorted array, at most one inverse is allowed.
     */
    public boolean check(int[] nums) {
        int N = nums.length, inverse = 0;
        for (int i = 0; i < N; ++i) {
            if (nums[i] > nums[(i + 1) % N]) {
                ++inverse;
            }

            if (inverse > 1) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

