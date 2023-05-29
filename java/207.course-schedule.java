import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 *
 * https://leetcode.com/problems/course-schedule/description/
 *
 * algorithms
 * Medium (45.36%)
 * Likes:    12812
 * Dislikes: 504
 * Total Accepted:    1.1M
 * Total Submissions: 2.5M
 * Testcase Example:  '2\n[[1,0]]'
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to
 * numCourses - 1. You are given an array prerequisites where prerequisites[i]
 * = [ai, bi] indicates that you must take course bi first if you want to take
 * course ai.
 * 
 * 
 * For example, the pair [0, 1], indicates that to take course 0 you have to
 * first take course 1.
 * 
 * 
 * Return true if you can finish all courses. Otherwise, return false.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0. So it is possible.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0, and to take course 0 you
 * should also have finished course 1. So it is impossible.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 * 
 * 
 */

// @lc code=start
class Solution {
    private class DiGraph {
        private int V, E;
        private List<Integer>[] adj;
        private int[] indegree;

        public DiGraph(int V, int[][] edges) {
            this.V = V;
            this.E = edges.length;
            adj = new List[V];
            for (int v = 0; v < V; ++v) {
                adj[v] = new LinkedList<>();
            }

            indegree = new int[V];
            for (int[] edge : edges) {
                addEdge(edge[1], edge[0]);
            }
        }

        public void addEdge(int v, int w) {
            adj[v].add(w);
            ++indegree[w];
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%d vertices, %d edges\n", V, E));
            for (int v = 0; v < V; ++v) {
                sb.append(String.format("%d: %s\n", v, adj[v]));
            }
            return sb.toString();
        }
    }

    /**
     * Solution 1: Topological Sort
     */
    private boolean hasCircleIter(DiGraph graph) {
        int V = graph.V;
        Queue<Integer> queue = new LinkedList<>();
        for (int v = 0; v < V; ++v) {
            if (graph.indegree[v] == 0) {
                queue.add(v);
            }
        }

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : graph.adj[v]) {
                --graph.indegree[w];
                if (graph.indegree[w] == 0) {
                    queue.add(w);
                }
            }
        }

        // There exist vertices that could not be handled.
        for (int v = 0; v < V; ++v) {
            if (graph.indegree[v] != 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Solution 2: DFS
     */
    private boolean hasCircle(DiGraph graph) {
        int V = graph.V;
        boolean[] visited = new boolean[V];
        boolean[] onStack = new boolean[V];
        for (int v = 0; v < V; ++v) {
            if (!visited[v]) {
                if (dfs(graph, visited, onStack, v)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(DiGraph graph, boolean[] visited, boolean[] onStack, int v) {
        visited[v] = true;
        onStack[v] = true;
        for (int w : graph.adj[v]) {
            if (!visited[w]) {
                if (dfs(graph, visited, onStack, w)) {
                    return true;
                }
            } else if (onStack[w]) {
                return true;
            }
        }

        onStack[v] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        DiGraph graph = new DiGraph(numCourses, prerequisites);
        return !hasCircleIter(graph);
    }
}
// @lc code=end

