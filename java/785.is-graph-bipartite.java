import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=785 lang=java
 *
 * [785] Is Graph Bipartite?
 *
 * https://leetcode.com/problems/is-graph-bipartite/description/
 *
 * algorithms
 * Medium (49.83%)
 * Likes:    5432
 * Dislikes: 289
 * Total Accepted:    351.6K
 * Total Submissions: 671.1K
 * Testcase Example:  '[[1,2,3],[0,2],[0,1,3],[0,2]]'
 *
 * There is an undirected graph with n nodes, where each node is numbered
 * between 0 and n - 1. You are given a 2D array graph, where graph[u] is an
 * array of nodes that node u is adjacent to. More formally, for each v in
 * graph[u], there is an undirected edge between node u and node v. The graph
 * has the following properties:
 * 
 * 
 * There are no self-edges (graph[u] does not contain u).
 * There are no parallel edges (graph[u] does not contain duplicate
 * values).
 * If v is in graph[u], then u is in graph[v] (the graph is undirected).
 * The graph may not be connected, meaning there may be two nodes u and v such
 * that there is no path between them.
 * 
 * 
 * A graph is bipartite if the nodes can be partitioned into two independent
 * sets A and B such that every edge in the graph connects a node in set A and
 * a node in set B.
 * 
 * Return true if and only if it is bipartite.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
 * Output: false
 * Explanation: There is no way to partition the nodes into two independent
 * sets such that every edge connects a node in one and a node in the other.
 * 
 * Example 2:
 * 
 * 
 * Input: graph = [[1,3],[0,2],[1,3],[0,2]]
 * Output: true
 * Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.
 * 
 * 
 * Constraints:
 * 
 * 
 * graph.length == n
 * 1 <= n <= 100
 * 0 <= graph[u].length < n
 * 0 <= graph[u][i] <= n - 1
 * graph[u] does not contain u.
 * All the values of graph[u] are unique.
 * If graph[u] contains v, then graph[v] contains u.
 * 
 * 
 */

// @lc code=start
// DFS
// class Solution {
//     private static final int BLACK = 1;
//     private static final int WHITE = 2;
//     private int[] color;
    
//     public boolean isBipartite(int[][] graph) {
//         color = new int[graph.length];
//         for (int v = 0; v < graph.length; ++v) {
//             if (color[v] == 0) {
//                 color[v] = BLACK;
//                 if (!dfs(graph, v)) {
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }

//     private boolean dfs(int[][] graph, int v) {
//         for (int w : graph[v]) {
//             if (color[w] == 0) {
//                 color[w] = color[v] == BLACK ? WHITE : BLACK; 
//                 if (!dfs(graph, w)) {
//                     return false;
//                 }
//             } else if (color[w] == color[v]) {
//                 return false;
//             }
//         }
//         return true;
//     }
// }

// BFS
class Solution {
    private static final int BLACK = 1;
    private static final int WHITE = 2;
    private int[] color;
    
    public boolean isBipartite(int[][] graph) {
        color = new int[graph.length];
        for (int v = 0; v < graph.length; ++v) {
            if (color[v] == 0) {
                if (!bfs(graph, v)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfs(int[][] graph, int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        color[s] = BLACK;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : graph[v]) {
                if (color[w] == 0) {
                    color[w] = color[v] == BLACK ? WHITE : BLACK;
                    queue.offer(w);
                } else if (color[w] == color[v]) {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

