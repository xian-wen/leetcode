import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
 * @lc app=leetcode id=1696 lang=java
 *
 * [1696] Jump Game VI
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Dynamic Programming (TLE)
    //  * 
    //  * Subproblem:
    //  * score[i] = the maximum score gained from index 0 to i.
    //  * 
    //  * Recurrence relation:
    //  * score[i] = max{score[i-k], score[i-k+1], ..., score[i-1]} + nums[i]
    //  * score[0] = nums[0]
    //  * 
    //  * Time complexity:
    //  * O(kN)
    //  */
    // public int maxResult(int[] nums, int k) {
    //     int N = nums.length;
    //     int[] score = new int[N];
    //     score[0] = nums[0];
    //     for (int i = 1; i < N; ++i) {
    //         score[i] = Integer.MIN_VALUE;
    //         for (int j = Math.max(0, i - k); j < i; ++j) {
    //             score[i] = Math.max(score[i], score[j] + nums[i]);
    //         }
    //     }
    //     return score[N - 1];
    // }

    // /**
    //  * Solution 2: Dynamic Programming (Space Optimization, TLE)
    //  */
    // public int maxResult(int[] nums, int k) {
    //     int N = nums.length;
    //     for (int i = 1; i < N; ++i) {
    //         int max = Integer.MIN_VALUE;
    //         for (int j = Math.max(0, i - k); j < i; ++j) {
    //             max = Math.max(max, nums[j] + nums[i]);
    //         }

    //         nums[i] = max;
    //     }
    //     return nums[N - 1];
    // }

    private class MonotonicQueue {
        private Deque<Integer> queue;
        private int[] nums;

        public MonotonicQueue(int[] nums) {
            this.nums = nums;
            queue = new ArrayDeque<>();
        }

        public void offer(int i) {
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            
            queue.offerLast(i);
        }

        public void poll(int i) {
            if (queue.peekFirst() <= i) {
                queue.pollFirst();
            }
        }

        public int peek() {
            return queue.peekFirst();
        }
    }

    /**
     * Solution 3: Monotonic Queue
     * 
     * nums[i] = max{nums[i-k], nums[i-k+1], ..., nums[i-1]} + nums[i]
     */
    public int maxResult(int[] nums, int k) {
        int N = nums.length;
        MonotonicQueue win = new MonotonicQueue(nums);
        win.offer(0);
        for (int i = 1; i < N; ++i) {
            nums[i] = nums[win.peek()] + nums[i];
            win.offer(i);
            win.poll(i - k);
        }
        return nums[N - 1];
    }
}
// @lc code=end

