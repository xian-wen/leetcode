import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
 * @lc app=leetcode id=503 lang=java
 *
 * [503] Next Greater Element II
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int N = nums.length;
        int[] res = new int[N];
        Arrays.fill(res, -1);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < 2 * N; ++i) {
            int current = nums[i % N];
            while (!stack.isEmpty() && current > nums[stack.peek()]) {
                res[stack.pop()] = current;
            }

            stack.push(i % N);
        }
        return res;
    }
}
// @lc code=end

