/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (39.32%)
 * Likes:    11397
 * Dislikes: 306
 * Total Accepted:    1.2M
 * Total Submissions: 2.9M
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * Given an array of integers nums sorted in non-decreasing order, find the
 * starting and ending position of a given target value.
 * 
 * If target is not found in the array, return [-1, -1].
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * 
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * nums is a non-decreasing array.
 * -10^9 <= target <= 10^9
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Double pointer
    //  */
    // public int[] searchRange(int[] nums, int target) {
    //     int left = 0, right = nums.length - 1;
    //     while (left <= right) {
    //         if (nums[left] == target && nums[right] == target) {
    //             break;
    //         }

    //         while (left <= right && nums[left] != target) {
    //             ++left;
    //         }

    //         while (left <= right && nums[right] != target) {
    //             --right;
    //         }
    //     }
    //     return left > right ? new int[] {-1, -1} : new int[] {left, right}; 
    // }

    // /**
    //  * Solution 2: Binary Search Iteration
    //  */
    // public int[] searchRange(int[] nums, int target) {
    //     return new int[] {
    //         findFirstEqual(nums, target),
    //         findLastEqual(nums, target)
    //     };
    // }

    // private int findFirstEqual(int[] nums, int target) {
    //     int l = 0, r = nums.length - 1;
    //     while (l <= r) {
    //         int mid = l + ((r - l) >> 1);
    //         if (nums[mid] > target) {
    //             r = mid - 1;
    //         } else if (nums[mid] < target) {
    //             l = mid + 1;
    //         } else {
    //             if (mid == 0 || nums[mid - 1] != target) {
    //                 return mid;
    //             }
    //             r = mid - 1;
    //         }
    //     }
    //     return -1;
    // }

    // private int findLastEqual(int[] nums, int target) {
    //     int l = 0, r = nums.length - 1;
    //     while (l <= r) {
    //         int mid = l + ((r - l) >> 1);
    //         if (nums[mid] > target) {
    //             r = mid - 1;
    //         } else if (nums[mid] < target) {
    //             l = mid + 1;
    //         } else {
    //             if (mid == nums.length - 1 || nums[mid + 1] != target) {
    //                 return mid;
    //             }
    //             l = mid + 1;
    //         }
    //     }
    //     return -1;
    // }

    /**
     * Solution 3: Binary Search Recursion
     */
    public int[] searchRange(int[] nums, int target) {
        int N = nums.length;
        // Init for min and max.
        int[] res = new int[] {N, -1};
        return binarySearch(nums, target, 0, N - 1, res);
    }

    private int[] binarySearch(int[] nums, int target, int low, int high, int[] res) {
        if (low > high) {
            return new int[] {-1, -1};
        }

        int mid = low + (high - low) / 2;
        if (target > nums[mid]) {
            return binarySearch(nums, target, mid + 1, high, res);
        }

        if (target < nums[mid]) {
            return binarySearch(nums, target, low, mid - 1, res);
        }

        res[0] = Math.min(res[0], mid);
        res[1] = Math.max(res[1], mid);
        // No idea move to left or right, so both.
        binarySearch(nums, target, low, mid - 1, res);
        binarySearch(nums, target, mid + 1, high, res);
        return res;
    }
}
// @lc code=end

