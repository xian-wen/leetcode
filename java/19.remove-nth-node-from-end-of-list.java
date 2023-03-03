/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
 *
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * algorithms
 * Medium (40.67%)
 * Likes:    14930
 * Dislikes: 616
 * Total Accepted:    1.9M
 * Total Submissions: 4.7M
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given the head of a linked list, remove the n^th node from the end of the
 * list and return its head.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [1], n = 1
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: head = [1,2], n = 1
 * Output: [1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * 
 * 
 * 
 * Follow up: Could you do this in one pass?
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode front = head;
        while (n > 0) {
            front = front.next;
            --n;
        }

        if (front == null) {
            return head.next;
        }

        ListNode back = head;
        while (front.next != null) {
            front = front.next;
            back = back.next;
        }

        ListNode deleted = back.next;
        back.next = back.next.next;
        deleted.next = null;
        return head;
    }
}
// @lc code=end

