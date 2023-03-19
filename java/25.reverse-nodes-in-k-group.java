/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
 *
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 *
 * algorithms
 * Hard (54.28%)
 * Likes:    10645
 * Dislikes: 565
 * Total Accepted:    670.1K
 * Total Submissions: 1.2M
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given the head of a linked list, reverse the nodes of the list k at a time,
 * and return the modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the
 * linked list. If the number of nodes is not a multiple of k then left-out
 * nodes, in the end, should remain as it is.
 * 
 * You may not alter the values in the list's nodes, only nodes themselves may
 * be changed.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 * 
 * 
 * 
 * Follow-up: Can you solve the problem in O(1) extra memory space?
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        return reverseKGroup(dummy, head, k);
    }

    /**
     * Example:
     * -1 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> null, k = 3
     *  ↑    ↑              ↑
     * prev curr          front
     * 
     * reverseBetween(curr, front):
     * -1 -> 1 <- 2 <- 3    4 -> 5 -> 6 -> 7 -> 8 -> null
     *  ↑    |______________↑
     * prev curr          front
     * 
     * prev.next = reverseBetween(curr, front):
     * -1 -> 3 -> 2 -> 1 -> 4 -> 5 -> 6 -> 7 -> 8 -> null
     *  ↑              ↑    ↑
     * prev          curr front
     * 
     * reverseKGroup(curr, front, k):
     * -1 -> 3 -> 2 -> 1 -> 4 <- 5 <- 6    7 -> 8 -> null
     *  ↑              ↑    |______________↑
     * prev          curr front
     * 
     * curr.next = reverseKGroup(curr, front, k):
     * -1 -> 3 -> 2 -> 1 -> 6 -> 5 -> 4 -> 7 -> 8 -> null
     *  ↑              ↑              ↑
     * prev          curr           front
     */
    private ListNode reverseKGroup(ListNode prev, ListNode curr, int k) {
        if (curr == null) {
            return null;
        }

        // Get the range [curr, front) to be reversed.
        ListNode front = curr;
        int steps = 0;
        while (steps < k && front != null) {
            front = front.next;
            ++steps;
        }

        // Length of range < k.
        if (steps < k && front == null) {
            return prev.next;
        }

        prev.next = reverseBetween(curr, front);
        curr.next = reverseKGroup(curr, front, k);
        return prev.next;
    }

    /**
     * Reverse linked list in range [start, end), not including end.
     * 
     * Example:
     *   1 -> 2 -> 3 -> 4 -> 5 -> null
     *   ↑                   ↑
     * start                end
     * 
     * reverseBetween(start.next, end):
     *   1 -> 2 <- 3 <- 4    5 -> null
     *   ↑    |______________↑
     * start                end
     * 
     * start.next.next = start:
     *   1 <- 2 <- 3 <- 4    5 -> null
     *   ↑                   ↑
     * start                end
     * 
     * start.next = end:
     *   1 <- 2 <- 3 <- 4    5 -> null
     *   |___________________↑
     * start                end
     * 
     * beautify:
     *   4 -> 3 -> 2 -> 1 -> 5 -> null
     *                  ↑    ↑
     *                start end
     */
    private ListNode reverseBetween(ListNode start, ListNode end) {
        if (start == null || start.next == end) {
            return start;
        }

        ListNode reversed = reverseBetween(start.next, end);
        start.next.next = start;
        start.next = end;
        return reversed;
    }

    private String listToString(ListNode head) {
        if (head == null) {
            return "null";
        }
        return String.format("%d -> %s", head.val, listToString(head.next));
    }
}
// @lc code=end

