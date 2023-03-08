import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 *
 * https://leetcode.com/problems/sliding-window-maximum/description/
 *
 * algorithms
 * Hard (46.40%)
 * Likes:    13625
 * Dislikes: 441
 * Total Accepted:    723K
 * Total Submissions: 1.6M
 * Testcase Example:  '[1,3,-1,-3,5,3,6,7]\n3'
 *
 * You are given an array of integers nums, there is a sliding window of size k
 * which is moving from the very left of the array to the very right. You can
 * only see the k numbers in the window. Each time the sliding window moves
 * right by one position.
 * 
 * Return the max sliding window.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation: 
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * ⁠1 [3  -1  -3] 5  3  6  7       3
 * ⁠1  3 [-1  -3  5] 3  6  7       5
 * ⁠1  3  -1 [-3  5  3] 6  7       5
 * ⁠1  3  -1  -3 [5  3  6] 7       6
 * ⁠1  3  -1  -3  5 [3  6  7]      7
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1], k = 1
 * Output: [1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * MonotonicQueue stores numbers in descending order, i.e., the leftmost is
    //  * always the maximum.
    //  */
    // private class MonotonicQueue {
    //     private int[] nums;
    //     private Deque<Integer> queue;

    //     public MonotonicQueue(int[] nums) {
    //         this.nums = nums;
    //         queue = new ArrayDeque<>();
    //     }

    //     public void offer(int index) {
    //         while (!queue.isEmpty() && nums[queue.peekLast()] < nums[index]) {
    //             queue.pollLast();
    //         }

    //         queue.offerLast(index);
    //     }

    //     public void poll(int index) {
    //         if (queue.peekFirst() == index) {
    //             queue.pollFirst();
    //         }
    //     }

    //     public int peek() {
    //         return queue.peekFirst();
    //     }

    //     @Override
    //     public String toString() {
    //         return queue.toString();
    //     }
    // }
    
    // /**
    //  * Solution 1: Monotonic Queue
    //  */
    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     int N = nums.length;
    //     int[] res = new int[N - k + 1];
    //     MonotonicQueue win = new MonotonicQueue(nums);
    //     for (int i = 0; i < N; ++i) {
    //         // Add current into sliding window.
    //         win.offer(i);
    //         // A valid sliding window needs to be constructed first.
    //         if (i < k - 1) {
    //             continue;
    //         }

    //         // Store the max, the left in the current window, into res.
    //         res[i - k + 1] = nums[win.peek()];
    //         // Remove the left from the current window.
    //         win.poll(i - k + 1);
    //     }
    //     return res;
    // }

    /**
     * Solution 2: Dynamic Programming
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        int[] left = new int[N], right = new int[N];
        for (int start = 0; start < N; start += k) {
            int end = Math.min(start + k - 1, N - 1);
            // Left -> right.
            left[start] = nums[start];
            for (int i = start + 1; i <= end; ++i) {
                left[i] = Math.max(left[i - 1], nums[i]);
            }
            
            // Right -> left.
            right[end] = nums[end];
            for (int i = end - 1; i >= start; --i) {
                right[i] = Math.max(right[i + 1], nums[i]);
            }
        }
        
        int[] res = new int[N - k + 1];
        for (int i = 0, j = i + k - 1; j < N; ++i, ++j) {
            res[i] = Math.max(right[i], left[j]);
        }
        return res;
    }
}
// @lc code=end

