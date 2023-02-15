import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=241 lang=java
 *
 * [241] Different Ways to Add Parentheses
 *
 * https://leetcode.com/problems/different-ways-to-add-parentheses/description/
 *
 * algorithms
 * Medium (63.68%)
 * Likes:    4547
 * Dislikes: 224
 * Total Accepted:    188.9K
 * Total Submissions: 296.6K
 * Testcase Example:  '"2-1-1"'
 *
 * Given a string expression of numbers and operators, return all possible
 * results from computing all the different possible ways to group numbers and
 * operators. You may return the answer in any order.
 * 
 * The test cases are generated such that the output values fit in a 32-bit
 * integer and the number of different results does not exceed 10^4.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: expression = "2-1-1"
 * Output: [0,2]
 * Explanation:
 * ((2-1)-1) = 0 
 * (2-(1-1)) = 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: expression = "2*3-4*5"
 * Output: [-34,-14,-10,-10,10]
 * Explanation:
 * (2*(3-(4*5))) = -34 
 * ((2*3)-(4*5)) = -14 
 * ((2*(3-4))*5) = -10 
 * (2*((3-4)*5)) = -10 
 * (((2*3)-4)*5) = 10
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= expression.length <= 20
 * expression consists of digits and the operator '+', '-', and '*'.
 * All the integer values in the input expression are in the range [0, 99].
 * 
 * 
 */

// @lc code=start
class Solution {
    private String expression;
    private Map<String, List<Integer>> cache;

    /**
     * Solution 1: 
     * Divide and Conquer (with memorization). However, adding memorization, the 
     * runtime does not improve, maybe the cost of frequent substring operations 
     * in `computeWithMemorization` offsets the benefit of memorization.
     * 
     * Solution 2: 
     * Dynamic programming.
     */
    public List<Integer> diffWaysToCompute(String expression) {
        this.expression = expression;
        cache = new HashMap<>();
        return diffWaysToCompute(0, expression.length());
    }

    /**
     * Use indices to avoid frequently doing substring operation.
     * Subexpression: [start, end)
     */
    private List<Integer> diffWaysToCompute(int begin, int end) {
        List<Integer> res = new ArrayList<>();
        for (int i = begin; i < end; ++i) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                // If using memorization, replace `diffWaysToCompute`
                // with `computeWithMemorization`.
                List<Integer> left = diffWaysToCompute(begin, i);
                List<Integer> right = diffWaysToCompute(i + 1, end);
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+' -> {
                                res.add(l + r);
                            }
                            case '-' -> {
                                res.add(l - r);
                            }
                            case '*' -> {
                                res.add(l * r);
                            }
                        }
                    }
                }
            }
        }

        if (res.isEmpty()) {
            res.add(Integer.parseInt(expression.substring(begin, end)));
        }
        return res;
    }

    private List<Integer> computeWithMemorization(int begin, int end) {
        String subexpression = expression.substring(begin, end);
        if (cache.containsKey(subexpression)) {
            return cache.get(subexpression);
        }

        List<Integer> res = diffWaysToCompute(begin, end);
        cache.put(expression, res);
        return res;
    }
}
// @lc code=end

