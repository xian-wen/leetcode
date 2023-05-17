/*
 * @lc app=leetcode id=307 lang=java
 *
 * [307] Range Sum Query - Mutable
 *
 * https://leetcode.com/problems/range-sum-query-mutable/description/
 *
 * algorithms
 * Medium (40.70%)
 * Likes:    4238
 * Dislikes: 232
 * Total Accepted:    241.8K
 * Total Submissions: 594.2K
 * Testcase Example:  '["NumArray","sumRange","update","sumRange"]\n[[[1,3,5]],[0,2],[1,2],[0,2]]'
 *
 * Given an integer array nums, handle multiple queries of the following
 * types:
 * 
 * 
 * Update the value of an element in nums.
 * Calculate the sum of the elements of nums between indices left and right
 * inclusive where left <= right.
 * 
 * 
 * Implement the NumArray class:
 * 
 * 
 * NumArray(int[] nums) Initializes the object with the integer array nums.
 * void update(int index, int val) Updates the value of nums[index] to be
 * val.
 * int sumRange(int left, int right) Returns the sum of the elements of nums
 * between indices left and right inclusive (i.e. nums[left] + nums[left + 1] +
 * ... + nums[right]).
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input
 * ["NumArray", "sumRange", "update", "sumRange"]
 * [[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
 * Output
 * [null, 9, null, 8]
 * 
 * Explanation
 * NumArray numArray = new NumArray([1, 3, 5]);
 * numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
 * numArray.update(1, 2);   // nums = [1, 2, 5]
 * numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 3 * 10^4
 * -100 <= nums[i] <= 100
 * 0 <= index < nums.length
 * -100 <= val <= 100
 * 0 <= left <= right < nums.length
 * At most 3 * 10^4 calls will be made to update and sumRange.
 * 
 * 
 */

// @lc code=start
class NumArray {
    // private int[] seg;
    // private int n;

    // /**
    //  * Solution 1: Segment Tree
    //  */
    // public NumArray(int[] nums) {
    //     n = nums.length;
    //     seg = new int[4 * n];
    //     build(nums, 0, n - 1, 0);
    // }

    // private void build(int[] nums, int lo, int hi, int i) {
    //     if (lo == hi) {
    //         seg[i] = nums[lo];
    //         return;
    //     }

    //     int mid = lo + (hi - lo) / 2;
    //     build(nums, lo, mid, 2 * i + 1);
    //     build(nums, mid + 1, hi, 2 * i + 2);
    //     seg[i] = seg[2 * i + 1] + seg[2 * i + 2];
    // }
    
    // public void update(int index, int val) {
    //     update(index, val, 0, n - 1, 0);
    // }

    // private void update(int idx, int val, int lo, int hi, int i) {
    //     if (lo == hi) {
    //         seg[i] = val;
    //         return;
    //     }

    //     int mid = lo + (hi - lo) / 2;
    //     if (idx <= mid) {
    //         update(idx, val, lo, mid, 2 * i + 1);
    //     } else {
    //         update(idx, val, mid + 1, hi, 2 * i + 2);
    //     }

    //     seg[i] = seg[2 * i + 1] + seg[2 * i + 2];
    // }
    
    // public int sumRange(int left, int right) {
    //     return query(left, right, 0, n - 1, 0);
    // }

    // private int query(int qLo, int qHi, int lo, int hi, int i) {
    //     if (qLo > hi || qHi < lo) {
    //         return 0;
    //     }
        
    //     if (qLo <= lo && qHi >= hi) {
    //         return seg[i];
    //     }
        
    //     int mid = lo + (hi - lo) / 2;
    //     int leftSum = query(qLo, qHi, lo, mid, 2 * i + 1);
    //     int rightSum = query(qLo, qHi, mid + 1, hi, 2 * i + 2);
    //     return leftSum + rightSum;
    // }

    private int[] bit;

    /**
     * Solution 2: Binary Indexed Tree
     */
    public NumArray(int[] nums) {
        int N = nums.length;
        bit = new int[N + 1];
        build(nums);
    }

    private void build(int[] nums) {
        int N = nums.length;
        System.arraycopy(nums, 0, bit, 1, N);
        for (int i = 1; i <= N; ++i) {
            int j = i + lastSetBit(i);
            if (j <= N) {
                bit[j] += bit[i];
            }
        }
    }

    private int lastSetBit(int index) {
        return index & (-index);
    }
    
    public void update(int index, int val) {
        int N = bit.length, delta = val - sumRange(index, index);
        ++index;
        while (index < N) {
            bit[index] += delta;
            index += lastSetBit(index);
        }
    }
    
    public int sumRange(int left, int right) {
        return prefixSum(right) - prefixSum(left - 1);
    }

    private int prefixSum(int index) {
        int sum = 0;
        ++index;
        while (index > 0) {
            sum += bit[index];
            index -= lastSetBit(index);
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
// @lc code=end

