import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: List
    //  */
    // public List<String> wordBreak(String s, List<String> wordDict) {
    //     List<String> res = new ArrayList<>();
    //     Set<String> wordSet = new HashSet<>(wordDict);
    //     backtrack(s, 0, wordSet, new ArrayList<>(), res);
    //     return res;
    // }

    // private void backtrack(String s, int start, Set<String> wordSet, 
    //                        List<String> temp, List<String> res) {
    //     if (start == s.length()) {
    //         res.add(String.join(" ", temp));
    //         return;
    //     }

    //     int N = s.length();
    //     for (int i = start; i < N; ++i) {
    //         String sub = s.substring(start, i + 1);
    //         if (!wordSet.contains(sub)) {
    //             continue;
    //         }

    //         temp.add(sub);
    //         backtrack(s, i + 1, wordSet, temp, res);
    //         temp.remove(temp.size() - 1);
    //     }
    // }

    /**
     * Solution 2: StringBuilder
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordDict);
        backtrack(s, 0, wordSet, new StringBuilder(), res);
        return res;
    }

    private void backtrack(String s, int start, Set<String> wordSet, 
                           StringBuilder temp, List<String> res) {
        if (start == s.length()) {
            res.add(temp.toString());
            return;
        }

        int N = s.length();
        for (int i = start; i < N; ++i) {
            String sub = s.substring(start, i + 1);
            if (!wordSet.contains(sub)) {
                continue;
            }

            int old = temp.length();
            temp.append(sub);
            if (i < N - 1) {
                temp.append(" ");
            }

            backtrack(s, i + 1, wordSet, temp, res);
            temp.setLength(old);
        }
    }    
}
// @lc code=end

