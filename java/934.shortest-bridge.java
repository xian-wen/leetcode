import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=934 lang=java
 *
 * [934] Shortest Bridge
 *
 * https://leetcode.com/problems/shortest-bridge/description/
 *
 * algorithms
 * Medium (51.98%)
 * Likes:    2844
 * Dislikes: 134
 * Total Accepted:    100.8K
 * Total Submissions: 188.9K
 * Testcase Example:  '[[0,1],[1,0]]'
 *
 * You are given an n x n binary matrix grid where 1 represents land and 0
 * represents water.
 * 
 * An island is a 4-directionally connected group of 1's not connected to any
 * other 1's. There are exactly two islands in grid.
 * 
 * You may change 0's to 1's to connect the two islands to form one island.
 * 
 * Return the smallest number of 0's you must flip to connect the two
 * islands.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: grid = [[0,1],[1,0]]
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
 * Output: 2
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == grid.length == grid[i].length
 * 2 <= n <= 100
 * grid[i][j] is either 0 or 1.
 * There are exactly two islands in grid.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int shortestBridge(int[][] grid) {
        M = grid.length;
        N = grid[0].length;
        this.grid = grid;

        // DFS find the first island and add all the zeros at the first 
        // level (all the 1's adjacent 0 neighbours) into queue.
        Queue<Point> q = new LinkedList<>();
        for (int r = 0; r < M; ++r) {
            for (int c = 0; c < N; ++c) {
                if (grid[r][c] == 1) {
                    dfs(r, c, q);
                    break;
                }
            }

            if (!q.isEmpty()) {
                break;
            }
        }

        // BFS get the shortest distance from first level zeros to the first one. 
        return bfs(q);
    }

    private void dfs(int row, int col, Queue<Point> queue) {
        if (grid[row][col] == 0) {
            grid[row][col] = -1;  // visited
            queue.offer(new Point(row, col, 1));
            return;
        }

        grid[row][col] = -1;
        for (int[] dir : DIRECTION) {
            int r = row + dir[0];
            int c = col + dir[1];
            if (validate(r, c) && grid[r][c] != -1) {
                dfs(r, c, queue);
            }
        }
    }

    private boolean validate(int row, int col) {
        return row >= 0 && row < M && col >=0 && col < N;
    }

    private int bfs(Queue<Point> queue) {
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int[] dir : DIRECTION) {
                int r = p.row + dir[0];
                int c = p.col + dir[1];
                if (validate(r, c) && grid[r][c] != -1) {
                    if (grid[r][c] == 1) {
                        return p.level;
                    }

                    // grid[r][c] == 0
                    grid[r][c] = -1;  // visited
                    queue.offer(new Point(r, c, p.level + 1));
                }
            }
        }
        return -1;
    }

    private class Point {
        int row, col, level;
        Point(int row, int col, int level) {
            this.row = row;
            this.col = col;
            this.level = level;
        }
        
        @Override
        public String toString() {
            return "[" + row + ", " + col + ", " + level + "]";
        }
    }

    private static final int[][] DIRECTION = {
        {-1, 0},  // North
        {0, 1},   // East
        {1, 0},   // South
        {0, -1}   // West
    };
    private int M;  // # rows
    private int N;  // # cols
    private int[][] grid;
}
// @lc code=end

