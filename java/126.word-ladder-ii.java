import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode id=126 lang=java
 *
 * [126] Word Ladder II
 */

// @lc code=start

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, 
                                          List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return res;
        }

        Map<String, List<String>> graph = new HashMap<>();
        bfs(beginWord, endWord, wordSet, graph);
        dfs(endWord, beginWord, graph, new ArrayList<>(), res);
        return res;
    }

    /**
     * Build the graph from endWord to beginWord.
     */
    private void bfs(String beginWord, String endWord, Set<String> wordSet, 
                     Map<String, List<String>> graph) {
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        // Visit beginWord.
        wordSet.remove(beginWord);
        boolean found = false;
        while (!queue.isEmpty() && !found) {
            int size = queue.size();
            Set<String> nextLevel = new HashSet<>();
            for (int i = 0; i < size; ++i) {
                String word = queue.poll();
                for (String next : getNeighbors(word, wordSet)) {
                    graph.putIfAbsent(next, new ArrayList<>());
                    graph.get(next).add(word);

                    if (next.equals(endWord)) {
                        found = true;
                    }

                    if (!nextLevel.contains(next)) {
                        queue.offer(next);
                        nextLevel.add(next);
                    }
                }
            }

            // All strings in nextLevel are visited.
            wordSet.removeAll(nextLevel);
        }
    }

    private List<String> getNeighbors(String word, Set<String> wordSet) {
        List<String> res = new ArrayList<>();
        int N = word.length();
        char[] chars = word.toCharArray();
        for (int i = 0; i < N; ++i) {
            char old = chars[i];
            for (char c = 'a'; c <= 'z'; ++c) {
                chars[i] = c;
                if (c == old) {
                    continue;
                }

                String next = String.valueOf(chars);
                if (wordSet.contains(next)) {
                    res.add(next);
                }
            }

            chars[i] = old;
        }
        return res;
    }

    /**
     * Backtracking to get the path from endWord to beginWord, 
     * so the path needs to be reversed.
     */
    private void dfs(String word, String endWord, 
                     Map<String, List<String>> graph, 
                     List<String> temp, List<List<String>> res) {
        if (word.equals(endWord)) {
            List<String> path = new ArrayList<>(temp);
            path.add(word);
            Collections.reverse(path);
            res.add(path);
            return;
        }

        if (!graph.containsKey(word)) {
            return;
        }

        temp.add(word);
        for (String next : graph.get(word)) {
            dfs(next, endWord, graph, temp, res);
        }

        temp.remove(temp.size() - 1);
    }
}
// @lc code=end

