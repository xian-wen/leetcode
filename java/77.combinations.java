import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 *
 * https://leetcode.com/problems/combinations/description/
 *
 * algorithms
 * Medium (62.16%)
 * Likes:    4548
 * Dislikes: 153
 * Total Accepted:    552.3K
 * Total Submissions: 851.6K
 * Testcase Example:  '4\n2'
 *
 * Given two integers n and k, return all possible combinations of k numbers
 * out of the range [1, n].
 * 
 * You may return the answer in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 4, k = 2
 * Output:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 1, k = 1
 * Output: [[1]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 20
 * 1 <= k <= n
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(n, k, 1, temp, combinations);
        return combinations;
    }

    private void backtrack(int n, int k, int start, 
            List<Integer> temp, List<List<Integer>> combinations) {
        if (temp.size() == k) {
            combinations.add(new ArrayList<>(temp));
            return;
        }

        // [n - (k - temp.size()) + 1, n]: has a length of k - temp.size(). 
        for (int i = start; i <= n - (k - temp.size()) + 1; ++i) {
            temp.add(i);
            // Next start should be greater than current added i.
            backtrack(n, k, i + 1, temp, combinations);
            temp.remove(temp.size() - 1);
        }
    }
}
// @lc code=end

