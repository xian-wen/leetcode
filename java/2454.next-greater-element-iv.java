import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
 * @lc app=leetcode id=2454 lang=java
 *
 * [2454] Next Greater Element IV
 */

// @lc code=start
class Solution {
    // private int[] seg;

    // private void buildSegmentTree(int[] nums, int lo, int hi, int i) {
    //     if (lo == hi) {
    //         seg[i] = nums[lo];
    //         return;
    //     }

    //     int mid = lo + (hi - lo) / 2;
    //     buildSegmentTree(nums, lo, mid, 2 * i + 1);
    //     buildSegmentTree(nums, mid + 1, hi, 2 * i + 2);
    //     seg[i] = Math.max(seg[2 * i + 1], seg[2 * i + 2]);
    // }

    // private int queryGreater(int num, int start, int lo, int hi, int i) {
    //     if (hi < start || seg[i] <= num) {
    //         return -1;
    //     }

    //     if (lo == hi) {
    //         return lo;
    //     }

    //     int mid = lo + (hi - lo) / 2;
    //     int gt = queryGreater(num, start, lo, mid, 2 * i + 1);
    //     if (gt == -1) {
    //         gt = queryGreater(num, start, mid + 1, hi, 2 * i + 2);
    //     }
    //     return gt;
    // }

    // /**
    //  * Solution 1: Segment Tree
    //  */
    // public int[] secondGreaterElement(int[] nums) {
    //     int N = nums.length;
    //     seg = new int[4 * N];
    //     buildSegmentTree(nums, 0, N - 1, 0);
        
    //     int[] res = new int[N];
    //     for (int i = 0; i < N; ++i) {
    //         // First greater num in [i+1, N-1].
    //         int gt = queryGreater(nums[i], i + 1, 0, N - 1, 0);
    //         if (gt != -1) {
    //             // Second greater number in [first+1, N-1].
    //             gt = queryGreater(nums[i], gt + 1, 0, N - 1, 0);
    //         }

    //         res[i] = gt == -1 ? -1 : nums[gt];
    //     }
    //     return res;
    // }

    /**
     * Solution 2: Monotonic Stack
     */
    public int[] secondGreaterElement(int[] nums) {
        int N = nums.length;
        int[] res = new int[N];
        Arrays.fill(res, -1);

        // stack1: stores indices of the nums having not found the first greater.
        // stack2: stores indices of the nums having found the first, but not the second.
        // temp: used to reverse the indices in stack1 before pushed into stack2.
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        Deque<Integer> temp = new ArrayDeque<>();
        for (int i = 0; i < N; ++i) {
            while (!stack2.isEmpty() && nums[i] > nums[stack2.peek()]) {
                res[stack2.pop()] = nums[i];
            }
            
            while (!stack1.isEmpty() && nums[i] > nums[stack1.peek()]) {
                temp.push(stack1.pop());
            }

            while (!temp.isEmpty()) {
                stack2.push(temp.pop());
            }
            
            stack1.push(i);
        }
        return res;
    }
}
// @lc code=end

