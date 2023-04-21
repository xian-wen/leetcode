import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=1871 lang=java
 *
 * [1871] Jump Game VII
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Dynamic Programming (TLE)
    //  * 
    //  * Subproblem:
    //  * reachable[i] = whether it is reachable from index 0 to i.
    //  * 
    //  * Recurrence relation:
    //  * reachable[i] = OR {reachable[j]} where i-maxJump <= j <= i-minJump if s[i] = '0'
    //  *              = false                                               otherwise
    //  * reachable[0] = true
    //  * 
    //  * Time complexity:
    //  * O((maxJump-minJump)N)
    //  */
    // public boolean canReach(String s, int minJump, int maxJump) {
    //     int N = s.length();
    //     if (s.charAt(N - 1) == '1') {
    //         return false;
    //     }

    //     boolean[] reachable = new boolean[N];
    //     reachable[0] = true;
    //     for (int i = 1; i < N; ++i) {
    //         if (s.charAt(i) == '1') {
    //             continue;
    //         }

    //         for (int j = i - maxJump; j <= i - minJump; ++j) {
    //             if (j >= 0 && j <= N) {
    //                 reachable[i] = reachable[i] || reachable[j];
    //             }
    //         }
    //     }
    //     return reachable[N - 1];
    // }

    /**
     * Solution 2: Dynamic Programming + Sliding Window
     */
    public boolean canReach(String s, int minJump, int maxJump) {
        int N = s.length();
        if (s.charAt(N - 1) == '1') {
            return false;
        }

        boolean[] reachable = new boolean[N];
        reachable[0] = true;
        // # valid positions in previous could be jumped from.
        int valid = 0;
        for (int i = 1; i < N; ++i) {
            // Add the valid into the right of window.
            if (i >= minJump && reachable[i - minJump]) {
                ++valid;
            }
            
            // Remove the leftmost valid out of window.
            if (i > maxJump && reachable[i - maxJump - 1]) {
                --valid;
            }
            
            reachable[i] = valid > 0 && s.charAt(i) == '0';
        }
        return reachable[N - 1];
    }

    // /**
    //  * Solution 3: Sliding window
    //  * 
    //  * Valid indices reachable to index: s[index-maxJump..index-minJump]
    //  */
    // public boolean canReach(String s, int minJump, int maxJump) {
    //     int N = s.length();
    //     if (s.charAt(N - 1) == '1') {
    //         return false;
    //     }

    //     Deque<Integer> win = new ArrayDeque<>();
    //     win.offer(0);
    //     for (int i = 1; i < N; ++i) {
    //         while (!win.isEmpty() && win.peekFirst() < i - maxJump) {
    //             win.pollFirst();
    //         }
            
    //         // If the leftmost in win > i - minJump, then i is not reachable.
    //         // i.e., as long as there exists index reachable to i, add i into win.
    //         // therefore, use win.peekFirst(), not win.peekLast() !!!
    //         if (s.charAt(i) == '0' && !win.isEmpty() 
    //                 && win.peekFirst() <= i - minJump) {
    //             win.offerLast(i);
    //         }
    //     }
    //     return !win.isEmpty() && win.peekLast() == N - 1;
    // }

    // /**
    //  * Solution 4: BFS
    //  */
    // public boolean canReach(String s, int minJump, int maxJump) {
    //     int N = s.length();
    //     if (s.charAt(N - 1) == '1') {
    //         return false;
    //     }

    //     Deque<Integer> queue = new ArrayDeque<>();
    //     queue.offer(0);
    //     int preMax = 0;
    //     while (!queue.isEmpty()) {
    //         int index = queue.poll();
    //         if (index == N - 1) {
    //             return true;
    //         }

    //         // Use preMax to avoid adding duplicate index into queue.
    //         int start = Math.max(index + minJump, preMax + 1);
    //         int end = Math.min(index + maxJump, N - 1);
    //         for (int i = start; i <= end; ++i) {
    //             if (s.charAt(i) == '0') {
    //                 queue.offer(i);
    //             }
    //         }

    //         preMax = end;
    //     }
    //     return false;
    // }
}
// @lc code=end

