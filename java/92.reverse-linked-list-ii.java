/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
 *
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (45.40%)
 * Likes:    8802
 * Dislikes: 394
 * Total Accepted:    619.2K
 * Total Submissions: 1.4M
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * Given the head of a singly linked list and two integers left and right where
 * left <= right, reverse the nodes of the list from position left to position
 * right, and return the reversed list.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is n.
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 * 
 * 
 * 
 * Follow up: Could you do it in one pass?
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);
        ListNode front = dummy, prevLeft = dummy, nextRight = head.next;
        int steps = 0;
        while (steps <= right) {
            front = front.next;
            ++steps;
            if (steps + 1 == left) {
                prevLeft = front;
            }
        }

        nextRight = front;
        prevLeft.next = reverseBetween(prevLeft.next, nextRight);
        return dummy.next;
    }

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

