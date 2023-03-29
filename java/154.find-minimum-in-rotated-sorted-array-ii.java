/*
 * @lc app=leetcode id=154 lang=java
 *
 * [154] Find Minimum in Rotated Sorted Array II
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/
 *
 * algorithms
 * Hard (43.47%)
 * Likes:    3884
 * Dislikes: 416
 * Total Accepted:    379.6K
 * Total Submissions: 873K
 * Testcase Example:  '[1,3,5]'
 *
 * Suppose an array of length n sorted in ascending order is rotated between 1
 * and n times. For example, the array nums = [0,1,4,4,5,6,7] might
 * become:
 * 
 * 
 * [4,5,6,7,0,1,4] if it was rotated 4 times.
 * [0,1,4,4,5,6,7] if it was rotated 7 times.
 * 
 * 
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results
 * in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * 
 * Given the sorted rotated array nums that may contain duplicates, return the
 * minimum element of this array.
 * 
 * You must decrease the overall operation steps as much as possible.
 * 
 * 
 * Example 1:
 * Input: nums = [1,3,5]
 * Output: 1
 * Example 2:
 * Input: nums = [2,2,2,0,1]
 * Output: 0
 * 
 * 
 * Constraints:
 * 
 * 
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 * nums is sorted and rotated between 1 and n times.
 * 
 * 
 * 
 * Follow up: This problem is similar to Find Minimum in Rotated Sorted Array,
 * but nums may contain duplicates. Would this affect the runtime complexity?
 * How and why?
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return nums[lo];
        }

        int mid = lo + (hi - lo) / 2;
        if (nums[mid] == nums[hi]) {
            return binarySearch(nums, lo, --hi);
        }

        if (nums[mid] > nums[hi]) {
            return binarySearch(nums, mid + 1, hi);
        }
        return binarySearch(nums, lo, mid);
    }
}
// @lc code=end

