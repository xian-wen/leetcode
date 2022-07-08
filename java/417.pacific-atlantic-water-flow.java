import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=417 lang=java
 *
 * [417] Pacific Atlantic Water Flow
 *
 * https://leetcode.com/problems/pacific-atlantic-water-flow/description/
 *
 * algorithms
 * Medium (47.33%)
 * Likes:    4046
 * Dislikes: 895
 * Total Accepted:    222.5K
 * Total Submissions: 441.8K
 * Testcase Example:  '[[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]'
 *
 * There is an m x n rectangular island that borders both the Pacific Ocean and
 * Atlantic Ocean. The Pacific Ocean touches the island's left and top edges,
 * and the Atlantic Ocean touches the island's right and bottom edges.
 * 
 * The island is partitioned into a grid of square cells. You are given an m x
 * n integer matrix heights where heights[r][c] represents the height above sea
 * level of the cell at coordinate (r, c).
 * 
 * The island receives a lot of rain, and the rain water can flow to
 * neighboring cells directly north, south, east, and west if the neighboring
 * cell's height is less than or equal to the current cell's height. Water can
 * flow from any cell adjacent to an ocean into the ocean.
 * 
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci]
 * denotes that rain water can flow from cell (ri, ci) to both the Pacific and
 * Atlantic oceans.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: heights =
 * [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: heights = [[2,1],[1,2]]
 * Output: [[0,0],[0,1],[1,0],[1,1]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == heights.length
 * n == heights[r].length
 * 1 <= m, n <= 200
 * 0 <= heights[r][c] <= 10^5
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        M = heights.length;
        N = heights[0].length;
        this.heights = heights;
        boolean[][] pacific = new boolean[M][N];
        boolean[][] atlantic = new boolean[M][N];
        
        for (int r = 0; r < M; ++r) {
            explore(pacific, r, 0);
            explore(atlantic, r, N - 1);
        }
        
        for (int c = 0; c < N; ++c) {
            explore(pacific, 0, c);
            explore(atlantic, M - 1, c);
        }
        
        List<List<Integer>> points = new ArrayList<>();
        for (int r = 0; r < M; ++r) {
            for (int c = 0; c < N; ++c) {
                if (pacific[r][c] && atlantic[r][c]) {
                    List<Integer> point = new ArrayList<>();
                    point.add(r);
                    point.add(c);
                    points.add(point);
                }
            }
        }
        return points;
    }


    private void explore(boolean[][] reach, int row, int col) {
        if (reach[row][col]) {
            return;
        }
        
        reach[row][col] = true;
        for (int d = 0; d < DIRECTION.length; ++d) {
            int r = row + DIRECTION[d][0];
            int c = col + DIRECTION[d][1];
            if (validate(r, c) && heights[r][c] >= heights[row][col]) {
                explore(reach, r, c);
            }
        }
    }
    
    private boolean validate(int row, int col) {
        return row >= 0 && row < M && col >= 0 && col < N;
    }

    private static final int[][] DIRECTION = {
        {-1, 0},  // North
        {0, 1},   // East
        {1, 0},   // South
        {0, -1}   // West
    };
    private int[][] heights;
    private int M;  // # rows
    private int N;  // # cols
}
// @lc code=end

