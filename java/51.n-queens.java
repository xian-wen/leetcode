import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 *
 * https://leetcode.com/problems/n-queens/description/
 *
 * algorithms
 * Hard (55.54%)
 * Likes:    7417
 * Dislikes: 178
 * Total Accepted:    434.4K
 * Total Submissions: 711.3K
 * Testcase Example:  '4'
 *
 * The n-queens puzzle is the problem of placing n queens on an n x n
 * chessboard such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * You may return the answer in any order.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space,
 * respectively.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as
 * shown above
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 1
 * Output: [["Q"]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 9
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        grid = new char[n][n];
        for (char[] row : grid) {
            Arrays.fill(row, '.');
        }

        column = new boolean[n];
        leftDiagonal = new boolean[2 * n - 1];
        rightDiagonal = new boolean[2 * n - 1];

        List<String> temp = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        backtrack(0, temp, res);
        return res;
    }

    private void backtrack(int row, List<String> temp, List<List<String>> res) {
        if (temp.size() == grid.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for (int col = 0; col < grid.length; ++col) {
            if (check(row, col)) {
                set(row, col, temp);
                backtrack(row + 1, temp, res);
                unset(row, col, temp);
            }
        }
    }

    private boolean check(int row, int col) {
        // For points on the left diagonal, row - col is a negative constant.
        // For points on the right diagonal, row + col is a constant.
        return !column[col] && !leftDiagonal[row - col + n - 1] 
            && !rightDiagonal[row + col];
    }

    private void set(int row, int col, List<String> temp) {
        column[col] = true;
        leftDiagonal[row - col + n - 1] = true;
        rightDiagonal[row + col] = true;
        grid[row][col] = 'Q';
        temp.add(new String(grid[row]));
    }

    private void unset(int row, int col, List<String> temp) {
        column[col] = false;
        leftDiagonal[row - col + n - 1] = false;
        rightDiagonal[row + col] = false;
        grid[row][col] = '.';
        temp.remove(temp.size() - 1);
    }

    private int n;
    private char[][] grid;
    private boolean[] column;
    private boolean[] leftDiagonal;
    private boolean[] rightDiagonal;
}
// @lc code=end

