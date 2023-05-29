import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 *
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 *
 * algorithms
 * Medium (64.15%)
 * Likes:    9759
 * Dislikes: 385
 * Total Accepted:    1M
 * Total Submissions: 1.6M
 * Testcase Example:  '[1,1,1,2,2,3]\n2'
 *
 * Given an integer array nums and an integer k, return the k most frequent
 * elements. You may return the answer in any order.
 * 
 * 
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 * 
 * 
 * 
 * Follow up: Your algorithm's time complexity must be better than O(n log n),
 * where n is the array's size.
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Priority Queue
    //  */
    // public int[] topKFrequent(int[] nums, int k) {
    //     if (k == nums.length) {
    //         return nums;
    //     }

    //     Map<Integer, Integer> map = new HashMap<>();
    //     for (int num : nums) {
    //         map.put(num, map.getOrDefault(num, 0) + 1);
    //     }
        
    //     Queue<Integer> pq = new PriorityQueue<>(
    //         (k1, k2) -> Integer.compare(map.get(k2), map.get(k1)));

    //     for (int key : map.keySet()) {
    //         pq.offer(key);
    //     }

    //     int[] res = new int[k];
    //     for (int i = 0; i < k; i++) {
    //         res[i] = pq.poll();
    //     }
    //     return res;
    // }

    /**
     * Solution 2: Count
     */
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int[] map = new int[max - min + 1];
        for (int num : nums) {
            ++map[num - min];
        }
        
        // Mirror of map, i.e., count -> nums, count is at most N.
        int N = nums.length, maxCount = 0;
        List<Integer>[] mirror = new List[N + 1];
        for (int num = min; num <= max; ++num) {
            int count = map[num - min];
            if (count == 0) {
                continue;
            }

            if (mirror[count] == null) {
                mirror[count] = new ArrayList<>();
            }

            mirror[count].add(num);
            maxCount = Math.max(maxCount, count);
        }

        int[] res = new int[k];
        // Since the answer is unique, we can also put i < k in the condition
        // of the outer for loop, not only in the inner for loop.
        for (int c = maxCount, i = 0; c > 0 && i < k; --c) {
            if (mirror[c] == null) {
                continue;
            }

            for (int num : mirror[c]) {
                res[i++] = num;
            }
        }
        return res;
    }
}
// @lc code=end

