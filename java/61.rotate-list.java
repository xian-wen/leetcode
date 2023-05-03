/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
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
    //  * Solution 1
    //  * 
    //  * Similar to LeetCode 19.
    //  */
    // public ListNode rotateRight(ListNode head, int k) {
    //     if (head == null || head.next == null || k == 0) {
    //         return head;
    //     }

    //     int len = length(head);
    //     k = k % len;
    //     if (k == 0) {
    //         return head;
    //     }

    //     ListNode front = head;
    //     while (k > 0) {
    //         front = front.next;
    //         --k;
    //     }

    //     ListNode back = head;
    //     while (front.next != null) {
    //         front = front.next;
    //         back = back.next;
    //     }

    //     ListNode rotated = back.next;
    //     back.next = null;
    //     front.next = head;
    //     return rotated;
    // }

    // private int length(ListNode head) {
    //     if (head == null) {
    //         return 0;
    //     }
    //     return 1 + length(head.next);
    // }

    /**
     * Solution 2
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode curr = head;
        // Init len = 1, since loop ends when curr.next = null.        
        int len = 1;
        while (curr.next != null) {
            curr = curr.next;
            ++len;
        }

        // Form a circle.
        curr.next = head;
        k = len - k % len;
        while (k > 0) {
            // If using head = head.next, then use while (k > 1).
            curr = curr.next;
            --k;
        }

        ListNode rotated = curr.next;
        curr.next = null;
        return rotated;
    }

    private String listToString(ListNode head) {
        if (head.next == null) {
            return String.valueOf(head.val);
        }
        return String.format("%d->%s", head.val, listToString(head.next));
    }
}
// @lc code=end

