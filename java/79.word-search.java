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
        int[] boardMap = new int[128];
        for (char[] row : board) {
            for (char c : row) {
                ++boardMap[c];
            }
        }
        
        int[] wordMap = new int[128];
        for (char c : word.toCharArray()) {
            ++wordMap[c];
            if (wordMap[c] > boardMap[c]) {
                return false;
            }
        }
        
        // Make the less frequent found first.
        char first = word.charAt(0), last = word.charAt(word.length() - 1);
        if (boardMap[first] > boardMap[last]) {
            word = new StringBuilder(word).reverse().toString();
        }
        
        int rows = board.length, cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if (backtrack(board, visited, row, col, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, boolean[][] visited, int row, 
                              int col, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        if (!isValid(board, row, col) || visited[row][col] 
                || board[row][col] != word.charAt(index)) {
            return false;
        }

        visited[row][col] = true;
        boolean res = false;
        res = res || backtrack(board, visited, row + 1, col, word, index + 1);
        res = res || backtrack(board, visited, row - 1, col, word, index + 1);
        res = res || backtrack(board, visited, row, col + 1, word, index + 1);
        res = res || backtrack(board, visited, row, col - 1, word, index + 1);
        visited[row][col] = false;
        return res;
    }

    private boolean isValid(char[][] board, int row, int col) {
        int rows = board.length, cols = board[0].length;
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}
// @lc code=end

