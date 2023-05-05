import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=496 lang=java
 *
 * [496] Next Greater Element I
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = nextGreaterElement(nums2);
        int i = 0;
        for (int num : nums1) {
            nums1[i++] = map.getOrDefault(num, -1);
        }
        return nums1;
    }

    private Map<Integer, Integer> nextGreaterElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        int N = nums.length;
        for (int i = 0; i < N; ++i) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                map.put(nums[stack.pop()], nums[i]);
            }

            stack.push(i);
        }
        return map;
    }
}
// @lc code=end

