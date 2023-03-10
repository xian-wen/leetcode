import java.util.Arrays;

/*
 * @lc app=leetcode id=287 lang=java
 *
 * [287] Find the Duplicate Number
 *
 * https://leetcode.com/problems/find-the-duplicate-number/description/
 *
 * algorithms
 * Medium (59.09%)
 * Likes:    18430
 * Dislikes: 2664
 * Total Accepted:    1.1M
 * Total Submissions: 1.9M
 * Testcase Example:  '[1,3,4,2,2]'
 *
 * Given an array of integers nums containing n + 1 integers where each integer
 * is in the range [1, n] inclusive.
 * 
 * There is only one repeated number in nums, return this repeated number.
 * 
 * You must solve the problem without modifying the array nums and uses only
 * constant extra space.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 10^5
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * All the integers in nums appear only once except for precisely one integer
 * which appears two or more times.
 * 
 * 
 * 
 * Follow up:
 * 
 * 
 * How can we prove that at least one duplicate number must exist in nums?
 * Can you solve the problem in linear runtime complexity?
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Sort
    //  */
    // public int findDuplicate(int[] nums) {
    //     int N = nums.length;
    //     Arrays.sort(nums);
    //     for (int i = 1; i < N; ++i) {
    //         if (nums[i] == nums[i - 1]) {
    //             return nums[i];
    //         }
    //     }
    //     return -1;
    // }

    // /**
    //  * Solution 2: Count
    //  * Similarly could use HashSet to check the existence.
    //  */
    // public int findDuplicate(int[] nums) {
    //     int N = nums.length;
    //     int[] count = new int[N + 1];
    //     for (int num : nums) {
    //         ++count[num];
    //         if (count[num] > 1) {
    //             return num;
    //         }
    //     }
    //     return -1;
    // }

    // /**
    //  * Solution 3: Mark Negative
    //  */
    // public int findDuplicate(int[] nums) {
    //     for (int num : nums) {
    //         int index = Math.abs(num);
    //         if (nums[index] < 0) {
    //             return index;
    //         }
    //         nums[index] = -nums[index];
    //     }
    //     return -1;
    // }

    // /**
    //  * Solution 4: Binary Search
    //  * 
    //  * Pigeonhole Principle:
    //  * Ref: https://en.wikipedia.org/wiki/Pigeonhole_principle
    //  */
    // public int findDuplicate(int[] nums) {
    //     // nums.length = n + 1, nums are in range [1..n].
    //     // hi = num.length also passed all the test cases.
    //     int lo = 1, hi = nums.length - 1;
    //     while (lo < hi) {
    //         // # holes.
    //         int mid = lo + (hi - lo) / 2;

    //         int count = 0;
    //         for (int num : nums) {
    //             if (num <= mid) {
    //                 ++count;
    //             }
    //         }

    //         // # pigeons <= # holes, no duplicates in left.
    //         if (count <= mid) {
    //             lo = mid + 1;
    //         } else {
    //             // # pigeons > # holes, duplicates exist in left.
    //             hi = mid;
    //         }
    //     }
    //     return lo;
    // }

    // /**
    //  * Solution 5: Index Sort
    //  * 
    //  * A num at correct index: nums[i] = i + 1, i.e., 1 at 0, 2 at 1, ..., 4 at 3.
    //  * Duplicate means nums[i] = nums[nums[i] - 1].
    //  */
    // public int findDuplicate(int[] nums) {
    //     int N = nums.length, i = 0;
    //     while (i < N) {
    //         // nums[i] already at the correct index.
    //         if (nums[i] == i + 1) {
    //             ++i;
    //         } else {
    //             int num = nums[i];
    //             // There already exists a num at num-1, means duplicate.
    //             if (num == nums[num - 1]) {
    //                 return num;
    //             } else {
    //                 // Swap num at current with num at that place.
    //                 swap(nums, i, num - 1);
    //             }
    //         }
    //     }
    //     return -1;
    // }

    // private void swap(int[] nums, int i, int j) {
    //     int temp = nums[i];
    //     nums[i] = nums[j];
    //     nums[j] = temp;
    // }

    /**
     * Solution 6: Floyd's Cycle Finding (Tortoise and Hare)
     * Ref: https://www.geeksforgeeks.org/floyds-cycle-finding-algorithm/
     */
    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);

        slow = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}
// @lc code=end

