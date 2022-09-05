/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
 *
 * https://leetcode.com/problems/reverse-linked-list/description/
 *
 * algorithms
 * Easy (71.84%)
 * Likes:    14313
 * Dislikes: 246
 * Total Accepted:    2.5M
 * Total Submissions: 3.5M
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * Given the head of a singly linked list, reverse the list, and return the
 * reversed list.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [1,2]
 * Output: [2,1]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: head = []
 * Output: []
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 * 
 * 
 * 
 * Follow up: A linked list can be reversed either iteratively or recursively.
 * Could you implement both?
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
//     public ListNode reverseList(ListNode head) {
//         ListNode reversed = null;
//         while (head != null) {
//             ListNode next = head.next;
//             head.next = reversed;
//             reversed = head;
//             head = next;
//         }
//         return reversed;
//     }
// }

// Recursive 1:
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         return reverseList(head, null);
//     }

//     private ListNode reverseList(ListNode cur, ListNode reversed) {
//         if (cur == null) {
//             return reversed;
//         }

//         ListNode next = cur.next;
//         cur.next = reversed;
//         return reverseList(next, cur);
//     }
// }

// Recursive 2:
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // head
        // |
        // v
        // 1 -> 2 -> 3 -> 4 -> 5 -> null
        //
        // head null           reversedNext
        // |    ^              |
        // v    |              v
        // 1 -> 2 <- 3 <- 4 <- 5
        //
        //         head                reversedNext
        //         |                   |
        //         v                   v
        // null <- 1 <- 2 <- 3 <- 4 <- 5
        ListNode reversedNext = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reversedNext;
    }
}
// @lc code=end

