import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=986 lang=java
 *
 * [986] Interval List Intersections
 */

// @lc code=start

class Solution {
    // /**
    //  * Solution 1: Iteration
    //  */
    // public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    //     List<int[]> res = new ArrayList<>();
    //     int N1 = firstList.length, N2 = secondList.length, i = 0, j = 0;
    //     while (i < N1 && j < N2) {
    //         int start = Math.max(firstList[i][0], secondList[j][0]);
    //         int end = Math.min(firstList[i][1], secondList[j][1]);
    //         if (start <= end) {
    //             res.add(new int[] {start, end});
    //             if (end == firstList[i][1]) {
    //                 ++i;
    //             } else {
    //                 ++j;
    //             }
    //         } else {
    //             if (start == firstList[i][0]) {
    //                 ++j;
    //             } else {
    //                 ++i;
    //             }
    //         }
    //     }
    //     // return res.toArray(int[][]::new);
    //     return res.toArray(new int[0][]);
    // }

    /**
     * Solution 2: Recursion
     */
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        intervalIntersection(firstList, secondList, 0, 0, res);
        // return res.toArray(int[][]::new);
        return res.toArray(new int[0][]);
    }

    private void intervalIntersection(int[][] list1, int[][] list2, 
                                      int i1, int i2, List<int[]> res) {
        if (i1 == list1.length || i2 == list2.length) {
            return;
        }

        int start = Math.max(list1[i1][0], list2[i2][0]);
        int end = Math.min(list1[i1][1], list2[i2][1]);
        if (start <= end) {
            res.add(new int[] {start, end});
            if (end == list1[i1][1]) {
                intervalIntersection(list1, list2, i1 + 1, i2, res);
            } else {
                intervalIntersection(list1, list2, i1, i2 + 1, res);
            }
        } else {
            if (start == list1[i1][0]) {
                intervalIntersection(list1, list2, i1, i2 + 1, res);
            } else {
                intervalIntersection(list1, list2, i1 + 1, i2, res);
            }
        }
    }
}
// @lc code=end

