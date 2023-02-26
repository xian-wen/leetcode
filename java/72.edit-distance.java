import java.util.Arrays;

/*
 * @lc app=leetcode id=72 lang=java
 *
 * [72] Edit Distance
 *
 * https://leetcode.com/problems/edit-distance/description/
 *
 * algorithms
 * Hard (53.10%)
 * Likes:    11481
 * Dislikes: 132
 * Total Accepted:    596K
 * Total Submissions: 1.1M
 * Testcase Example:  '"horse"\n"ros"'
 *
 * Given two strings word1 and word2, return the minimum number of operations
 * required to convert word1 to word2.
 * 
 * You have the following three operations permitted on a word:
 * 
 * 
 * Insert a character
 * Delete a character
 * Replace a character
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation: 
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation: 
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= word1.length, word2.length <= 500
 * word1 and word2 consist of lowercase English letters.
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Subproblem:
    //  * count[i][j] = the minimum number of operations to convert word1[0..(i-1)]
    //  * to word2[0..(j-1)].
    //  * 
    //  * Recursive relation:
    //  * count[i][j] = 1 + min{count[i-1][j], count[i][j-1], count[i-1][j-1]} if word1[i-1] != word2[j-1]
    //  *             = count[i-1][j-1]                                        otherwise
    //  * where count[i-1][j] represents deleting word1[i-1] or adding word2[j-1],
    //  *       count[i][j-1] represents adding word[i-1] or deleting word2[j-1],
    //  *       count[i-1][j-1] represents replacing word1[i-1] to word2[j-1].
    //  * count[i][0] = i
    //  * count[0][j] = j
    //  * 
    //  * Time complexity:
    //  * O(MN)
    //  */
    // public int minDistance(String word1, String word2) {
    //     int M = word1.length(), N = word2.length();
    //     int[][] count = new int[M + 1][N + 1];
    //     for (int i = 0; i <= M; ++i) {
    //         for (int j = 0; j <= N; ++j) {
    //             if (i == 0) {
    //                 count[i][j] = j;
    //             } else if (j == 0) {
    //                 count[i][j] = i;
    //             } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
    //                 count[i][j] = count[i - 1][j - 1];
    //             } else {
    //                 count[i][j] = 1 + Math.min(count[i - 1][j - 1], 
    //                         Math.min(count[i - 1][j], count[i][j - 1]));
    //             }
    //         }
    //     }
    //     return count[M][N];
    // }

    /**
     * Space optimization.
     */
    public int minDistance(String word1, String word2) {
        int M = word1.length(), N = word2.length();
        if (M < N) {
            return minDistance(word2, word1);
        }

        int[] count = new int[N + 1];
        for (int i = 0; i <= M; ++i) {
            for (int j = 0, up = i, upLeft; j <= N; ++j) {
                upLeft = up;
                up = count[j];
                if (i == 0) {
                    count[j] = j;
                } else if (j == 0) {
                    count[j] = i;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    count[j] = upLeft;
                } else {
                    count[j] = 1 + Math.min(upLeft, Math.min(up, count[j - 1]));
                }
            }
        }
        return count[N];
    }
}
// @lc code=end

