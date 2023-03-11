import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 *
 * https://leetcode.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (63.94%)
 * Likes:    13935
 * Dislikes: 432
 * Total Accepted:    1.6M
 * Total Submissions: 2.6M
 * Testcase Example:  '[3,2,3]'
 *
 * Given an array nums of size n, return the majority element.
 * 
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 * 
 * 
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 * 
 * 
 * Constraints:
 * 
 * 
 * n == nums.length
 * 1 <= n <= 5 * 10^4
 * -10^9 <= nums[i] <= 10^9
 * 
 * 
 * 
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Sort
    //  */
    // public int majorityElement(int[] nums) {
    //     Arrays.sort(nums);
    //     return nums[nums.length / 2];
    // }

    // /**
    //  * Solution 2: HashMap
    //  */
    // public int majorityElement(int[] nums) {
    //     Map<Integer, Integer> map = new HashMap<>();
    //     int N = nums.length;
    //     for (int num : nums) {
    //         map.put(num, map.getOrDefault(num, 0) + 1);
    //         if (map.get(num) > N / 2) {
    //             return num;
    //         }
    //     }
    //     return -1;
    // }

    // /**
    //  * Solution 3: Quick Select
    //  */
    // public int majorityElement(int[] nums) {
    //     int N = nums.length;
    //     return quickSelect(nums, N / 2, 0, N - 1);
    // }

    // private int quickSelect(int[] nums, int target, int lo, int hi) {
    //     if (lo >= hi) {
    //         return nums[lo];
    //     }

    //     int pivot = partition(nums, lo, hi);
    //     if (target == pivot) {
    //         return nums[pivot];
    //     } 
        
    //     if (target < pivot) {
    //         return quickSelect(nums, target, lo, pivot - 1);
    //     }
    //     return quickSelect(nums, target, pivot + 1, hi);
    // }

    // private int partition(int[] nums, int lo, int hi) {
    //     int sentinel = nums[hi], pivot = lo;
    //     for (int i = lo; i < hi; ++i) {
    //         if (nums[i] < sentinel) {
    //             swap(nums, pivot++, i);
    //         }
    //     }

    //     swap(nums, pivot, hi);
    //     return pivot;
    // }

    // /**
    //  * Solution 4: 3-Way Quick Select
    //  */
    // public int majorityElement(int[] nums) {
    //     int N = nums.length;
    //     return quickSelect3Way(nums, N / 2, 0, N - 1);
    // }

    // /**
    //  * nums[lo..(lt-1)] < v = nums[lt..gt] < nums[(gt+1)..hi];
    //  */
    // private int quickSelect3Way(int[] nums, int target, int lo, int hi) {
    //     if (lo >= hi) {
    //         return nums[lo];
    //     }

    //     int sentinel = nums[lo];
    //     int lt = lo, gt = hi, i = lt + 1;
    //     while (i <= gt) {
    //         if (nums[i] < sentinel) {
    //             swap(nums, lt++, i++);
    //         } else if (nums[i] > sentinel) {
    //             swap(nums, i, gt--);
    //         } else {
    //             ++i;
    //         }
    //     }

    //     if (target >= lt && target <= gt) {
    //         return nums[target];
    //     }

    //     if (target < lt) {
    //         return quickSelect3Way(nums, target, lo, lt - 1);
    //     }
    //     return quickSelect3Way(nums, target, gt + 1, hi);
    // }

    // private void swap(int[] nums, int i, int j) {
    //     int temp = nums[i];
    //     nums[i] = nums[j];
    //     nums[j] = temp;
    // }

    // /**
    //  * Solution 5: Bits Manipulation
    //  */
    // public int majorityElement(int[] nums) {
    //     int[] bits = new int[32];
    //     int N = nums.length;
    //     for (int num : nums) {
    //         for (int i = 31; i >= 0; --i) {
    //             bits[i] += (num >> i) & 1;
    //         }
    //     }

    //     int target = N / 2, res = 0;
    //     for (int i = 31; i >= 0; --i) {
    //         bits[i] = bits[i] > target ? 1 : 0;
    //         res |= bits[i] << i;
    //     }
    //     return res;
    // }

    /**
     * Solution 6: Boyer–Moore Majority Vote
     */
    public int majorityElement(int[] nums) {
        int res = 0, count = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
            }

            if (num == res) {
                ++count;
            } else {
                --count;
            }
        }
        return res;
    }
}
// @lc code=end

