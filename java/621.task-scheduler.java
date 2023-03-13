/*
 * @lc app=leetcode id=621 lang=java
 *
 * [621] Task Scheduler
 *
 * https://leetcode.com/problems/task-scheduler/description/
 *
 * algorithms
 * Medium (56.17%)
 * Likes:    8062
 * Dislikes: 1609
 * Total Accepted:    418.2K
 * Total Submissions: 743.2K
 * Testcase Example:  '["A","A","A","B","B","B"]\n2'
 *
 * Given a characters array tasks, representing the tasks a CPU needs to do,
 * where each letter represents a different task. Tasks could be done in any
 * order. Each task is done in one unit of time. For each unit of time, the CPU
 * could complete either one task or just be idle.
 * 
 * However, there is a non-negative integer n that represents the cooldown
 * period between two same tasks (the same letter in the array), that is that
 * there must be at least n units of time between any two same tasks.
 * 
 * Return the least number of units of times that the CPU will take to finish
 * all the given tasks.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: 
 * A -> B -> idle -> A -> B -> idle -> A -> B
 * There is at least 2 units of time between any two same tasks.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: tasks = ["A","A","A","B","B","B"], n = 0
 * Output: 6
 * Explanation: On this case any permutation of size 6 would work since n = 0.
 * ["A","A","A","B","B","B"]
 * ["A","B","A","B","A","B"]
 * ["B","B","B","A","A","A"]
 * ...
 * And so on.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
 * Output: 16
 * Explanation: 
 * One possible solution is
 * A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle
 * -> idle -> A
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= task.length <= 10^4
 * tasks[i] is upper-case English letter.
 * The integer n is in the range [0, 100].
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * Case 1:
     * tasks: [A A A B B B], n = 2
     * max: 3, which is A (or B)
     * maxCount: 2
     * time: A _ _ A _ _ A B
     *      |1  n |
     *      |   max-1   |maxCount|
     * tasks.length = 6
     * res = Math.max(6, (1+n) * (max-1) + maxCount) = 8
     * one schedule: A B [_] A B [_] A B
     * 
     * Case 2:
     * tasks: [A A A B B C C D D], n = 2
     * max: 3, which is A
     * maxCount: 1
     * time: A _ _ A _ _ A
     *      |1  n |
     *      |   max-1   |maxCount|
     * tasks.length = 9
     * res = Math.max(9, (1+n) * (max-1) + maxCount) = 9
     * one schedule: A B C A B D A C D
     */
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        int max = 0, maxCount = 0;
        for (char task : tasks) {
            ++count[task - 'A'];
            if (count[task - 'A'] == max) {
                ++maxCount;
            } else if (count[task - 'A'] > max) {
                max = count[task - 'A'];
                maxCount = 1;
            }
        }

        int time = (max - 1) * (n + 1) + maxCount;
        return Math.max(tasks.length, time);
    }
}
// @lc code=end

