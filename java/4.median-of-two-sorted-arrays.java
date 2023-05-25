/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (35.87%)
 * Likes:    22413
 * Dislikes: 2519
 * Total Accepted:    1.8M
 * Total Submissions: 5M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return
 * the median of the two sorted arrays.
 * 
 * The overall run time complexity should be O(log (m+n)).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10^6 <= nums1[i], nums2[i] <= 10^6
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Merge
    //  */
    // public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //     int M = nums1.length, N = nums2.length;
    //     if (M == 0) {
    //         return median(nums2);
    //     }

    //     if (N == 0) {
    //         return median(nums1);
    //     }

    //     int[] merged = merge(nums1, nums2);
    //     return median(merged);
    // }

    // private int[] merge(int[] nums1, int[] nums2) {
    //     int M = nums1.length, N = nums2.length;
    //     int[] res = new int[M + N];
    //     int i1 = 0, i2 = 0;
    //     for (int k = 0; k < res.length; ++k) {
    //         if (i1 == M) {
    //             res[k] = nums2[i2++];
    //         } else if (i2 == N) {
    //             res[k] = nums1[i1++];
    //         } else if (nums1[i1] < nums2[i2]) {
    //             res[k] = nums1[i1++];
    //         } else {
    //             res[k] = nums2[i2++];
    //         }
    //     }
    //     return res;
    // }

    // /**
    //  * Solution 2: Merge Optimization
    //  */
    // public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //     int M = nums1.length, N = nums2.length;
    //     if (M == 0) {
    //         return median(nums2);
    //     }

    //     if (N == 0) {
    //         return median(nums1);
    //     }

    //     int i1 = 0, i2 = 0, medi = (M + N) / 2;
    //     double med = 0.0, pre = 0.0;
    //     for (int k = 0; k <= medi; ++k) {
    //         pre = med;
    //         if (i1 == M) {
    //             med = nums2[i2++];
    //         } else if (i2 == N) {
    //             med = nums1[i1++];
    //         } else if (nums1[i1] < nums2[i2]) {
    //             med = nums1[i1++];
    //         } else {
    //             med = nums2[i2++];
    //         }
    //     }

    //     if ((M + N) % 2 == 1) {
    //         return med;
    //     }
    //     return (pre + med) / 2.0;
    // }

    // /**
    //  * Solution 3: Binary Search Iteration
    //  */
    // public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //     int M = nums1.length, N = nums2.length;
    //     if (M == 0) {
    //         return median(nums2);
    //     }

    //     if (N == 0) {
    //         return median(nums1);
    //     }

    //     // Make nums1 always the shorter one.
    //     if (M > N) {
    //         return findMedianSortedArrays(nums2, nums1);
    //     }

    //     int lo = 0, hi = M, half = (M + N) / 2;
    //     while (lo <= hi) {
    //         int mid1 = lo + (hi - lo) / 2;
    //         int mid2 = half - mid1;

    //         int left1 = mid1 > 0 ? nums1[mid1 - 1] : Integer.MIN_VALUE;
    //         int left2 = mid2 > 0 ? nums2[mid2 - 1] : Integer.MIN_VALUE;
    //         int right1 = mid1 < M ? nums1[mid1] : Integer.MAX_VALUE;
    //         int right2 = mid2 < N ? nums2[mid2] : Integer.MAX_VALUE;

    //         if (left1 > right2) {
    //             hi = mid1 - 1;
    //         } else if (left2 > right1) {
    //             lo = mid1 + 1;
    //         } else {
    //             if ((M + N) % 2 == 1) {
    //                 return Math.min(right1, right2);
    //             }
    //             return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0; 
    //         }
    //     }
    //     return -1.0;
    // }

    // private double median(int[] nums) {
    //     int N = nums.length;
    //     if (N == 0) {
    //         return 0.0;
    //     }
        
    //     if (N % 2 == 1) {
    //         return nums[N / 2];
    //     }
    //     return (nums[N / 2 - 1] + nums[N / 2]) / 2.0;
    // }

    /**
     * Solution 4: Binary Search Recursion
     * 
     * Partition Rule:
     * 1. # nums in left part = # nums in right part (diff in 1 for odd total len)
     * 2. All nums in left <= all nums in right, i.e., max(left) <= min(right)
     * 
     * Search Rule:
     * 1. Only binary search the shorter len arr, say nums1, set lo = 0, hi = len(nums1)
     * 2. If left1 > right2, move to left, to make left1 smaller
     * 3. If left2 > right1, move to right, to make left2 smaller, also left1 bigger
     * 4. If paritition becomes empty, set -Infinity at 0 and Infinity at len(nums1)
     * 
     * Case 1: Even total length
     * nums1: [1 3 | 5 7 9], mid1 = (0+5)/2 = 2
     * nums2: [0 2 4 | 6 8], mid2 = half - mid1 = (5+5)/2-2 = 3
     * left: [1 3 0 2 4], left1 = 3, left2 = 4
     * right: [5 7 9 6 8], right1 = 5, right2 = 6
     * Check:
     * Partition Rule 1: ✅
     * Partition Rule 2: ✅
     * 
     * Median: (max{3, 4} + min{5, 6}) / 2.0 = 4.5
     * 
     * Case 2: Odd total length
     * nums1: [3 5 | 7 9], mid1 = (0+4)/2 = 2
     * nums2: [0 2 | 4 6 8], mid2 = half - mid1 = (4+5)/2-2 = 2
     * left: [3 5 0 2], left1 = 5, left2 = 2
     * right: [7 9 4 6 8], right1 = 7, right2 = 4
     * Check:
     * Partition Rule 1: ✅
     * Partition Rule 2: ❎, since 5 > 4, i.e. left1 > right2, move to left
     * 
     * nums1: [| 3 5 7 9], mid1 = (0+1)/2 = 0
     * nums2: [0 2 4 6 | 8], mid2 = half - mid1 = (4+5)/2-0 = 4
     * left: [-∞ 0 2 4 6], left1 = -∞, left2 = 6
     * right: [3 5 7 9 8], right1 = 3, right2 = 8
     * Check:
     * Partition Rule 1: ✅
     * Partition Rule 2: ❎, since 6 > 3, i.e. left2 > right1, move to right
     * 
     * nums1: [3 | 5 7 9], mid1 = (1+1)/2 = 1
     * nums2: [0 2 4 | 6 8], mid2 = half - mid1 = (4+5)/2-1 = 3
     * left: [3 0 2 4], left1 = 3, left2 = 4
     * right: [5 7 9 6 8], right1 = 5, right2 = 6
     * Check:
     * Partition Rule 1: ✅
     * Partition Rule 2: ✅
     * 
     * Median: min{5, 6} = 5
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int M = nums1.length, N = nums2.length;
        // Make nums1 always be the shorter one.
        if (M > N) {
            return findMedianSortedArrays(nums2, nums1);
        }
        return binarySearch(nums1, nums2, 0, M);
    }

    private double binarySearch(int[] nums1, int[] nums2, int lo, int hi) {
        if (lo > hi) {
            return -1.0;
        }

        int M = nums1.length, N = nums2.length, half = (M + N) / 2;
        int mid1 = lo + (hi - lo) / 2;
        int mid2 = half - mid1;

        int left1 = mid1 > 0 ? nums1[mid1 - 1] : Integer.MIN_VALUE;
        int left2 = mid2 > 0 ? nums2[mid2 - 1] : Integer.MIN_VALUE;
        int right1 = mid1 < M ? nums1[mid1] : Integer.MAX_VALUE;
        int right2 = mid2 < N ? nums2[mid2] : Integer.MAX_VALUE;

        if (left1 > right2) {
            return binarySearch(nums1, nums2, lo, mid1 - 1);
        }

        if (left2 > right1) {
            return binarySearch(nums1, nums2, mid1 + 1, hi);
        }

        if ((M + N) % 2 == 1) {
            return Math.min(right1, right2);
        }
        return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
    }
}
// @lc code=end

