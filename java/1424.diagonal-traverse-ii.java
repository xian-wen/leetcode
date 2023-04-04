import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * @lc app=leetcode id=1424 lang=java
 *
 * [1424] Diagonal Traverse II
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Map
    //  */
    // public int[] findDiagonalOrder(List<List<Integer>> nums) {
    //     // diagSum -> list of nums in the diag
    //     Map<Integer, List<Integer>> map = new HashMap<>();
    //     int M = nums.size(), count = 0;
    //     for (int row = M - 1; row >= 0; --row) {
    //         int N = nums.get(row).size();
    //         count += N;
    //         for (int col = 0; col < N; ++col) {
    //             int diagSum = row + col;
    //             map.putIfAbsent(diagSum, new ArrayList<>());
    //             map.get(diagSum).add(nums.get(row).get(col));
    //         }
    //     }
        
    //     int[] res = new int[count];
    //     int maxDiagSum = map.size() - 1, index = 0;
    //     for (int diagSum = 0; diagSum <= maxDiagSum; ++diagSum) {
    //         for (int num : map.get(diagSum)) {
    //             res[index++] = num;
    //         }
    //     }
    //     return res;
    // }

    /**
     * Solution 2: List
     */
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        // diagSum -> list of nums in the diag
        List<List<Integer>> lists = new ArrayList<>();
        int M = nums.size(), count = 0;
        for (int row = 0; row < M; ++row) {
            int N = nums.get(row).size();
            count += N;
            for (int col = 0; col < N; ++col) {
                int diagSum = row + col;
                if (diagSum == lists.size()) {
                    lists.add(new ArrayList<>());
                }

                lists.get(diagSum).add(nums.get(row).get(col));
            }
        }
        
        int[] res = new int[count];
        int index = 0;
        for (List<Integer> list : lists) {
            for (int i = list.size() - 1; i >= 0; --i) {
                res[index++] = list.get(i);
            }
        }
        return res;
    }

    // /**
    //  * Solution 3: BFS
    //  */
    // public int[] findDiagonalOrder(List<List<Integer>> nums) {
    //     List<Integer> res = new ArrayList<>();
    //     Queue<int[]> queue = new ArrayDeque<>();
    //     queue.offer(new int[] {0, 0});
    //     int M = nums.size();
    //     while (!queue.isEmpty()) {
    //         int[] indices = queue.poll();
    //         int row = indices[0], col = indices[1];
    //         res.add(nums.get(row).get(col));

    //         // Add below for num at col 0.
    //         if (col == 0 && row < M - 1) {
    //             queue.offer(new int[] {row + 1, col});
    //         }

    //         // Add right.
    //         if (col < nums.get(row).size() - 1) {
    //             queue.offer(new int[] {row, col + 1});
    //         }
    //     }
    //     return res.stream().mapToInt(Integer::intValue).toArray();
    // }
}
// @lc code=end

