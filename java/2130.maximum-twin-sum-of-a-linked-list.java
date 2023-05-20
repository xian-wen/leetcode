/*
 * @lc app=leetcode id=2130 lang=java
 *
 * [2130] Maximum Twin Sum of a Linked List
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
    public int pairSum(ListNode head) {
        ListNode mid = middle(head, head);
        mid = reverse(mid);
        int sum = 0;
        while (mid != null) {
            sum = Math.max(sum, head.val + mid.val);
            head = head.next;
            mid = mid.next;
        }
        return sum;
    }

    private ListNode middle(ListNode fast, ListNode slow) {
        if (fast == null || fast.next == null) {
            return slow;
        }
        return middle(fast.next.next, slow.next);
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reversed = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return reversed;
    }
}
// @lc code=end

