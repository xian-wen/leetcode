import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=1340 lang=java
 *
 * [1340] Jump Game V
 */

// @lc code=start
class Solution {
    // private class Graph {
    //     private List<Integer>[] adj;
    //     private int V, E;

    //     public Graph(int[] arr, int d) {
    //         V = arr.length;
    //         adj = new List[V];
    //         for (int v = 0; v < V; ++v) {
    //             adj[v] = new LinkedList<>();
    //         }

    //         addEdges(arr, d);
    //     }

    //     /**
    //      * Use Monotonic Stack to avoid duplicate.
    //      * 
    //      * e.g., 
    //      * arr = [6,4,14,6,8,13,9,7,10,6,12], d = 2
    //      * graph:
    //      * 0: [1]
    //      * 1: []
    //      * 2: [1, 0, 3, 4]
    //      * 3: []
    //      * 4: [3]
    //      * 5: [4, 6]
    //      * 6: [7]
    //      * 7: []
    //      * 8: [7, 6, 9]
    //      * 9: []
    //      * 10: [9, 8]
    //      * 
    //      * adj[4] = [3]
    //      * adj[5] = [4, 6], instead of [4, 3, 6, 7]
    //      * adj[6] = [7]
    //      */
    //     private void addEdges(int[] arr, int d) {
    //         Deque<Integer> stack = new ArrayDeque<>();
    //         int N = arr.length;
    //         for (int i = 0; i < N; ++i) {
    //             while (!stack.isEmpty() && i - stack.peek() <= d 
    //                     && arr[i] > arr[stack.peek()]) {
    //                 addEdge(i, stack.pop());
    //             }
                
    //             stack.push(i);
    //         }
            
    //         stack.clear();
            
    //         for (int i = N - 1; i >= 0; --i) {
    //             while (!stack.isEmpty() && stack.peek() - i <= d 
    //                     && arr[i] > arr[stack.peek()]) {
    //                 addEdge(i, stack.pop());
    //             }

    //             stack.push(i);
    //         }
    //     }

    //     public void addEdge(int v, int w) {
    //         adj[v].add(w);
    //         ++E;
    //     }

    //     @Override
    //     public String toString() {
    //         StringBuilder sb = new StringBuilder();
    //         sb.append(String.format("%d vertices, %d edges\n", V, E));
    //         for (int v = 0; v < V; ++v) {
    //             sb.append(String.format("%d: %s\n", v, adj[v]));
    //         }
    //         return sb.toString();
    //     }
    // }

    // /**
    //  * Find the longest path in DAG.
    //  */
    // private int dfs(Graph graph, int[] memo, int v) {
    //     if (memo[v] > 0) {
    //         return memo[v];
    //     }

    //     int maxJumps = 1;
    //     for (int w : graph.adj[v]) {
    //         maxJumps = Math.max(maxJumps, 1 + dfs(graph, memo, w));
    //     }

    //     memo[v] = maxJumps;
    //     return maxJumps;
    // }

    // /**
    //  * Solution 1
    //  */
    // public int maxJumps(int[] arr, int d) {
    //     Graph graph = new Graph(arr, d);
    //     int N = arr.length, maxJumps = 1;
    //     int[] memo = new int[N];
    //     for (int i = 0; i < N; ++i) {
    //         if (memo[i] == 0) {
    //             maxJumps = Math.max(maxJumps, dfs(graph, memo, i));
    //         }
    //     }
    //     return maxJumps;
    // }

    /**
     * Solution 2
     */
    public int maxJumps(int[] arr, int d) {
        int N = arr.length, maxJumps = 1;
        int[] memo = new int[N];
        for (int i = 0; i < N; ++i) {
            maxJumps = Math.max(maxJumps, dfs(arr, memo, i, d));
        }
        return maxJumps;
    }

    private int dfs(int[] arr, int[] memo, int i, int d) {
        if (memo[i] > 0) {
            return memo[i];
        }

        int N = arr.length, maxJumps = 1;
        int j = i - 1;
        while (j >= 0 && j >= i - d && arr[i] > arr[j]) {
            maxJumps = Math.max(maxJumps, 1 + dfs(arr, memo, j--, d));
        }

        j = i + 1;
        while (j < N && j <= i + d && arr[i] > arr[j]) {
            maxJumps = Math.max(maxJumps, 1 + dfs(arr, memo, j++, d));
        }

        memo[i] = maxJumps;
        return memo[i];
    }
}
// @lc code=end

