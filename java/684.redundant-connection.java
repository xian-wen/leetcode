/*
 * @lc app=leetcode id=684 lang=java
 *
 * [684] Redundant Connection
 *
 * https://leetcode.com/problems/redundant-connection/description/
 *
 * algorithms
 * Medium (61.82%)
 * Likes:    4410
 * Dislikes: 316
 * Total Accepted:    232.2K
 * Total Submissions: 375.5K
 * Testcase Example:  '[[1,2],[1,3],[2,3]]'
 *
 * In this problem, a tree is an undirected graph that is connected and has no
 * cycles.
 * 
 * You are given a graph that started as a tree with n nodes labeled from 1 to
 * n, with one additional edge added. The added edge has two different vertices
 * chosen from 1 to n, and was not an edge that already existed. The graph is
 * represented as an array edges of length n where edges[i] = [ai, bi]
 * indicates that there is an edge between nodes ai and bi in the graph.
 * 
 * Return an edge that can be removed so that the resulting graph is a tree of
 * n nodes. If there are multiple answers, return the answer that occurs last
 * in the input.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: edges = [[1,2],[1,3],[2,3]]
 * Output: [2,3]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
 * Output: [1,4]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == edges.length
 * 3 <= n <= 1000
 * edges[i].length == 2
 * 1 <= ai < bi <= edges.length
 * ai != bi
 * There are no repeated edges.
 * The given graph is connected.
 * 
 * 
 */

// @lc code=start
class Solution {
    private class UF {
        int[] parent;
        int[] size;

        UF(int N) {
            parent = new int[N];
            size = new int[N];
            for (int i = 0; i < N; ++i) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int p) {
            if (p != parent[p]) {
                parent[p] = find(parent[p]);
            }
            return parent[p];
        }

        boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);

            if (pRoot == qRoot) {
                return;
            }

            if (size[pRoot] > size[qRoot]) {
                parent[qRoot] = pRoot;
                size[pRoot] += size[qRoot];
            } else {
                parent[pRoot] = qRoot;
                size[qRoot] += size[pRoot];
            }
        }

    }

    private class UFByHeight {
        int[] parent;
        int[] height;  // The height of a single node is 0.

        UFByHeight(int N) {
            parent = new int[N];
            height = new int[N];
            for (int i = 0; i < N; ++i) {
                parent[i] = i;
            }
        }

        int find(int p) {
            if (p != parent[p]) {
                parent[p] = find(parent[p]);
            }
            return parent[p];
        }

        boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);

            if (pRoot == qRoot) {
                return;
            }

            if (height[pRoot] > height[qRoot]) {
                parent[qRoot] = pRoot;
            } else if (height[pRoot] < height[qRoot]) {
                parent[pRoot] = qRoot;
            } else {
                parent[pRoot] = qRoot;
                ++height[qRoot];
            }
        }

    }

    public int[] findRedundantConnection(int[][] edges) {
        UF uf = new UF(edges.length + 1);
        for (int[] e : edges) {
            if (uf.connected(e[0], e[1])) {
                return e;
            }
            uf.union(e[0], e[1]);
        }
        return new int[0];
    }
}
// @lc code=end

