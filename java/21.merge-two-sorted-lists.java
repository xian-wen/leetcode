/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (46.09%)
 * Total Accepted:    534.3K
 * Total Submissions: 1.2M
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * 
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // /**
    //  * Solution 1: Iteration
    //  */
    // public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    //     ListNode head = new ListNode(-1), p = head;
    //     while (l1 != null && l2 != null) {
    //         if (l1.val <= l2.val) {
    //             p.next = l1;
    //             l1 = l1.next;
    //         } else {
    //             p.next = l2;
    //             l2 = l2.next;
    //         }
    //         p = p.next;
    //     }

    //     p.next = l1 == null ? l2 : l1;
    //     return head.next;
    // }

    /**
     * Solution 2: Recursion 
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }

        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }
}
