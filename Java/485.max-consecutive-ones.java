/*
 * @lc app=leetcode id=485 lang=java
 *
 * [485] Max Consecutive Ones
 *
 * https://leetcode.com/problems/max-consecutive-ones/description/
 *
 * algorithms
 * Easy (54.58%)
 * Total Accepted:    129.8K
 * Total Submissions: 237K
 * Testcase Example:  '[1,0,1,1,0,1]'
 *
 * Given a binary array, find the maximum number of consecutive 1s in this
 * array.
 * 
 * Example 1:
 * 
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive
 * 1s.
 * ⁠   The maximum number of consecutive 1s is 3.
 * 
 * 
 * 
 * Note:
 * 
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 * 
 * 
 */
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++; // count consecutive 1s
                if (count > max) { // update max
                    max = count;
                }
            } else { // if 0, recount
                count = 0; 
            }
        }

        return max;
    }
}

