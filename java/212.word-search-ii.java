import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 */

// @lc code=start
class Solution {
    private static final int R = 26;

    private class Node {
        private Node[] next;
        private String word;

        public Node() {
            next = new Node[R];
        }
    }

    private class Trie {
        private Node root;

        public void insert(String word) {
            root = insert(root, word, 0);
        }

        private Node insert(Node node, String word, int index) {
            if (node == null) {
                node = new Node();
            }

            if (index == word.length()) {
                node.word = word;
            } else {
                char c = word.charAt(index);
                node.next[c - 'a'] = insert(node.next[c - 'a'], word, index + 1);
            }
            return node;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int M = board.length, N = board[0].length;
        for (int r = 0; r < M; ++r) {
            for (int c = 0; c < N; ++c) {
                backtrack(board, r, c, trie.root, res);
            }
        }
        return res;
    }

    private void backtrack(char[][] board, int r, int c, Node node, 
                           List<String> res) {
        if (node == null) {
            return;
        }

        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }
        
        if (!isValid(board, r, c) || board[r][c] == '#') {
            return;
        }

        char old = board[r][c];
        node = node.next[old - 'a'];

        board[r][c] = '#';
        backtrack(board, r + 1, c, node, res);
        backtrack(board, r - 1, c, node, res);
        backtrack(board, r, c + 1, node, res);
        backtrack(board, r, c - 1, node, res);
        board[r][c] = old;
    }


    private boolean isValid(char[][] board, int r, int c) {
        int M = board.length, N = board[0].length;
        return r >= 0 && r < M && c >= 0 && c < N;
    }
}
// @lc code=end

