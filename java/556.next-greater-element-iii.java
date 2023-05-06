/*
 * @lc app=leetcode id=556 lang=java
 *
 * [556] Next Greater Element III
 */

// @lc code=start
class Solution {
    public int nextGreaterElement(int n) {
        char[] nums = intToCharArray(n);
        nextPermutation(nums);
        return charArrayToInt(nums, n);
    }

    private char[] intToCharArray(int n) {
        String s = String.valueOf(n);
        return s.toCharArray();
    }

    private int charArrayToInt(char[] nums, int n) {
        String s = String.valueOf(nums);
        long res = Long.parseLong(s);
        return res > Integer.MAX_VALUE || res <= n ? -1 : (int) res;
    }

    private void nextPermutation(char[] nums) {
        int index = indexOfNonIncreasingSuffix(nums);
        if (index > 0) {
            int greater = lastIndexOfGreater(nums, nums[index - 1]);
            swap(nums, index - 1, greater);
        }

        reverseSuffix(nums, index);
    }

    private int indexOfNonIncreasingSuffix(char[] nums) {
        int N = nums.length, i = N - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) {
            --i;
        }
        return i;
    }

    private int lastIndexOfGreater(char[] nums, char num) {
        int N = nums.length, i = N - 1;
        while (i > 0 && num >= nums[i]) {
            --i;
        }
        return i;
    }

    private void reverseSuffix(char[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    private void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

