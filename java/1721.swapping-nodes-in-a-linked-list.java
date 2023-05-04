/*
 * @lc app=leetcode id=1721 lang=java
 *
 * [1721] Swapping Nodes in a Linked List
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
    //  * Solution 1: Swap Values
    //  */
    // public ListNode swapNodes(ListNode head, int k) {
    //     ListNode dummy = new ListNode(-1, head);
    //     ListNode first = dummy;
    //     while (k > 0) {
    //         first = first.next;
    //         --k;
    //     }

    //     ListNode second = dummy, front = first;
    //     while (front != null) {
    //         front = front.next;
    //         second = second.next;
    //     }

    //     int temp = first.val;
    //     first.val = second.val;
    //     second.val = temp;
    //     return head;
    // }

    /**
     * Solution 2: Swap Nodes
     */
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode first = dummy, firstPrev = null;
        while (k > 0) {
            firstPrev = first;
            first = first.next;
            --k;
        }

        ListNode second = dummy, secondPrev = null, front = first;
        while (front != null) {
            secondPrev = second;
            front = front.next;
            second = second.next;
        }

        swapNodes(first, firstPrev, second, secondPrev);
        return dummy.next;
    }

    private void swapNodes(ListNode node1, ListNode prev1, 
                           ListNode node2, ListNode prev2) {
        if (node1 == node2) {
            return;
        }

        // Step 1: swap(node1, node2)
        prev1.next = node2;
        prev2.next = node1;
        
        // Step 2: swap(node1.next, node2.next)
        // 
        // The next1, next2 cannot be moved before prev1.next, prev2.next!!!
        // Otherwise, next1 is not correct, and causes a circle!!!
        // e.g., 
        // 1 -> 2 -> 3 -> 4, k = 2
        // prev1 = 1, prev2 = 2
        // node1 = 2, node2 = 3
        // ___________
        // |         ↓
        // 1    2--  3 -> 4
        //      ↑_|
        // prev1.next = node2 = 3
        // prev2.next = node1 = 2
        //
        // If next1, next2 after prev1.next, prev2.next:
        // next1 = node1.next = node1 = 2
        // next2 = node2.next = 4
        // ___________
        // |         ↓
        // 1    2 <- 3    4
        //      |_________↑
        // node1.next = next2 = 4
        // node2.next = next1 = 2
        //
        // If next1, next2 before prev1.next, prev2.next:
        // next1 = node1.next = 3
        // next2 = node2.next = 4
        // ___________
        // |         ↓
        // 1    2    3-- 4
        //      |    ↑_| ↑
        //      |________|
        // node1.next = next2 = 4
        // node2.next = next1 = 3
        ListNode next1 = node1.next;
        ListNode next2 = node2.next;
        node1.next = next2;
        node2.next = next1;
    }

    private String listToString(ListNode head) {
        if (head.next == null) {
            return String.valueOf(head.val);
        }
        return String.format("%d->%s", head.val, listToString(head.next));
    }
}
// @lc code=end

