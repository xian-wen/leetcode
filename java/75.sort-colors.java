/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 *
 * https://leetcode.com/problems/sort-colors/description/
 *
 * algorithms
 * Medium (58.10%)
 * Likes:    14188
 * Dislikes: 511
 * Total Accepted:    1.4M
 * Total Submissions: 2.3M
 * Testcase Example:  '[2,0,2,1,1,0]'
 *
 * Given an array nums with n objects colored red, white, or blue, sort them
 * in-place so that objects of the same color are adjacent, with the colors in
 * the order red, white, and blue.
 * 
 * We will use the integers 0, 1, and 2 to represent the color red, white, and
 * blue, respectively.
 * 
 * You must solve this problem without using the library's sort function.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is either 0, 1, or 2.
 * 
 * 
 * 
 * Follow up: Could you come up with a one-pass algorithm using only constant
 * extra space?
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1
    //  */
    // public void sortColors(int[] nums) {
    //     int[] count = new int[3];
    //     for (int num : nums) {
    //         ++count[num];
    //     }

    //     int k = 0;
    //     for (int i = 0; i < 3; ++i) {
    //         while (count[i] > 0) {
    //             nums[k++] = i;
    //             --count[i];
    //         }
    //     }
    // }

    /**
     * Solution 2: 3-Way Quick Sort Idea
     * 
     * nums[0..(lt-1)] < 1 = nums[lt..gt] < nums[(gt+1)..(N-1)]
     */
    public void sortColors(int[] nums) {
        int sentinel = 1;
        int lt = 0, gt = nums.length - 1, i = 0;
        while (i <= gt) {
            if (nums[i] < sentinel) {
                swap(nums, lt++, i++);
            } else if (nums[i] > sentinel) {
                swap(nums, i, gt--);
            } else {
                ++i;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

