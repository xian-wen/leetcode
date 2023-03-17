import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=406 lang=java
 *
 * [406] Queue Reconstruction by Height
 *
 * https://leetcode.com/problems/queue-reconstruction-by-height/description/
 *
 * algorithms
 * Medium (72.89%)
 * Likes:    6638
 * Dislikes: 664
 * Total Accepted:    280K
 * Total Submissions: 384K
 * Testcase Example:  '[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]'
 *
 * You are given an array of people, people, which are the attributes of some
 * people in a queue (not necessarily in order). Each people[i] = [hi, ki]
 * represents the i^th person of height hi with exactly ki other people in
 * front who have a height greater than or equal to hi.
 * 
 * Reconstruct and return the queue that is represented by the input array
 * people. The returned queue should be formatted as an array queue, where
 * queue[j] = [hj, kj] is the attributes of the j^th person in the queue
 * (queue[0] is the person at the front of the queue).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
 * Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
 * Explanation:
 * Person 0 has height 5 with no other people taller or the same height in
 * front.
 * Person 1 has height 7 with no other people taller or the same height in
 * front.
 * Person 2 has height 5 with two persons taller or the same height in front,
 * which is person 0 and 1.
 * Person 3 has height 6 with one person taller or the same height in front,
 * which is person 1.
 * Person 4 has height 4 with four people taller or the same height in front,
 * which are people 0, 1, 2, and 3.
 * Person 5 has height 7 with one person taller or the same height in front,
 * which is person 1.
 * Hence [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] is the reconstructed queue.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
 * Output: [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= people.length <= 2000
 * 0 <= hi <= 10^6
 * 0 <= ki < people.length
 * It is guaranteed that the queue can be reconstructed.
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1
    //  */
    // public int[][] reconstructQueue(int[][] people) {
    //     Arrays.sort(people, (p1, p2) -> 
    //             p1[1] == p2[1] ? p1[0] - p2[0] : p1[1] - p2[1]);
        
    //     int N = people.length;
    //     List<int[]> res = new LinkedList<>();
    //     for (int i = 0; i < N; ++i) {
    //         if (people[i][1] == people[0][1]) {
    //             res.add(people[i]);
    //             continue;
    //         }

    //         int greaterOrEqual = 0, j;
    //         for (j = 0; j < res.size(); ++j) {
    //             if (res.get(j)[0] >= people[i][0]) {
    //                 ++greaterOrEqual;
    //             }

    //             if (greaterOrEqual > people[i][1]) {
    //                 break;
    //             }
    //         }

    //         res.add(j, people[i]);
    //     }
    //     return res.toArray(new int[0][]);
    // }

    /**
     * Solution 2
     * 
     * people: [[7, 0], [4, 4], [7, 1], [5, 0], [6, 1], [5, 2]]
     * sort by (-height, k): [[7, 0], [7, 1], [6, 1], [5, 0], [5, 2], [4, 4]]
     * insert by k:
     * [[7, 0], [7, 1]]
     * [[7, 0], [6, 1], [7, 1]]
     * [[5, 0], [7, 0], [5, 2], [6, 1], [7, 1]]
     * [[5, 0], [7, 0], [5, 2], [6, 1], [4, 4], [7, 1]]
     */
    public int[][] reconstructQueue(int[][] people) {
        // Sort by (-height, k).
        Arrays.sort(people, (p1, p2) -> 
                p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]);

        List<int[]> res = new LinkedList<>();
        // Use k as the index to insert into res.
        // Taller heights will not be affected by shorter heights.
        for (int[] p : people) {
            res.add(p[1], p);
        }
        return res.toArray(new int[0][]);
    }    

    private String arrListToString(List<int[]> list) {
        StringBuilder sb = new StringBuilder("[");
        for (int[] arr : list) {
            sb.append(Arrays.toString(arr)).append(", ");
        }

        int len = sb.length();
        if (len > 1) {
            sb.delete(len - 2, len);
        }
        return sb.append("]").toString();
    }
}
// @lc code=end

