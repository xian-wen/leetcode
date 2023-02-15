import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 *
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 *
 * algorithms
 * Medium (43.79%)
 * Likes:    17205
 * Dislikes: 504
 * Total Accepted:    932.5K
 * Total Submissions: 2.1M
 * Testcase Example:  '[1,1,1]\n2'
 *
 * Given an array of integers nums and an integer k, return the total number of
 * subarrays whose sum equals to k.
 * 
 * A subarray is a contiguous non-empty sequence of elements within an
 * array.
 * 
 * 
 * Example 1:
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 2 * 10^4
 * -1000 <= nums[i] <= 1000
 * -10^7 <= k <= 10^7
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * For prefix sum, sumRange(left, right) = sum[left + 1] - sum[right].
     * 
     * This problem is equivalent to calculate the number of sums such that
     * sum[right + 1] - sum[left] == k, i.e., sum[left] = sum[right + 1] - k.
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0, sumRight = 0, sumLeft;
        // prefixSum -> count
        Map<Integer, Integer> map = new HashMap<>();
        // Similar to sum[0] = 0.
        map.put(0, 1);
        for (int i = 0; i < nums.length; ++i) {
            sumRight += nums[i];
            sumLeft = sumRight - k;
            if (map.containsKey(sumLeft)) {
                count += map.get(sumLeft);
            }
            
            map.put(sumRight, map.getOrDefault(sumRight, 0) + 1);
        }
        return count;
    }
}
// @lc code=end

