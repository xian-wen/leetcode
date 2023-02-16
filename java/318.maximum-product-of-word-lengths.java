import java.util.Arrays;

/*
 * @lc app=leetcode id=318 lang=java
 *
 * [318] Maximum Product of Word Lengths
 *
 * https://leetcode.com/problems/maximum-product-of-word-lengths/description/
 *
 * algorithms
 * Medium (59.95%)
 * Likes:    3178
 * Dislikes: 126
 * Total Accepted:    199.4K
 * Total Submissions: 332.7K
 * Testcase Example:  '["abcw","baz","foo","bar","xtfn","abcdef"]'
 *
 * Given a string array words, return the maximum value of length(word[i]) *
 * length(word[j]) where the two words do not share common letters. If no such
 * two words exist, return 0.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
 * Output: 16
 * Explanation: The two words can be "abcw", "xtfn".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
 * Output: 4
 * Explanation: The two words can be "ab", "cd".
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: words = ["a","aa","aaa","aaaa"]
 * Output: 0
 * Explanation: No such pair of words.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i] consists only of lowercase English letters.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int maxProduct(String[] words) {
        int N = words.length;
        int[] nums = new int[N];
        for (int i = 0; i < N; ++i) {
            nums[i] = wordToBinaryNum(words[i]);
        }

        int max = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = i + 1; j < N; ++j) {
                if (noCommon(nums[i], nums[j])) {
                    int product = words[i].length() * words[j].length();
                    max = Math.max(max, product);
                }
            }
        }
        return max;
    }

    /**
     * Convert a word to binary number by setting each letter to 1 at the
     * corresponding position.
     * e.g., "abc" -> 0b111, "abd" -> 0b1011
     * 
     * 31 ... 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0
     *  0 ...  z  y  x  w  v  u  t  s  r  q  p  o  n  m  l  k j i h g f e d c b a
     */
    private int wordToBinaryNum(String word) {
        int res = 0;
        for (int i = 0; i < word.length(); ++i) {
            int pos = word.charAt(i) - 'a';
            res |= (1 << pos);
        }
        return res;
    }

    private boolean noCommon(int a, int b) {
        return (a & b) == 0;
    }
}
// @lc code=end

