import java.util.Arrays;

/*
 * @lc app=leetcode id=41 lang=java
 *
 * [41] First Missing Positive
 *
 * https://leetcode.com/problems/first-missing-positive/description/
 *
 * algorithms
 * Hard (36.65%)
 * Likes:    13539
 * Dislikes: 1584
 * Total Accepted:    856.2K
 * Total Submissions: 2.3M
 * Testcase Example:  '[1,2,0]'
 *
 * Given an unsorted integer array nums, return the smallest missing positive
 * integer.
 * 
 * You must implement an algorithm that runs in O(n) time and uses constant
 * extra space.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,0]
 * Output: 3
 * Explanation: The numbers in the range [1,2] are all in the array.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Explanation: 1 is in the array but 2 is missing.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 * Explanation: The smallest positive integer 1 is missing.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Binary Search
    //  */
    // public int firstMissingPositive(int[] nums) {
    //     Arrays.sort(nums);
    //     int i = 1;
    //     while (Arrays.binarySearch(nums, i) >= 0) {
    //         ++i;
    //     }
    //     return i;
    // }

    /**
     * Solution 2: Index Sort
     */
    public int firstMissingPositive(int[] nums) {
        int N = nums.length;
        for (int i = 0; i < N; ++i) {
            if (nums[i] <= 0 || nums[i] > N 
                    || nums[nums[i] - 1] == nums[i]) {
                continue;
            }

            swap(nums, i, nums[i--] - 1);
        }

        int i = 0;
        while (i < N && nums[i] == i + 1) {
            ++i;
        }
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

