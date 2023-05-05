/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
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
    // /**
    //  * Solution 1: Iteration
    //  */
    // public ListNode deleteDuplicates(ListNode head) {
    //     ListNode dummy = new ListNode(-1, head), prev = dummy;
    //     while (head != null) {
    //         while (head.next != null && head.val == head.next.val) {
    //             head = head.next;
    //         }

    //         if (prev.next == head) {
    //             prev = prev.next;
    //         } else {
    //             prev.next = head.next;
    //         }

    //         head = head.next;
    //     }
    //     return dummy.next;
    // }

    /**
     * Solution 2: Recursion
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        if (head.val != head.next.val) {
            head.next = deleteDuplicates(head.next);
            return head;
        }
        
        while (head.next != null && head.val == head.next.val) {
            head = head.next;
        }
        return deleteDuplicates(head.next);
    }
}
// @lc code=end

