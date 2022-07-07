/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Number of Provinces
 *
 * https://leetcode.com/problems/number-of-provinces/description/
 *
 * algorithms
 * Medium (62.40%)
 * Likes:    5481
 * Dislikes: 245
 * Total Accepted:    489K
 * Total Submissions: 779.4K
 * Testcase Example:  '[[1,1,0],[1,1,0],[0,0,1]]'
 *
 * There are n cities. Some of them are connected, while some are not. If city
 * a is connected directly with city b, and city b is connected directly with
 * city c, then city a is connected indirectly with city c.
 * 
 * A province is a group of directly or indirectly connected cities and no
 * other cities outside of the group.
 * 
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the
 * i^th city and the j^th city are directly connected, and isConnected[i][j] =
 * 0 otherwise.
 * 
 * Return the total number of provinces.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] is 1 or 0.
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] isConnected) {
        // Solution 1: Union Find
        // int N = isConnected.length;
        // UF uf = new UF(N);
        // for (int i = 0; i < N; ++i) {
        //     for (int j = 0; j < N; ++j) {
        //         if (!uf.connected(i, j) && isConnected[i][j] == 1) {
        //             uf.union(i, j);
        //         }
        //     }
        // }
        // return uf.count;

        // Solution2: DFS
        N = isConnected.length;
        this.isConnected = isConnected;

        // # connected component.
        int provices= 0;
        for (int v = 0; v < N; ++v) {
            // v not visited.
            if (isConnected[v][v] == 1) {
                ++provices;
                explore(v);
            }
        }
        return provices;
    }

    private class UF {
        int[] parent;
        int[] size;
        int count;

        UF(int N) {
            parent = new int[N];
            size = new int[N];
            for (int i = 0; i < N; ++i) {
                parent[i] = i;
                size[i] = 1;
            }
            count = N;
        }

        boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        int find(int p) {
            if (p != parent[p]) {
                parent[p] = find(parent[p]);
            }
            return parent[p];
        }

        void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (size[pRoot] > size[qRoot]) {
                parent[qRoot] = pRoot;
                size[pRoot] += qRoot; 
            } else {
                parent[pRoot] = qRoot;
                size[qRoot] += size[pRoot];
            }
            --count;
        }
    }

    private void explore(int u) {
        isConnected[u][u] = 0;

        for (int v = 0; v < N; ++v) {
            // Not self loop && (u, v) in E && v not visited.
            if (u != v && isConnected[u][v] == 1 && isConnected[v][v] == 1) {
                explore(v);
            }
        }
    }

    private int[][] isConnected;
    private int N;
}
// @lc code=end

