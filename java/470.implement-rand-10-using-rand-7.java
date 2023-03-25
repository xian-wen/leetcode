/*
 * @lc app=leetcode id=470 lang=java
 *
 * [470] Implement Rand10() Using Rand7()
 *
 * https://leetcode.com/problems/implement-rand10-using-rand7/description/
 *
 * algorithms
 * Medium (46.51%)
 * Likes:    990
 * Dislikes: 329
 * Total Accepted:    70.8K
 * Total Submissions: 152.5K
 * Testcase Example:  '1'
 *
 * Given the API rand7() that generates a uniform random integer in the range
 * [1, 7], write a function rand10() that generates a uniform random integer in
 * the range [1, 10]. You can only call the API rand7(), and you shouldn't call
 * any other API. Please do not use a language's built-in random API.
 * 
 * Each test case will have one internal argument n, the number of times that
 * your implemented function rand10() will be called while testing. Note that
 * this is not an argument passed to rand10().
 * 
 * 
 * Example 1:
 * Input: n = 1
 * Output: [2]
 * Example 2:
 * Input: n = 2
 * Output: [2,8]
 * Example 3:
 * Input: n = 3
 * Output: [3,8,10]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 10^5
 * 
 * 
 * 
 * Follow up:
 * 
 * 
 * What is the expected value for the number of calls to rand7() function?
 * Could you minimize the number of calls to rand7()?
 * 
 * 
 */

// @lc code=start
/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    /**
     * Idea: rand7() -> rand49() -> rand40() -> rand10()
     */
    public int rand10() {
        // rand49(): [0, 48]
        int rand49 = 7 * (rand7() - 1) + (rand7() - 1);
        // [0, 39] mod 10 + 1 = [1, 10]
        if (rand49 < 40) {
            return rand49 % 10 + 1;
        }
        return rand10();
    }
}
// @lc code=end

