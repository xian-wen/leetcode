/*
 * @lc app=leetcode id=768 lang=java
 *
 * [768] Max Chunks To Make Sorted II
 *
 * https://leetcode.com/problems/max-chunks-to-make-sorted-ii/description/
 *
 * algorithms
 * Hard (52.90%)
 * Likes:    1575
 * Dislikes: 46
 * Total Accepted:    51.7K
 * Total Submissions: 97.7K
 * Testcase Example:  '[5,4,3,2,1]'
 *
 * You are given an integer array arr.
 * 
 * We split arr into some number of chunks (i.e., partitions), and individually
 * sort each chunk. After concatenating them, the result should equal the
 * sorted array.
 * 
 * Return the largest number of chunks we can make to sort the array.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: arr = [5,4,3,2,1]
 * Output: 1
 * Explanation:
 * Splitting into two or more chunks will not return the required result.
 * For example, splitting into [5, 4], [3, 2, 1] will result in [4, 5, 1, 2,
 * 3], which isn't sorted.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: arr = [2,1,3,4,4]
 * Output: 4
 * Explanation:
 * We can split into two chunks, such as [2, 1], [3, 4, 4].
 * However, splitting into [2, 1], [3], [4], [4] is the highest number of
 * chunks possible.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= arr.length <= 2000
 * 0 <= arr[i] <= 10^8
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * If all of the elements in the left part of arr is <= all of the elements 
     * in the right part, i.e. max of the left part <= min of the right part, 
     * then there is a thunk.
     */
    public int maxChunksToSorted(int[] arr) {
        int N = arr.length;
        int[] minFromRight = new int[N];
        minFromRight[N - 1] = arr[N - 1];
        for (int i = N - 2; i >= 0; --i) {
            minFromRight[i] = Math.min(minFromRight[i + 1], arr[i]);
        }

        int count = 0, max = arr[0];
        for (int i = 0; i < N - 1; ++i) {
            max = Math.max(max, arr[i]);
            if (max <= minFromRight[i + 1]) {
                ++count;
            }
        }
        return count + 1;
    }
}
// @lc code=end

