import java.util.Random;

/*
 * @lc app=leetcode id=384 lang=java
 *
 * [384] Shuffle an Array
 *
 * https://leetcode.com/problems/shuffle-an-array/description/
 *
 * algorithms
 * Medium (57.81%)
 * Likes:    1100
 * Dislikes: 830
 * Total Accepted:    297.3K
 * Total Submissions: 514.3K
 * Testcase Example:  '["Solution","shuffle","reset","shuffle"]\n[[[1,2,3]],[],[],[]]'
 *
 * Given an integer array nums, design an algorithm to randomly shuffle the
 * array. All permutations of the array should be equally likely as a result of
 * the shuffling.
 * 
 * Implement the Solution class:
 * 
 * 
 * Solution(int[] nums) Initializes the object with the integer array nums.
 * int[] reset() Resets the array to its original configuration and returns
 * it.
 * int[] shuffle() Returns a random shuffling of the array.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * Output
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 * 
 * Explanation
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // Shuffle the array [1,2,3] and return its result.
 * ⁠                      // Any permutation of [1,2,3] must be equally likely
 * to be returned.
 * ⁠                      // Example: return [3, 1, 2]
 * solution.reset();      // Resets the array back to its original
 * configuration [1,2,3]. Return [1, 2, 3]
 * solution.shuffle();    // Returns the random shuffling of array [1,2,3].
 * Example: return [1, 3, 2]
 * 
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 50
 * -10^6 <= nums[i] <= 10^6
 * All the elements of nums are unique.
 * At most 10^4 calls in total will be made to reset and shuffle.
 * 
 * 
 */

// @lc code=start
class Solution {
    private int[] nums;
    private int[] copy;
    private int N;
    private Random r;

    public Solution(int[] nums) {
        this.nums = nums;
        copy = nums.clone();
        N = nums.length;
        r = new Random();
    }
    
    public int[] reset() {
        return copy;
    }
    
    public int[] shuffle() {
        for (int i = 0; i < N; ++i) {
            // i: [0, N), j: [i, N)
            int j = r.nextInt(N - i) + i;
            swap(i, j);
        }
        return nums;
    }

    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
// @lc code=end

