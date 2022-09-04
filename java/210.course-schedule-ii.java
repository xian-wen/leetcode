import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 *
 * https://leetcode.com/problems/course-schedule-ii/description/
 *
 * algorithms
 * Medium (45.70%)
 * Likes:    7715
 * Dislikes: 262
 * Total Accepted:    700.9K
 * Total Submissions: 1.5M
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
 * Return the ordering of courses you should take to finish all courses. If
 * there are many valid answers, return any of them. If it is impossible to
 * finish all courses, return an empty array.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0. So the correct course order is [0,1].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you
 * should have finished both courses 1 and 2. Both courses 1 and 2 should be
 * taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is
 * [0,2,1,3].
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * All the pairs [ai, bi] are distinct.
 * 
 * 
 */

// @lc code=start
// DFS
class Solution {
    private List<Integer>[] graph;
    private boolean[] visited;
    private boolean[] onStack;
    private boolean hasCycle;
    private Queue<Integer> postorder;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        graph = new List[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            graph[i] = new LinkedList<>();
        }

        for (int[] e : prerequisites) {
            graph[e[1]].add(e[0]);
        }

        visited = new boolean[numCourses];
        onStack = new boolean[numCourses];
        postorder = new LinkedList<>();
        for (int v = 0; v < numCourses; ++v) {
            if (!visited[v]) {
                dfs(v);
            }
        }

        // Cycle detected!
        if (hasCycle) {
            return new int[0];
        }

        // The topological order is the reverse of post order.
        int[] topological = new int[numCourses];
        for (int v = numCourses - 1; v >= 0; --v) {
            topological[v] = postorder.poll();
        }
        return topological;
    }

    private void dfs(int v) {
        visited[v] = true;
        onStack[v] = true;

        for (int w : graph[v]) {
            if (!visited[w]) {
                dfs(w);
            } else if (onStack[w]) {
                // Cycle detected!
                hasCycle = true;
                return;
            }
        }

        postorder.add(v);
        onStack[v] = false;
    }
}

// BFS
// class Solution {
//     private List<List<Integer>> graph;
//     private int[] indegrees;
//     private int count;
//     private Queue<Integer> topological;

//     public int[] findOrder(int numCourses, int[][] prerequisites) {
//         graph = new ArrayList<>(numCourses);
//         for (int v = 0; v < numCourses; ++v) {
//             graph.add(new LinkedList<>());
//         }

//         indegrees = new int[numCourses];
//         for (int[] e : prerequisites) {
//             graph.get(e[1]).add(e[0]);
//             ++indegrees[e[0]];
//         }

//         // Use BFS instead of DFS since there may exist cicles.
//         topological = new LinkedList<>();
//         Queue<Integer> queue = new LinkedList<>();
//         for (int v = 0; v < numCourses; ++v) {
//             if (indegrees[v] == 0) {
//                 queue.offer(v);
//             }
//         }
        
//         bfs(queue);

//         // Cycle detected!
//         if (count != numCourses) {
//             return new int[0];
//         }

//         int[] res = new int[numCourses];
//         for (int v = 0; v < numCourses; ++v) {
//             res[v] = topological.poll();
//         }
//         return res;
//     }

//     private void bfs(Queue<Integer> queue) {
//         while (!queue.isEmpty()) {
//             int v = queue.poll();
//             topological.offer(v);
//             ++count;

//             for (int w : graph.get(v)) {
//                 --indegrees[w];
//                 if (indegrees[w] == 0) {
//                     queue.offer(w);
//                 }
//             }
//         }
//     }
// }
// @lc code=end
