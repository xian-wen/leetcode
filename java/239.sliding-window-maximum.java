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
    /**
     * MonotonicQueue stores numbers in descending order, i.e., the leftmost is
     * always the maximum.
     */
    private class MonotonicQueue {
        private Deque<Integer> dq;

        public MonotonicQueue() {
            dq = new ArrayDeque<>();
        }

        public void offer(int x) {
            while (!dq.isEmpty() && dq.peekLast() < x) {
                dq.pollLast();
            }

            dq.offerLast(x);
        }

        public void poll(int x) {
            if (dq.peekFirst() == x) {
                dq.pollFirst();
            }
        }

        public int peek() {
            return dq.peekFirst();
        }

        @Override
        public String toString() {
            return dq.toString();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        int[] res = new int[N - k + 1];
        MonotonicQueue win = new MonotonicQueue();
        for (int i = 0; i < N; ++i) {
            // Add current into sliding window.
            win.offer(nums[i]);
            
            // A valid sliding window needs to be constructed first. 
            if (i < k - 1) {
                continue;
            }
            
            // Store the max, the left in the current window, into res.
            res[i - k + 1] = win.peek();
            // Remove the left in the current window.
            win.poll(nums[i - k + 1]);
        }
        return res;
    }
}
// @lc code=end

