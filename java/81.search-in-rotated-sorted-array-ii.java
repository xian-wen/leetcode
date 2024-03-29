/*
 * @lc app=leetcode id=81 lang=java
 *
 * [81] Search in Rotated Sorted Array II
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
 *
 * algorithms
 * Medium (34.30%)
 * Likes:    4659
 * Dislikes: 741
 * Total Accepted:    438.8K
 * Total Submissions: 1.2M
 * Testcase Example:  '[2,5,6,0,0,1,2]\n0'
 *
 * There is an integer array nums sorted in non-decreasing order (not
 * necessarily with distinct values).
 * 
 * Before being passed to your function, nums is rotated at an unknown pivot
 * index k (0 <= k < nums.length) such that the resulting array is [nums[k],
 * nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and
 * become [4,5,6,6,7,0,1,2,4,4].
 * 
 * Given the array nums after the rotation and an integer target, return true
 * if target is in nums, or false if it is not in nums.
 * 
 * You must decrease the overall operation steps as much as possible.
 * 
 * 
 * Example 1:
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * Example 2:
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums is guaranteed to be rotated at some pivot.
 * -10^4 <= target <= 10^4
 * 
 * 
 * 
 * Follow up: This problem is similar to Search in Rotated Sorted Array, but
 * nums may contain duplicates. Would this affect the runtime complexity? How
 * and why?
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Iteration
    //  */
    // public boolean search(int[] nums, int target) {
    //     int l = 0, r = nums.length - 1;
    //     while (l <= r) {
    //         int mid = l + ((r - l) >> 1);
    //         if (nums[mid] == target) {
    //             return true;
    //         } else if (nums[mid] > nums[l]) {
    //             // [l, mid] is in order.
    //             if (target >= nums[l] && target < nums[mid]) {
    //                 r = mid - 1;
    //             } else {
    //                 l = mid + 1;
    //             }
    //         } else if (nums[mid] < nums[r]) {
    //             // [mid, r] is in order.
    //             if (target > nums[mid] && target <= nums[r]) {
    //                 l = mid + 1;
    //             } else {
    //                 r = mid - 1;
    //             }
    //         } else if (nums[mid] == nums[l]) {
    //             ++l;
    //         } else if (nums[mid] == nums[r]) {
    //             --r;
    //         }
    //     }
    //     return false;
    // }

    /**
     * Solution 2: Recursion
     */
    public boolean search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private boolean binarySearch(int[] nums, int lo, int hi, int target) {
        if (lo > hi) {
            return false;
        }

        int mid = lo + (hi - lo) / 2;
        if (target == nums[mid]) {
            return true;
        }

        if (nums[lo] == nums[mid] && nums[mid] == nums[hi]) {
            return binarySearch(nums, ++lo, --hi, target);
        }

        if (nums[lo] <= nums[mid]) {
            if (target >= nums[lo] && target < nums[mid]) {
                return binarySearch(nums, lo, mid - 1, target);
            }
            return binarySearch(nums, mid + 1, hi, target);
        }

        if (target > nums[mid] && target <= nums[hi]) {
            return binarySearch(nums, mid + 1, hi, target);
        }
        return binarySearch(nums, lo, mid - 1, target);
    }
}
// @lc code=end

