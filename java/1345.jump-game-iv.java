import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * @lc app=leetcode id=1345 lang=java
 *
 * [1345] Jump Game IV
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: BFS
    //  */
    // public int minJumps(int[] arr) {
    //     // num -> index
    //     Map<Integer, List<Integer>> indices = new HashMap<>();
    //     int N = arr.length;
    //     for (int i = 0; i < N; ++i) {
    //         indices.putIfAbsent(arr[i], new ArrayList<>());
    //         indices.get(arr[i]).add(i);
    //     }

    //     // BFS
    //     Queue<Integer> queue = new ArrayDeque<>();
    //     boolean[] visited = new boolean[N];
    //     queue.offer(0);
    //     visited[0] = true;
    //     int jumps = 0;
    //     while (!queue.isEmpty()) {
    //         int size = queue.size();
    //         for (int i = 0; i < size; ++i) {
    //             int index = queue.poll();
    //             if (index == N - 1) {
    //                 return jumps;
    //             }

    //             List<Integer> next = indices.get(arr[index]);
    //             next.add(index - 1);
    //             next.add(index + 1);
    //             for (int idx : next) {
    //                 if (idx >= 0 && idx < N && !visited[idx]) {
    //                     visited[idx] = true;
    //                     queue.offer(idx);
    //                 }
    //             }

    //             next.clear();
    //         }
            
    //         ++jumps;
    //     }
    //     return jumps;
    // }

    /**
     * Solution 2: BFS (Space Optimization)
     */
    public int minJumps(int[] arr) {
        // num -> index
        Map<Integer, List<Integer>> indices = new HashMap<>();
        int N = arr.length;
        for (int i = 0; i < N; ++i) {
            indices.putIfAbsent(arr[i], new ArrayList<>());
            indices.get(arr[i]).add(i);
        }

        // BFS
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        int jumps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int index = queue.poll();
                if (index == N - 1) {
                    return jumps;
                }

                if (index - 1 >= 0 && indices.containsKey(arr[index - 1])) {
                    queue.offer(index - 1);
                }

                if (index + 1 < N && indices.containsKey(arr[index + 1])) {
                    queue.offer(index + 1);
                }

                if (indices.containsKey(arr[index])) {
                    for (int idx : indices.get(arr[index])) {
                        if (idx != index) {
                            queue.offer(idx);
                        }
                    }
                }

                indices.remove(arr[index]);
            }
            
            ++jumps;
        }
        return jumps;
    }
}
// @lc code=end

