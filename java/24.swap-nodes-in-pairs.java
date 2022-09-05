/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 *
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (59.90%)
 * Likes:    7985
 * Dislikes: 329
 * Total Accepted:    953.4K
 * Total Submissions: 1.6M
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given a linked list, swap every two adjacent nodes and return its head. You
 * must solve the problem without modifying the values in the list's nodes
 * (i.e., only nodes themselves may be changed.)
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = []
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: head = [1]
 * Output: [1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is in the range [0, 100].
 * 0 <= Node.val <= 100
 * 
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
// Iterative:
// class Solution {
//     public ListNode swapPairs(ListNode head) {
//         ListNode dummy = new ListNode(-1), p = dummy;
//         while (head != null && head.next != null) {
//             ListNode nextnext = head.next.next;
//             p.next = head.next;
//             head.next.next = head;
//             p = head;
//             head = nextnext;
//         }
//         p.next = head;
//         return dummy.next;
//     }
// }

// Recursive:
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode swapped = swapPairs(head.next.next);
        ListNode res = head.next;
        res.next = head;
        head.next = swapped;
        return res;
    }
}
// @lc code=end

