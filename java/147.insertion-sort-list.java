/*
 * @lc app=leetcode id=147 lang=java
 *
 * [147] Insertion Sort List
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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(), prev = dummy;
        while (head != null) {
            ListNode next = head.next;
            // If head.val >= prev.val, no need to set prev to dummy.
            if (head.val < prev.val) {
                prev = dummy;
            }

            // Use >= instead of > to make it stable, ignore if we do not care.
            while (prev.next != null && head.val >= prev.next.val) {
                prev = prev.next;
            }
            
            head.next = prev.next;
            prev.next = head;
            head = next;
        }
        return dummy.next;
    }
}
// @lc code=end

