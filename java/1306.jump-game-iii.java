import java.util.ArrayDeque;
import java.util.Queue;

/*
 * @lc app=leetcode id=1306 lang=java
 *
 * [1306] Jump Game III
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: BFS
    //  */
    // public boolean canReach(int[] arr, int start) {
    //     int N = arr.length;
    //     boolean[] visited = new boolean[arr.length];
    //     Queue<Integer> queue = new ArrayDeque<>();
    //     queue.offer(start);
    //     visited[start] = true;
    //     while (!queue.isEmpty()) {
    //         int index = queue.poll();
    //         if (arr[index] == 0) {
    //             return true;
    //         }

    //         int[] next = new int[] {index + arr[index], index - arr[index]};
    //         for (int i : next) {
    //             if (i >= 0 && i < N && !visited[i]) {
    //                 visited[i] = true;
    //                 queue.offer(i);
    //             }
    //         }
    //     }
    //     return false;
    // }

    // /**
    //  * Solution 2: DFS
    //  */
    // public boolean canReach(int[] arr, int start) {
    //     int N = arr.length;
    //     boolean[] visited = new boolean[N];
    //     return dfs(arr, visited, start);
    // }

    // private boolean dfs(int[] arr, boolean[] visited, int index) {
    //     if (index < 0 || index >= arr.length || visited[index]) {
    //         return false;
    //     }

    //     if (arr[index] == 0) {
    //         return true;
    //     }

    //     visited[index] = true;
    //     return dfs(arr, visited, index + arr[index])
    //             || dfs(arr, visited, index - arr[index]);
    // }

    /**
     * Solution 3: DFS (Space Optimization)
     * 
     * Use flipping sign as visiting a num.
     */
    public boolean canReach(int[] arr, int start) {
        if (start < 0 || start >= arr.length || arr[start] < 0) {
            return false;
        }

        if (arr[start] == 0) {
            return true;
        }

        arr[start] = -arr[start];
        return canReach(arr, start + arr[start]) 
                || canReach(arr, start - arr[start]);
    }
}
// @lc code=end

