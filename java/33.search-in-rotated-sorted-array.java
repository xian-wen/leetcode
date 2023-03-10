/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (37.25%)
 * Likes:    15416
 * Dislikes: 961
 * Total Accepted:    1.6M
 * Total Submissions: 4.1M
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * There is an integer array nums sorted in ascending order (with distinct
 * values).
 * 
 * Prior to being passed to your function, nums is possibly rotated at an
 * unknown pivot index k (1 <= k < nums.length) such that the resulting array
 * is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
 * (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3
 * and become [4,5,6,7,0,1,2].
 * 
 * Given the array nums after the possible rotation and an integer target,
 * return the index of target if it is in nums, or -1 if it is not in nums.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * 
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Example 3:
 * Input: nums = [1], target = 0
 * Output: -1
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * All values of nums are unique.
 * nums is an ascending array that is possibly rotated.
 * -10^4 <= target <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Iteration
    //  */
    // public int search(int[] nums, int target) {
    //     int l = 0, r = nums.length - 1;
    //     while (l <= r) {
    //         int mid = l + ((r - l) >> 1);
    //         if (nums[mid] == target) {
    //             return mid;
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
    //             // No idea which interval is in order.
    //             ++l;
    //         } else if (nums[mid] == nums[r]) {
    //             // No idea which interval is in order.
    //             --r;
    //         }
    //     }
    //     return -1;
    // }

    /**
     * Solution 2: Recursion
     */
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }

        int mid = lo + (hi - lo) / 2;
        if (target == nums[mid]) {
            return mid;
        }

        if (nums[lo] <= nums[mid]) {
            if (target >= nums[lo] && target < nums[mid]) {
                return binarySearch(nums, target, lo, mid - 1);
            }
            return binarySearch(nums, target, mid + 1, hi);
        }

        if (target > nums[mid] && target <= nums[hi]) {
            return binarySearch(nums, target, mid + 1, hi);
        }
        return binarySearch(nums, target, lo, mid - 1);
    }
}
// @lc code=end

