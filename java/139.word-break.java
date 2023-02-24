import java.util.List;

/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 *
 * https://leetcode.com/problems/word-break/description/
 *
 * algorithms
 * Medium (45.53%)
 * Likes:    13478
 * Dislikes: 568
 * Total Accepted:    1.3M
 * Total Submissions: 2.8M
 * Testcase Example:  '"leetcode"\n["leet","code"]'
 *
 * Given a string s and a dictionary of strings wordDict, return true if s can
 * be segmented into a space-separated sequence of one or more dictionary
 * words.
 * 
 * Note that the same word in the dictionary may be reused multiple times in
 * the segmentation.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet
 * code".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple
 * pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * Subproblem:
     * segmentable[i] = whether s[0..(i-1)] can be segmented using one or more 
     * dictionary words.
     * 
     * Recursive relation:
     * segmentable[i] = OR((s[i-1] ends with wordDict[j]) 
     *                     AND segmentable[i-wordDict[j].length()])
     * segmentable[0] = true
     * 
     * Time complexity:
     * O(NM) where N = s.length(), M = wordDict.size()
     * 
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int N = s.length();
        boolean[] segmentable = new boolean[N + 1];
        segmentable[0] = true;
        for (int i = 1; i <= N; ++i) {
            String str = s.substring(0, i);
            for (String word : wordDict) {
                segmentable[i] = segmentable[i] 
                        || (str.endsWith(word) && segmentable[i - word.length()]);
            }
        }
        return segmentable[N];
    }
}
// @lc code=end

