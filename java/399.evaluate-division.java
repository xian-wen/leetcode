import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=399 lang=java
 *
 * [399] Evaluate Division
 *
 * https://leetcode.com/problems/evaluate-division/description/
 *
 * algorithms
 * Medium (59.62%)
 * Likes:    6909
 * Dislikes: 612
 * Total Accepted:    329K
 * Total Submissions: 551.7K
 * Testcase Example:  '[["a","b"],["b","c"]]\n' +
  '[2.0,3.0]\n' +
  '[["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]'
 *
 * You are given an array of variable pairs equations and an array of real
 * numbers values, where equations[i] = [Ai, Bi] and values[i] represent the
 * equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a
 * single variable.
 * 
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the
 * j^th query where you must find the answer for Cj / Dj = ?.
 * 
 * Return the answers to all queries. If a single answer cannot be determined,
 * return -1.0.
 * 
 * Note: The input is always valid. You may assume that evaluating the queries
 * will not result in division by zero and that there is no contradiction.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries =
 * [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * Explanation: 
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values =
 * [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * Output: [3.75000,0.40000,5.00000,0.20000]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: equations = [["a","b"]], values = [0.5], queries =
 * [["a","b"],["b","a"],["a","c"],["x","y"]]
 * Output: [0.50000,2.00000,-1.00000,-1.00000]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj consist of lower case English letters and digits.
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * Directed weighted graph without self-loops.
     */
    private class Graph {
        Map<String, List<Edge>> adj = new HashMap<>();

        private class Edge {
            private final String from, to;
            private final double weight;

            public Edge(String from, String to, double weight) {
                this.from = from;
                this.to = to;
                this.weight = weight;
            }

            @Override
            public String toString() {
                return from + "->" + to + ":" + weight;
            }
        }

        public Graph(List<List<String>> equations, double[] values) {
            int N = equations.size();
            for (int i = 0; i < N; ++i) {
                String v = equations.get(i).get(0);
                String w = equations.get(i).get(1);
                addEdge(v, w, values[i]);
                addEdge(w, v, 1.0 / values[i]);
            }
        }

        public void addEdge(String from, String to, double weight) {
            if (!adj.containsKey(from)) {
                adj.put(from, new LinkedList<>());
            }

            Edge edge = new Edge(from, to, weight);
            adj.get(from).add(edge);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (String v : adj.keySet()) {
                sb.append(String.format("%s: %s\n", v, adj.get(v)));
            }
            return sb.toString();
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, 
                                 List<List<String>> queries) {
        Graph graph = new Graph(equations, values);
        int N = queries.size();
        double[] res = new double[N];
        for (int i = 0; i < N; ++i) {
            String from = queries.get(i).get(0);
            String to = queries.get(i).get(1);
            if (!graph.adj.containsKey(from) || !graph.adj.containsKey(to)) {
                res[i] = -1.0;
            } else {
                res[i] = dfs(graph, new HashSet<>(), from, to, 1.0);
            }
        }
        return res;
    }

    private double dfs(Graph graph, Set<String> visited, 
                       String from, String to, double cur) {
        if (from.equals(to)) {
            return cur;
        }

        visited.add(from);
        for (Graph.Edge e : graph.adj.get(from)) {
            if (!visited.contains(e.to)) {
                double res = dfs(graph, visited, e.to, to, e.weight * cur);
                if (res != -1.0) {
                    return res;
                }
            }
        }
        return -1.0;
    }
}
// @lc code=end

