import java.util.Arrays;

/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 *
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 *
 * algorithms
 * Medium (51.91%)
 * Likes:    16486
 * Dislikes: 306
 * Total Accepted:    1.2M
 * Total Submissions: 2.2M
 * Testcase Example:  '[10,9,2,5,3,7,101,18]'
 *
 * Given an integer array nums, return the length of the longest strictly
 * increasing subsequence.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore
 * the length is 4.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 2500
 * -10^4 <= nums[i] <= 10^4
 * 
 * 
 * 
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time
 * complexity?
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Dynamic Programming
    //  * 
    //  * Subproblem:
    //  * len[i] = the length of LIS in nums[0..i] including nums[i].
    //  * 
    //  * Recurrence relation:
    //  * len[i] = 1 + max{len[j]} where 0 <= j < i and a_j < a_i
    //  * 
    //  * Time complexity:
    //  * O(N^2)
    //  */
    // public int lengthOfLIS(int[] nums) {
    //     int N = nums.length;
    //     int[] len = new int[N];
    //     int max = 0;
    //     for (int i = 0; i < N; ++i) {
    //         len[i] = 1;
    //         for (int j = 0; j < i; ++j) {
    //             if (nums[j] < nums[i]) {
    //                 len[i] = Math.max(len[i], 1 + len[j]);
    //             }
    //         }
    //         max = Math.max(max, len[i]);
    //     }
    //     return max;
    // }

    // /**
    //  * Solution 2: Dynamic Programming + Binary Search
    //  * 
    //  * Subproblem:
    //  * tail[i] = the smallest tail of the LIS with len = i + 1.
    //  * 
    //  * Recurrence relation:
    //  * tail[i] = tail[j] where 0 <= j <= len and tail[j-1] < tail[j] <= tail[j+1]
    //  * 
    //  * Time complexity:
    //  * O(NlogN)
    //  */
    // public int lengthOfLIS(int[] nums) {
    //     int[] tail = new int[nums.length];
    //     int len = 0;
    //     for (int num : nums) {
    //         int index = binarySearch(tail, 0, len, num);
    //         tail[index] = num;
    //         if (index == len) {
    //             ++len;
    //         }
    //     }
    //     return len;
    // }

    // /**
    //  * Binary search key in arr[start..end).
    //  */
    // private int binarySearch(int[] arr, int start, int end, int key) {
    //     if (start == end) {
    //         return start;
    //     }

    //     int mid = start + (end - start) / 2;
    //     if (key > arr[mid]) {
    //         return binarySearch(arr, mid + 1, end, key);
    //     }
    //     return binarySearch(arr, start, mid, key);
    // }

    /**
     * Solution 3: Dynamic Programming + Binary Search (built-in)
     * 
     * Subproblem:
     * tail[i] = the smallest tail of the LIS with len = i + 1.
     * 
     * Recursive relation:
     * tail[i] = tail[j] where 0 <= j <= len and tail[j-1] < tail[j] <= tail[j+1]
     * 
     * Time complexity:
     * O(NlogN)
     */
    public int lengthOfLIS(int[] nums) {
        int[] tail = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            // Binary search num in tail[0..len), return index if found and 
            // (-(insertion point) - 1) otherwise.
            // Ref: https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/util/Arrays.html#binarySearch(int[],int,int,int)
            int index = Arrays.binarySearch(tail, 0, len, num);
            if (index < 0) {
                // ~(-(insertion point) - 1) = insertion point
                index = ~index;
            }
            
            tail[index] = num;
            if (index == len) {
                ++len;
            }
        }
        return len;
    }
}
// @lc code=end

