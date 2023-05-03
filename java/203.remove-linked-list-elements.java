/*
 * @lc app=leetcode id=203 lang=java
 *
 * [203] Remove Linked List Elements
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
    //  */
    // public ListNode removeElements(ListNode head, int val) {
    //     ListNode dummy = new ListNode(-1, head);
    //     removeElements(head, dummy, val);
    //     return dummy.next;
    // }

    // private void removeElements(ListNode node, ListNode prev, int val) {
    //     if (node == null) {
    //         return;
    //     }

    //     if (node.val == val) {
    //         prev.next = prev.next.next;
    //         node = prev;
    //     }
        
    //     removeElements(node.next, node, val);
    // }

    /**
     * Solution 2
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    private String listToString(ListNode node) {
        if (node.next == null) {
            return String.valueOf(node.val);
        }
        return String.format("%d->%s", node.val, listToString(node.next));
    }
}
// @lc code=end

