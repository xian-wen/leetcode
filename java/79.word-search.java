import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 *
 * https://leetcode.com/problems/word-search/description/
 *
 * algorithms
 * Medium (39.22%)
 * Likes:    9901
 * Dislikes: 378
 * Total Accepted:    1M
 * Total Submissions: 2.6M
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * Given an m x n grid of characters board and a string word, return true if
 * word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word
 * = "ABCCED"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word
 * = "SEE"
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word
 * = "ABCB"
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 * 
 * 
 * 
 * Follow up: Could you use search pruning to make your solution faster with a
 * larger board?
 * 
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        M = board.length;
        N = board[0].length;

        Map<Character, Integer> boardMap = new HashMap<>();
        for (char[] row : board) {
            for (char col : row) {
                boardMap.put(col, boardMap.getOrDefault(col, 0) + 1);
            }
        }

        Map<Character, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            wordMap.put(c, wordMap.getOrDefault(c, 0) + 1);
        }

        // The number of a specific character in word is more 
        // than that in board, return false. 
        for (char c : wordMap.keySet()) {
            if (!boardMap.containsKey(c) || boardMap.get(c) < wordMap.get(c)) {
                return false;
            }
        }

        // Making less valid options in the root of the recursion tree.
        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);
        if (boardMap.get(first) > boardMap.get(last)) {
            StringBuilder sb = new StringBuilder(word);
            word = sb.reverse().toString();
        }

        for (int r = 0; r < M; ++r) {
            for (int c = 0; c < N; ++c) {
                if (backtrack(board, r, c, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int row, int col, 
            String word, int index) {
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        if (index == word.length() - 1) {
            return true;
        }

        board[row][col] = '#';
        for (int d = 0; d < DIRECTION.length; ++d) {
            int r = row + DIRECTION[d][0];
            int c = col + DIRECTION[d][1];
            if (validate(r, c)) {
                if (backtrack(board, r, c, word, index + 1)) {
                    return true;
                }
            }
        }

        board[row][col] = word.charAt(index);
        return false;
    }

    private boolean validate(int row, int col) {
        return row >= 0 && row < M && col >= 0 && col < N;
    }

    private static final int[][] DIRECTION = {
        {-1, 0},  // North
        {0, 1},   // East
        {1, 0},   // South
        {0, -1},  // West
    };
    private int M;  // # rows
    private int N;  // # cols
}
// @lc code=end

