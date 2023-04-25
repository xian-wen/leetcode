import java.util.Arrays;

/*
 * @lc app=leetcode id=204 lang=java
 *
 * [204] Count Primes
 *
 * https://leetcode.com/problems/count-primes/description/
 *
 * algorithms
 * Medium (33.07%)
 * Likes:    6423
 * Dislikes: 1228
 * Total Accepted:    705.5K
 * Total Submissions: 2.1M
 * Testcase Example:  '10'
 *
 * Given an integer n, return the number of prime numbers that are strictly
 * less than n.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 0
 * Output: 0
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: n = 1
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= n <= 5 * 10^6
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Use long
    //  * 
    //  * Sieve of Eratosthenes:
    //  * https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
    //  */
    // public int countPrimes(int n) {
    //     boolean[] sieved = new boolean[n];
    //     int count = 0;
    //     for (int i = 2; i < n; ++i) {
    //         if (!sieved[i]) {
    //             ++count;
    //             // Exclude all multiples of i.
    //             // Note: when n = 5e6, j = 2.5e13 < 0 (2's complete) < n,
    //             // out of bounds of sieved!!!
    //             for (long j = (long) i * i; j < n; j += i) {
    //                 sieved[(int) j] = true;
    //             }
    //         }
    //     }
    //     return count;
    // }

    /**
     * Solution 2: No long
     */
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        int end = (int) Math.sqrt(n);
        for (int i = 2; i <= end; ++i) {
            if (isPrime[i]) {
                // Mark all multiples of i as not prime.
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i]) {
                ++count;
            }
        }
        return count;
    }
}
// @lc code=end

