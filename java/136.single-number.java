/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 *
 * https://leetcode.com/problems/single-number/description/
 *
 * algorithms
 * Easy (70.46%)
 * Likes:    12988
 * Dislikes: 497
 * Total Accepted:    2.1M
 * Total Submissions: 2.9M
 * Testcase Example:  '[2,2,1]'
 *
 * Given a non-empty array of integers nums, every element appears twice except
 * for one. Find that single one.
 * 
 * You must implement a solution with a linear runtime complexity and use only
 * constant extra space.
 * 
 * 
 * Example 1:
 * Input: nums = [2,2,1]
 * Output: 1
 * Example 2:
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * Example 3:
 * Input: nums = [1]
 * Output: 1
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 3 * 10^4
 * -3 * 10^4 <= nums[i] <= 3 * 10^4
 * Each element in the array appears twice except for one element which appears
 * only once.
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Count
    //  */
    // public int singleNumber(int[] nums) {
    //     Map<Integer, Integer> map = new HashMap<>();
    //     for (int num : nums) {
    //         map.put(num, map.getOrDefault(num, 0) + 1);
    //     }

    //     for (int num : map.keySet()) {
    //         if (map.get(num) == 1) {
    //             return num;
    //         }
    //     }
    //     return -1;
    // }

    // /**
    //  * Solution 2: Set
    //  */
    // public int singleNumber(int[] nums) {
    //     Set<Integer> set = new HashSet<>();
    //     for (int num : nums) {
    //         if (!set.contains(num)) {
    //             set.add(num);
    //         } else {
    //             set.remove(num);
    //         }
    //     }

    //     for (int num : set) {
    //         return num;
    //     }        
    //     return -1;
    // }

    // /**
    //  * Solution 3: Sum 1
    //  */
    // public int singleNumber(int[] nums) {
    //     int N = nums.length, res = 0;
    //     Arrays.sort(nums);
    //     for (int i = 0; i < N; ++i) {
    //         if (i % 2 == 0) {
    //             res += nums[i];
    //         } else {
    //             res -= nums[i];
    //         }
    //     }
    //     return res;
    // }

    // /**
    //  * Solution 4: Sum 2
    //  */
    // public int singleNumber(int[] nums) {
    //     Set<Integer> set = new HashSet<>();
    //     int sum = 0;
    //     for (int num : nums) {
    //         set.add(num);
    //         sum += num;
    //     }

    //     int sumSet = 0;
    //     for (int num : set) {
    //         sumSet += num;
    //     }
    //     return 2 * sumSet - sum;
    // }

    // /**
    //  * Solution 5: Sort
    //  */
    // public int singleNumber(int[] nums) {
    //     int N = nums.length, res = -1;
    //     Arrays.sort(nums);
    //     for (int i = 0; i < N - 1; i += 2) {
    //         if (nums[i] != nums[i + 1]) {
    //             return nums[i];
    //         }
    //     }
    //     return nums[N - 1];
    // }

    // /**
    //  * Solution 6: Bit Manipulation
    //  */
    // public int singleNumber(int[] nums) {
    //     int[] bits = new int[32];
    //     int res = 0;
    //     for (int bit = 31; bit >= 0; --bit) {
    //         for (int num : nums) {
    //             bits[bit] += (num >> bit) & 1;
    //         }

    //         if ((bits[bit] & 1) == 1) {
    //             res |= 1 << bit;
    //         }
    //     }
    //     return res;
    // }

    /**
     * Solution 7: XOR
     *
     * x ^ x = 0, x ^ 0 = x
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
// @lc code=end

