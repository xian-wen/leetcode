/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 *
 * https://leetcode.com/problems/next-permutation/description/
 *
 * algorithms
 * Medium (37.39%)
 * Likes:    14546
 * Dislikes: 4046
 * Total Accepted:    1M
 * Total Submissions: 2.7M
 * Testcase Example:  '[1,2,3]'
 *
 * A permutation of an array of integers is an arrangement of its members into
 * a sequence or linear order.
 * 
 * 
 * For example, for arr = [1,2,3], the following are all the permutations of
 * arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
 * 
 * 
 * The next permutation of an array of integers is the next lexicographically
 * greater permutation of its integer. More formally, if all the permutations
 * of the array are sorted in one container according to their lexicographical
 * order, then the next permutation of that array is the permutation that
 * follows it in the sorted container. If such arrangement is not possible, the
 * array must be rearranged as the lowest possible order (i.e., sorted in
 * ascending order).
 * 
 * 
 * For example, the next permutation of arr = [1,2,3] is [1,3,2].
 * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
 * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does
 * not have a lexicographical larger rearrangement.
 * 
 * 
 * Given an array of integers nums, find the next permutation of nums.
 * 
 * The replacement must be in place and use only constant extra memory.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1,1,5]
 * Output: [1,5,1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * nums: [0 1 2 5 3 3 0]
     * longest non-increasing suffix: [5 3 3 0], index is 3
     * previous of it: [2], index is 2
     * greater than previous in suffix: [3] (the rightmost), index is 5
     * nums after swap: [0 1 3 5 3 2 0]
     * nums after reverse: [0 1 3 0 2 3 5]
     */
    public void nextPermutation(int[] nums) {
        int index = indexOfLongestNonIncreasingSuffix(nums);
        int prev = index - 1;
        // prev < 0 means nums is the last permutation.
        if (prev >= 0) {
            int greater = lastIndexOfGreateThan(nums, prev);
            swap(nums, prev, greater);
        }

        reverseSuffix(nums, index);
    }

    private int indexOfLongestNonIncreasingSuffix(int[] nums) {
        int index = nums.length - 2;
        while (index >= 0 && nums[index] >= nums[index + 1]) {
            --index;
        }
        return index + 1;
    }

    private int lastIndexOfGreateThan(int[] nums, int index) {
        int start = nums.length - 1;
        while (start > index && nums[start] <= nums[index]) {
            --start;
        }
        return start;
    }

    private void reverseSuffix(int[] nums, int begin) {
        int end = nums.length - 1;
        while (begin < end) {
            swap(nums, begin++, end--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

