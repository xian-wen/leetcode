import java.util.Arrays;
import java.util.Random;

/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 *
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 *
 * algorithms
 * Medium (62.16%)
 * Likes:    10662
 * Dislikes: 554
 * Total Accepted:    1.4M
 * Total Submissions: 2.2M
 * Testcase Example:  '[3,2,1,5,6,4]\n2'
 *
 * Given an integer array nums and an integer k, return the k^th largest
 * element in the array.
 * 
 * Note that it is the k^th largest element in the sorted order, not the k^th
 * distinct element.
 * 
 * 
 * Example 1:
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= k <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Sort
    //  */
    // public int findKthLargest(int[] nums, int k) {
    //     Arrays.sort(nums);
    //     return nums[nums.length - k];
    // }


    // private static final int MAX_VALUE = 10000;

    // /**
    //  * Solution 2: Count
    //  */
    // public int findKthLargest(int[] nums, int k) {
    //     int[] count = new int[MAX_VALUE * 2 + 1];
    //     for (int num : nums) {
    //         ++count[num + MAX_VALUE];
    //     }

    //     int i = count.length - 1;
    //     while (i >= 0 && k > count[i]) {
    //         k -= count[i--];
    //     }
    //     return i - MAX_VALUE;
    // }

    /**
     * Solution 3: Quick select
     */
    public int findKthLargest(int[] nums, int k) {
        // The index of the Kth largest num is N - k.
        int N = nums.length;
        return quickSelect(nums, N - k, 0, N - 1);
    }

    private int quickSelect(int[] nums, int target, int lo, int hi) {
        if (lo >= hi) {
            return nums[lo];
        }

        int pivot = partition(nums, lo, hi);
        if (target < pivot) {
            return quickSelect(nums, target, lo, pivot - 1);
        }
        
        if (target > pivot) {
            return quickSelect(nums, target, pivot + 1, hi);
        }
        return nums[pivot];
    }

    /**
     * nums[lo..(pivot-1)] <= nums[pivot] <= nums[(pivot+1), hi]
     */
    private int partition(int[] nums, int lo, int hi) {
        Random r = new Random();
        int index = r.nextInt(hi - lo + 1) + lo;
        swap(nums, lo, index);

        int sentinel = nums[hi], pivot = lo;
        for (int i = lo; i < hi; ++i) {
            if (nums[i] < sentinel) {
                swap(nums, pivot++, i);
            }
        }

        swap(nums, pivot, hi);
        return pivot;
    }

    // /**
    //  * nums[lo..(j-1)] <= nums[j] <= nums[(j+1), hi]
    //  */
    // private int partition(int[] nums, int lo, int hi) {
    //     Random r = new Random();
    //     int index = r.nextInt(hi - lo + 1) + lo;
    //     swap(nums, lo, index);

    //     int sentinel = nums[lo];
    //     int i = lo, j = hi + 1;
    //     while (true) {
    //         while (nums[++i] <= sentinel) {
    //             if (i == hi) {
    //                 break;
    //             }
    //         }
            
    //         while (nums[--j] >= sentinel) {
    //             if (j == lo) {
    //                 break;
    //             }
    //         }
            
    //         if (i >= j) {
    //             break;
    //         }
            
    //         swap(nums, i, j);
    //     }
        
    //     swap(nums, lo, j);
    //     return j;
    // }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

