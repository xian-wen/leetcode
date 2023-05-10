import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start

class Solution {
    // /**
    //  * Solution 1: BFS
    //  */
    // public int ladderLength(String beginWord, String endWord, 
    //                         List<String> wordList) {
    //     Queue<String> queue = new ArrayDeque<>();
    //     Set<String> wordSet = new HashSet<>(wordList);
    //     queue.offer(beginWord);
    //     wordSet.remove(beginWord);
    //     int N = beginWord.length(), level = 1;
    //     while (!queue.isEmpty()) {
    //         int size = queue.size();
    //         for (int i = 0; i < size; ++i) {
    //             String curr = queue.poll();
    //             if (curr.equals(endWord)) {
    //                 return level;
    //             }
            
    //             char[] chars = curr.toCharArray();
    //             for (int j = 0; j < N; ++j) {
    //                 char old = chars[j];
    //                 for (char c = 'a'; c <= 'z'; ++c) {
    //                     if (c == old) {
    //                         continue;
    //                     }
                        
    //                     chars[j] = c;
    //                     String next = String.valueOf(chars);
    //                     if (wordSet.contains(next)) {
    //                         queue.offer(next);
    //                         wordSet.remove(next);
    //                     }
    //                 }

    //                 chars[j] = old;
    //             }
    //         }

    //         ++level;
    //     }
    //     return 0;
    // }

    /**
     * Solution 2: Two-end BFS
     */
    public int ladderLength(String beginWord, String endWord, 
                            List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        // beginWord visited
        wordSet.remove(beginWord);
        // beginWord added, endWord added, so set level = 2.
        int N = beginWord.length(), level = 2;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // Always choose the end with a smaller size to begin, 
            // that is why it is called two-end BFS.
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> temp = new HashSet<>();
            for (String word : beginSet) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < N; ++i) {
                    char old = chars[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        if (c == old) {
                            continue;
                        }
                        
                        chars[i] = c;
                        String next = String.valueOf(chars);
                        if (endSet.contains(next)) {
                            return level;
                        }

                        if (wordSet.contains(next)) {
                            temp.add(next);
                            // next visited
                            wordSet.remove(next);
                        }
                    }

                    chars[i] = old;
                }
            }

            beginSet = temp;
            ++level;
        }
        return 0;
    }
}
// @lc code=end

