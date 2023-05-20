import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=1313 lang=java
 *
 * [1313] Decompress Run-Length Encoded List
 */

// @lc code=start
class Solution {
    public int[] decompressRLElist(int[] nums) {
        int N = nums.length, size = 0;
        for (int i = 0; i < N; i += 2) {
            size += nums[i];
        }

        int[] res = new int[size];
        int start = 0;
        for (int i = 0; i < N; i += 2) {
            Arrays.fill(res, start, start + nums[i], nums[i + 1]);
            start += nums[i];
        }
        return res;
    }
}
// @lc code=end

