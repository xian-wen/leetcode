/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input array is sorted
 *
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 *
 * algorithms
 * Easy (49.54%)
 * Total Accepted:    227.1K
 * Total Submissions: 456.1K
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * Given an array of integers that is already sorted in ascending order, find
 * two numbers such that they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2.
 * 
 * Note:
 * 
 * 
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may
 * not use the same element twice.
 * 
 * 
 * Example:
 * 
 * 
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 * 
 */

/* 
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            // j = i + 1, avoid repetition
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    // index from 1, not 0
                    res[0] = i + 1;
                    res[1] = j + 1;
                    break;
                } else if (numbers[i] + numbers[j] > target)
                    break;
            }
        }

        return res;
    }
}
 */

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;

        // from both sides to middle
        while (numbers[l] + numbers[r] != target) { 
            if (numbers[l] + numbers[r] > target)
                --r;
            else
                ++l;
        }

        return new int[] {l + 1, r + 1}; // index from 1, not 0
    }
}

