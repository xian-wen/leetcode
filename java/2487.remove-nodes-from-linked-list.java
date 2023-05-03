/*
 * @lc app=leetcode id=2487 lang=java
 *
 * [2487] Remove Nodes From Linked List
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
    //  * Solution 1: Reverse + Recursion
    //  */
    // public ListNode removeNodes(ListNode head) {
    //     head = reverse(head);
    //     removeLess(head);
    //     return reverse(head);
    // }

    // private ListNode reverse(ListNode head) {
    //     if (head == null || head.next == null) {
    //         return head;
    //     }

    //     ListNode reversed = reverse(head.next);
    //     head.next.next = head;
    //     head.next = null;
    //     return reversed;
    // }

    // private void removeLess(ListNode head) {
    //     if (head == null || head.next == null) {
    //         return;
    //     }

    //     if (head.next.val < head.val) {
    //         head.next = head.next.next;
    //     } else {
    //         head = head.next;
    //     }
        
    //     removeLess(head);
    // }

    /**
     * Solution 2: Recursion
     */
    public ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        head.next = removeNodes(head.next);
        return head.val < head.next.val ? head.next : head;
    }

    // /**
    //  * Solution 3: Monotonic Stack
    //  */
    // public ListNode removeNodes(ListNode head) {
    //     ListNode dummy = new ListNode(Integer.MAX_VALUE);
    //     Deque<ListNode> stack = new ArrayDeque<>();
    //     stack.push(dummy);
    //     while (head != null) {
    //         while (!stack.isEmpty() && head.val > stack.peek().val) {
    //             stack.pop();
    //         }

    //         // Modify stack.peek() will also modify all the lists 
    //         // in the stack simultaneously.
    //         stack.peek().next = head;
    //         stack.push(head);
    //         head = head.next;
    //     }
    //     return dummy.next;
    // }

    private String listToString(ListNode head) {
        if (head.next == null) {
            return String.valueOf(head.val);
        }
        return String.format("%d->%s", head.val, listToString(head.next));
    }
}
// @lc code=end

