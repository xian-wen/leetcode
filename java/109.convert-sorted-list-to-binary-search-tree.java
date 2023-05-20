/*
 * @lc app=leetcode id=109 lang=java
 *
 * [109] Convert Sorted List to Binary Search Tree
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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // /**
    //  * Solution 1: Iteration
    //  * 
    //  * Construct the balanced BST from the middle node.
    //  */
    // public TreeNode sortedListToBST(ListNode head) {
    //     if (head == null) {
    //         return null;
    //     }

    //     if (head.next == null) {
    //         return new TreeNode(head.val);
    //     }

    //     // Get the middle node.
    //     ListNode fast = head, slow = head, prev = null;
    //     while (fast != null && fast.next != null) {
    //         prev = slow;
    //         fast = fast.next.next;
    //         slow = slow.next;
    //     }

    //     prev.next = null;
    //     TreeNode root = new TreeNode(slow.val);
    //     root.left = sortedListToBST(head);
    //     root.right = sortedListToBST(slow.next);
    //     return root;
    // }

    /**
     * Solution 2: Recursion
     * 
     * Construct the balanced BST from the middle node.
     */
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head, null);
    }

    private TreeNode sortedListToBST(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }

        // Get the middle node.
        ListNode fast = head, slow = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head, slow);
        root.right = sortedListToBST(slow.next, tail);
        return root;
    }

    private String listToString(ListNode head) {
        if (head == null) {
            return "null";
        }
        return String.format("%d->%s", head.val, listToString(head.next));
    }
}
// @lc code=end

